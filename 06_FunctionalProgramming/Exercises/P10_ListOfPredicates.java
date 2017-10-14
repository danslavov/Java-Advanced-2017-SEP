package Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisors = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .distinct()
                .collect(Collectors.toList());
        Set<Predicate<Integer>> predicates = getPredicates(divisors);
        printResult(n, predicates);
    }

    private static void printResult(int n, Set<Predicate<Integer>> predicates) {
        for (int dividend = 1; dividend <= n; dividend++) {
            boolean toPrint = true;
            for (Predicate<Integer> test : predicates) {
                if (test.test(dividend)) {
                    toPrint = false;
                    break;
                }
            }
            if (toPrint) {
                System.out.print(dividend + " ");
            }
        }
        System.out.println();
    }

    private static Set<Predicate<Integer>> getPredicates(List<Integer> divisors) {
        Set<Predicate<Integer>> predicates = new HashSet<>();
        for (int divisor : divisors) {
            Predicate<Integer> test = dividend -> dividend % divisor != 0;
            predicates.add(test);
        }
        return predicates;
    }
}
