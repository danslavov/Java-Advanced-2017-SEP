package Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P05_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            Consumer<int[]> action = createConsumer(command);
            action.accept(nums);
            command = scanner.nextLine();
        }
    }

    private static Consumer<int[]> createConsumer(String command) {
        switch (command) {
            case "add":
                return arr -> {
                    for (int i = 0; i < arr.length; i++) {
                        ++arr[i];
                    }
                };
            case "subtract":
                return arr -> {
                    for (int i = 0; i < arr.length; i++) {
                        --arr[i];
                    }
                };
            case "multiply":
                return arr -> {
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = arr[i] * 2;
                    }
                };
            default:
                return arr -> {
                    for (int el : arr) {
                        System.out.print(el + " ");
                    }
                    System.out.println();
                };
        }
    }
}
