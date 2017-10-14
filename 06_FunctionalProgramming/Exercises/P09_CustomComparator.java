package Exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P09_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Comparator<Integer> evenBeforeOdd = (a, b) -> {
          if ((a % 2 == 0) && (b % 2 != 0)) {
              return -1;
          } else if ((a % 2 != 0) && (b % 2 == 0)) {
              return 1;
          } else {
              return a.compareTo(b);
          }
        };

        Arrays.stream(arr)
                .sorted(evenBeforeOdd)
                .forEach(el -> System.out.print(el + " "));
    }
}
