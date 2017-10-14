package Exercises;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P08_FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Stream
                .of(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> findMin = list -> {
            int minIndex = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) <= list.get(minIndex)) {
                    minIndex = i;
                }
            }
            return minIndex;
        };
        System.out.println(findMin.apply(nums));
    }
}
