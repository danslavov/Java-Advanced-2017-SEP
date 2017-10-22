package II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04_FootballStats {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Map<String, List<Map.Entry<String, String>>> teams = getAndSortInput();
        sortAndPrintResult(teams);
    }

    private static void sortAndPrintResult(Map<String, List<Map.Entry<String, String>>> teams) throws IOException {
        String[] query = reader.readLine().split(", ");
        for (String team : query) {
            teams.entrySet().stream()
                    .filter(t -> t.getKey().equals(team))
                    .forEach(t -> t.getValue().stream()
                            .sorted(Comparator.comparing(Map.Entry::getKey))
                            .forEach(match -> {
                        System.out.printf("%s - %s -> %s%n", t.getKey(), match.getKey(), match.getValue());
                    }));
        }
    }

    private static Map<String, List<Map.Entry<String, String>>> getAndSortInput() throws IOException {
        Map<String, List<Map.Entry<String, String>>> teams = new HashMap<>();

        String input = reader.readLine();
        while (!input.equals("Season End")) {

            String[] tokens = input.split(" ");
            String host = tokens[0];
            String guest = tokens[2];
            String result = tokens[4];

            fillMap(teams, host, guest, result);
            fillMap(teams, guest, host, reverse(result));

            input = reader.readLine();
        }
        return teams;

//        // sort by name (ascending) then by result (descending)
//        Comparator<Map.Entry<String, String>> customComp = (e1, e2) -> {
//            String opponent1 = e1.getKey();
//            String opponent2 = e2.getKey();
//            if (opponent1.compareTo(opponent2) == 0) {
//                String result1 = e1.getValue();
//                String result2 = e2.getValue();
//                return result2.compareTo(result1);
//            } else {
//                return opponent1.compareTo(opponent2);
//            }
//        };
//        Map<String, List<Map.Entry<String, String>>> sorted = new HashMap<>();
//        for (Map.Entry<String, List<Map.Entry<String, String>>> team : teams.entrySet()) {
//            List<Map.Entry<String, String>> matches = team.getValue().stream()
//                    .sorted(customComp)
//                    .collect(Collectors.toList());
//            sorted.put(team.getKey(), matches);
//        }

//        return sorted;
    }

    private static void fillMap(
            Map<String, List<Map.Entry<String, String>>> map, String team, String opponent, String result) {
        map.putIfAbsent(team, new LinkedList<>());
        map.get(team).add(new AbstractMap.SimpleEntry<>(opponent, result));
    }

    private static String reverse(String input) {
        StringBuilder reversed = new StringBuilder();
        for (char letter : input.toCharArray()) {
            reversed.insert(0, letter);
        }
        return reversed.toString();
    }
}

