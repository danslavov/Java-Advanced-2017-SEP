package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02_Searching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int key = Integer.parseInt(scanner.nextLine());
//        sortArray(input);   // works but not needed for this problem
//        int resultIndex = findIndexLinear(input, key);
        int resultIndex = findIndexBinary(input, key);
        System.out.println(resultIndex);

    }

    private static int findIndexBinary(int[] input, int key) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < input[mid]) {
                end = mid - 1;
            } else if (key > input[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int findIndexLinear(int[] input, int key) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static void sortArray(int[] input) {
        // bubble sort
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < input.length; i++) {
                int left = input[i - 1];
                int right = input[i];
                if (left > right) {
                    swap(input, i);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void swap(int[] input, int i) {
        int tmp = input[i];
        input[i] = input[i - 1];
        input[i - 1] = tmp;
    }
}
