package Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P01_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numToPush = scanner.nextInt();
        int numToPop = scanner.nextInt();
        int elementToCheck = scanner.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numToPush; i++) {
            int elementToPush = scanner.nextInt();
            stack.push(elementToPush);
        }
        for (int i = 0; i < numToPop; i++) {
            stack.pop();
        }
        boolean isPresent = stack.contains(elementToCheck);
        if (isPresent) {
            System.out.println(true);
        } else {
            System.out.println(getMin(stack));
        }
    }

    private static int getMin(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (Integer el : stack) {
            if (el < min) {
                min = el;
            }
        }
        return min;
    }
}
