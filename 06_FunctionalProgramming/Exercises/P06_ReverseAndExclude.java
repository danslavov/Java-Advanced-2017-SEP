package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06_ReverseAndExclude {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> nums = fillList();
        filterList(nums);
        reverseList(nums);
        printList(nums);
    }

    private static void filterList(List<Integer> nums) {
        int n = scanner.nextInt();
        nums.removeIf(num -> num % n == 0);
    }

    private static void printList(List<Integer> input) {
        for (Integer el : input) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    private static void reverseList(List<Integer> input) {
        for (int i = 0; i < input.size() / 2; i++) {
            int temp = input.get(i);
            input.set(i, input.get(input.size() - 1 - i));
            input.set(input.size() - 1 - i, temp);
        }
    }

    private static List<Integer> fillList() {
        String[] input = scanner.nextLine().split(" ");
        List<Integer> output = new ArrayList<>();
        for (String s : input) {
            output.add(Integer.parseInt(s));
        }
        return output;
    }
}
