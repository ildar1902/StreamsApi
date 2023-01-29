import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("    Задание 1.");
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(4, 99, 2, 18, 48, 33, 94)).stream();
        findMinMax(stream, Comparator.naturalOrder(), (x, y) -> System.out.println("min: " + x + ", max: " + y));
        System.out.println();
        System.out.println("    Задание 2.");
        getCountEvenNumbers(14, 3, 4, 5, 8, 12, 6, 7, 11, 19);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list;
        list = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (list.size() > 0) {
            T min = list.get(0);
            T max = list.get(list.size() - 1);
            minMaxConsumer.accept(min, max);
            if (min == null && max == null) {
                minMaxConsumer.accept(null, null);
            }
        }
    }

    public static void getCountEvenNumbers(Integer... n) {
        List<Integer> numbers = new ArrayList<>(List.of(n));
        List<Integer> evenNumbers = numbers.stream()
                .filter(e -> (e % 2 == 0))
                .toList();
        System.out.println("Количество чётных чисел - " + evenNumbers.size());
    }
}