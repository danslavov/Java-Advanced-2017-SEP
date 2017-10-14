package Exercises;

import java.util.Scanner;
import java.util.function.Predicate;

public class P07_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");
        Predicate<String> isSmaller = name -> name.length() <= limit;
        for (String name : names) {
            if (isSmaller.test(name)) {
                System.out.println(name);
            }
        }
    }
}
