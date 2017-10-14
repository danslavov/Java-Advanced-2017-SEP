package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class L03_MathPotato {
    public static void main(String[] args) throws IOException {
        Map<Integer, LinkedList<String>> input = readInput();
        printResult(input);
    }

    private static Map<Integer,LinkedList<String>> readInput() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        LinkedList<String> players = new LinkedList<>();
        players.addAll(Arrays.asList(input));
        int cycle = Integer.parseInt(reader.readLine());
        Map<Integer, LinkedList<String>> result = new HashMap<>();
        result.put(cycle, players);
        return result;
    }

    private static void printResult(Map<Integer, LinkedList<String>> input) {
        Map.Entry<Integer, LinkedList<String>> entry =
                input.entrySet().iterator().next();
        List<String> players = entry.getValue();
        int cycleSize = entry.getKey();
        int index = 0;
        int counter = 1;
        int cycleCount = 0;

        while (players.size() > 1) {
            boolean incrementIndex = true;
            if (counter % cycleSize == 0) {
                cycleCount++;
                if (isPrime(cycleCount)) {
                    System.out.println("Prime " + players.get(index));
                    incrementIndex = false;
                } else {
                    System.out.println("Removed " + players.get(index));
                    players.remove(index);
                    incrementIndex = false;
                }
            }
            counter++;
            if (incrementIndex) {
                index++;
            }
            if (index >= players.size()) {
                index = 0;
            }
        }
        System.out.println("Last is " + players.get(0));
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
