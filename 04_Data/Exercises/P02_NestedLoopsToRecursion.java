package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_NestedLoopsToRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int result[] = new int[n];
        printResult(n, 0, result);
    }

    private static void printResult(int n, int index, int[] result) {
        if (index >= n) {

            // this print takes too much time in Judge:
//            System.out.println(Arrays.stream(result)
//                    .mapToObj(String::valueOf)
//                    .collect(Collectors.joining(" ")));

            System.out.println(Arrays.toString(result).
            replace("[", "")
            .replace("]", "")
            .replace(",", ""));

        } else {
            for (int value = 1; value <= n; value++) {
                result[index] = value;
                printResult(n, index + 1, result);
            }
        }
    }
}
