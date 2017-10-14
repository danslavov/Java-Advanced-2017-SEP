package Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class L05_FilterByAge {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Integer> people = readPeople();
        Object[] conditions = readConditions();
        printResult(people, conditions);
    }

    private static void printResult(Map<String, Integer> people, Object[] conditions) {
        Predicate<Integer> test = (Predicate<Integer>) conditions[0];
        Consumer<Map.Entry<String, Integer>> print = (Consumer<Map.Entry<String, Integer>>) conditions[1];
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (test.test(entry.getValue())) {
                print.accept(entry);
            }
        }

    }

    private static Object[] readConditions() {
        String condition = scanner.nextLine();          // older OR younger
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        Predicate<Integer> test = createPredicate(condition, age);
        Consumer<Map.Entry<String, Integer>> print = createConsumer(format);
        return new Object[] {test, print};
    }

    private static Consumer<Map.Entry<String, Integer>> createConsumer(String format) {
        switch (format) {
            case "name":
                return entry -> System.out.printf("%s%n", entry.getKey());
            case "age":
                return entry -> System.out.printf("%d%n", entry.getValue());
            case "name age":
                return entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
            default:
                return null;
        }
    }

    private static Predicate<Integer> createPredicate(String condition, int age) {
        switch (condition) {
            case "older":
                return currentAge -> currentAge >= age;
            case "younger":
                return currentAge -> currentAge < age;
            default:
                return null;
        }
    }

    private static Map<String, Integer> readPeople() {
        Map<String, Integer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            people.put(name, age);
        }
        return people;
    }
}
