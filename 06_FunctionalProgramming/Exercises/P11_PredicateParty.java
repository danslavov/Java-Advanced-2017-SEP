package Exercises;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P11_PredicateParty {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> guests = getPeople();
        List<String> result = processCommands(guests);
        printResult(result);
    }

    private static void printResult(List<String> guests) {
        if (guests.size() > 0) {
            String result = String.join(", ", guests)
                    + " are going to the party!";
            System.out.println(result);
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static List<String> processCommands(List<String> guests) {
        while (true) {
            String[] command = scanner.nextLine().split(" ");
            String action = command[0];
            if (action.equals("Party!")) {
                break;
            }
            String condition = command[1];
            String value = command[2];
            Predicate<String> test =
                    getPredicate(condition, value);
            BiConsumer<List<String>, Predicate<String>> guestArranger =
                    getPredicate(action);
            guestArranger.accept(guests, test);
        }
        return guests;
    }

    private static BiConsumer<List<String>, Predicate<String>> getPredicate(String action) {
        switch (action) {
            case "Remove":
                return Collection::removeIf;
            case "Double":
                return (list, test) -> {
                    for (int i = 0; i < list.size(); i++) {
                        if (test.test(list.get(i))) {
                            list.add(i, list.get(i));
                        }
                    }
                };
            default:
                return null;
        }
    }

    private static Predicate<String> getPredicate(String condition, String value) {
        switch (condition) {
            case "StartsWith":
                return guest -> guest.startsWith(value);
            case "EndsWith":
                return guest -> guest.endsWith(value);
            case "Length":
                return guest -> guest.length() == Integer.parseInt(value);
            default:
                return null;
        }
    }

    private static List<String> getPeople() {
        return Stream.of(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
    }
}
