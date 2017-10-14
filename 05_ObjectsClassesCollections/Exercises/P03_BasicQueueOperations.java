package Exercises;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P03_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numToPush = scanner.nextInt();
        int numToPop = scanner.nextInt();
        int elementToCheck = scanner.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numToPush; i++) {
            int elementToPush = scanner.nextInt();
            queue.add(elementToPush);
        }
        for (int i = 0; i < numToPop; i++) {
            queue.poll();
        }
        boolean isPresent = queue.contains(elementToCheck);
        if (isPresent) {
            System.out.println(true);
        } else {
            System.out.println(getMin(queue));
        }
    }

    private static int getMin(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (Integer el : queue) {
            if (el < min) {
                min = el;
            }
        }
        return min;
    }

}
