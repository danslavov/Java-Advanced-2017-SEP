package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (numbers.length % 2 == 1) {
            System.out.println("invalid length");
            return;
        }
        for (int i = 0; i < numbers.length - 1; i += 2) {
            int current = numbers[i];
            int next = numbers[i + 1];
            if ((current % 2 == 0) && next % 2 == 0) {
                System.out.printf("%d, %d -> both are even", current, next);
            } else if ((current % 2 == 1) && next % 2 == 1) {
                System.out.printf("%d, %d -> both are odd", current, next);
            } else {
                System.out.printf("%d, %d -> different", current, next);
            }
            System.out.println();
        }
    }
}
