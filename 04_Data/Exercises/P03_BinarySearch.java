package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03_BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int key = Integer.parseInt(scanner.nextLine());
        findKeyIndex(input, key, 0, input.length - 1);
    }

    private static void findKeyIndex(int[] input, int key, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (key < input[mid]) {
                findKeyIndex(input, key, start, mid - 1);
            } else if (key > input[mid]) {
                findKeyIndex(input, key, mid + 1, end);
            } else {
                System.out.println(mid);
            }
        } else {
            System.out.println(-1);
        }
    }
}
