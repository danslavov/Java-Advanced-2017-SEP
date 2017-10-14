package Exercises;

import java.util.Scanner;

public class P01_CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        String key = scanner.nextLine().toLowerCase();
        int counter = 0;
        int start = 0;

        while (true) {
            String sub = input.substring(start);
            int subIndex = sub.indexOf(key);
            if (subIndex < 0) {
                break;
            }
            start += subIndex;
            counter++;
            start++;
        }
        System.out.println(counter);
    }
}
