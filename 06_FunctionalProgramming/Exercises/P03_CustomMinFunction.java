package Exercises;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class P03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Stream.of(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> findMin = arr -> {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        };
        System.out.println(findMin.apply(nums));
    }
}
