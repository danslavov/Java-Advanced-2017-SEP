package Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P02_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Deque<Long> stack = new ArrayDeque<>();  // try Integer

        for (int i = 0; i < n; i++) {
            long[] commandArr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            byte command = (byte)commandArr[0];
            switch (command) {
                case 1:
                    long element = commandArr[1];
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    printMax(stack);
                    break;
            }
        }
    }

    private static void printMax(Deque<Long> stack) {
        long max = Long.MIN_VALUE;
        if (stack.isEmpty()) {
            max = 0L;
        } else {
            for (Long el : stack) {
                if (el > max) {
                    max = el;
                }
            }
        }
        System.out.println(max);
    }
}
