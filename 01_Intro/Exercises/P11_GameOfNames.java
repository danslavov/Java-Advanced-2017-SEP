package Exercises;

import java.util.*;

public class P11_GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> players = fillInput(scanner, count);
        findMaxPoints(players);
    }

    private static void findMaxPoints(LinkedHashMap<String, Integer> players) {
        int maxPoints = Integer.MIN_VALUE;
        int currentPoints;
        String winnerName = "";
        String currentName;

        for (Map.Entry<String, Integer> player : players.entrySet()) {
            currentName = player.getKey();
            currentPoints = player.getValue();
            for (char symbol : currentName.toCharArray()) {
                if (symbol % 2 == 0) {
                    currentPoints += symbol;
                } else {
                    currentPoints -= symbol;
                }
            }
            if (currentPoints > maxPoints) {
                maxPoints = currentPoints;
                winnerName = currentName;
            }
        }
        System.out.printf("The winner is %s - %d points", winnerName, maxPoints);
    }

    private static LinkedHashMap<String, Integer> fillInput(Scanner scanner, int count) {
        LinkedHashMap<String, Integer> players = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            int points = Integer.parseInt(scanner.nextLine());
            players.put(name, points);
        }
        return players;
    }
}
