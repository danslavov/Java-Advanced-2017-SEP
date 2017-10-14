package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        printElementsPreAction(arr, arr.length - 1);
//        printElementsPostAction(arr, 0);
        System.out.println();
    }

    private static void printElementsPostAction(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        printElementsPostAction(arr, index + 1);
        System.out.print(arr[index] + " ");
    }

    private static void printElementsPreAction(int[] arr, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(arr[index] + " ");
        printElementsPreAction(arr, index - 1);
    }
}
