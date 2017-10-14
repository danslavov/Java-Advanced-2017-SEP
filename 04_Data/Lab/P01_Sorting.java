package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
//        selectionSort(input);
        bubbleSort(input);
        printResult(input);
    }

    private static void bubbleSort(int[] arr) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < arr.length; i++) {
                int left = arr[i - 1];
                int right = arr[i];
                if (left > right) {
                    swap(arr, (i - 1), i);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void printResult(int[] input) {
        String result = Arrays.stream(input)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int current = i + 1; current < arr.length; current++) {
                if (arr[current] < arr[min]) {
                    min = current;
                }
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
