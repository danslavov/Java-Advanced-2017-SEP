package Exercises;

import java.util.Scanner;
import java.util.TreeSet;

public class P05_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[\\s,.?!]+");
        TreeSet<String> result = collectPalindromes(input);
        System.out.println(result.toString());
    }

    private static TreeSet<String> collectPalindromes(String[] input) {
        TreeSet<String> result = new TreeSet<>();
        for (String s : input) {
            boolean isPalindrome = true;
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                result.add(s);
            }
        }
        return result;
    }
}
