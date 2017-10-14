package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P08_FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] input = scanner.nextLine().split(" ");
        int oddEven = input[2].equals("even") ? 0 : 1;
        int elementCount = Integer.parseInt(input[1]);

        findElements(nums, oddEven, elementCount);
    }

    private static void findElements(int[] nums, int oddEven, int elementCount) {
        for (int i = 0, counter = 1; i < nums.length && counter <= elementCount; i++) {
            if (Math.abs(nums[i] % 2) == oddEven) {
                System.out.print(nums[i] + " ");
                counter++;
            }
        }
        System.out.println();
    }
}