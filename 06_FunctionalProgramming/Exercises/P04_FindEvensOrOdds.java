package Exercises;

import java.util.Scanner;
import java.util.function.Predicate;

public class P04_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int stop = scanner.nextInt();
        scanner.nextLine();
        String evenOdd = scanner.nextLine();
        Predicate<Integer> test = createPredicate(evenOdd);
        printResult(start, stop, test);
    }

    private static void printResult(int start, int stop, Predicate<Integer> test) {
        for (int i = start; i <= stop; i++) {
            if (test.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> createPredicate(String evenOdd) {
        if (evenOdd.equals("even")) {
            return n -> n % 2 == 0;
        } else {
            return n -> n % 2 != 0;
        }
    }
}
