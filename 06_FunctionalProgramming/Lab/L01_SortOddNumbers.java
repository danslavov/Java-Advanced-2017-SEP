package Lab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class L01_SortOddNumbers {       //Judge wants even
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s*,\\s*");
        List<Integer> nums = convertToList(input);
//        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isOdd = x -> x % 2 != 0;     // use this one
        Comparator<Integer> ascending = (x, y) -> x.compareTo(y);   // Integer::compareTo
        nums.removeIf(isOdd);
        printResult(nums);
        nums.sort(ascending);
        printResult(nums);
    }

    private static void printResult(List<Integer> nums) {
        if (nums.isEmpty()) {
            return;
        }
        StringBuilder result = new StringBuilder();
        for (Integer n : nums) {
            result.append(n);
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        System.out.println(result);
    }

    private static List<Integer> convertToList(String[] input) {
        List<Integer> output = new ArrayList<>();
        for (String s : input) {
            output.add(Integer.parseInt(s));
        }
        return output;
    }
}
