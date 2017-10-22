package I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P04_Highscore {    // 90/100

    public static void main(String[] args) throws IOException {
        Map<String, LinkedList<Map.Entry<String, Long>>> players = getInput();
        List<Map.Entry<String, Long>> sortedPlayers = sortPlayersByScore(players);
        printResult(players, sortedPlayers);
    }

    private static Map<String, LinkedList<Map.Entry<String, Long>>> getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, LinkedList<Map.Entry<String, Long>>> players = new HashMap<>();

        String[] input = reader.readLine().split("<->");

        while (!"osu!".equals(input[0])) {
            String[] firstPlayer = input[0].split(" ");
            String[] secondPlayer = input[1].split(" ");
            String firstPlayerName = firstPlayer[1];
            String secondPlayerName = secondPlayer[0];
            long firstPlayerScores = Long.parseLong(firstPlayer[0]);
            long secondPlayerScores = Long.parseLong(secondPlayer[1]);

            enterPlayerAndDuel(
                    players, firstPlayerName, secondPlayerName,
                    firstPlayerScores - secondPlayerScores);
            enterPlayerAndDuel(
                    players, secondPlayerName, firstPlayerName,
                    secondPlayerScores - firstPlayerScores);

            input = reader.readLine().split("<->");
        }

        return players;
    }

    private static void enterPlayerAndDuel(
            Map<String, LinkedList<Map.Entry<String, Long>>> map,
            String playerName, String opponentName, long scores) {
        if (!map.containsKey(playerName)) {
            map.put(playerName, new LinkedList<>());
        }
        map.get(playerName).add(new AbstractMap.SimpleEntry<>(opponentName, scores));
    }

    private static List<Map.Entry<String, Long>> sortPlayersByScore(
            Map<String, LinkedList<Map.Entry<String, Long>>> players) {
        List<Map.Entry<String, Long>> namesAndScores = new LinkedList<>();

        for (Map.Entry<String, LinkedList<Map.Entry<String, Long>>> player : players.entrySet()) {
            String name = player.getKey();
            long totalScore = 0L;
            for (Map.Entry<String, Long> duel : player.getValue()) {
                totalScore += duel.getValue();
            }
            namesAndScores.add(new AbstractMap.SimpleEntry<>(name, totalScore));
        }

        return namesAndScores.stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toList());
    }

    private static void printResult(
            Map<String, LinkedList<Map.Entry<String, Long>>> players,
            List<Map.Entry<String, Long>> sortedPlayers) {
        for (Map.Entry<String, Long> p : sortedPlayers) {
            System.out.printf("%s - (%d)%n", p.getKey(), p.getValue());
            for (Map.Entry<String, Long> duel : players.get(p.getKey())) {
                System.out.printf("*   %s <-> %d%n", duel.getKey(), duel.getValue());
            }
        }
    }
}