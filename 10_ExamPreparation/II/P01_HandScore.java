package II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class P01_HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        List<Integer> sequence = new ArrayList<>();
        char prevSuit = 'X';
        int result = 0;

        for (String card : input) {
            int value = getValue(card.substring(0, card.length() - 1));
            char suit = card.charAt(card.length() - 1);
            if (suit == prevSuit) {
                sequence.add(value);
            } else {
                result += sequence.size() * sum(sequence);
                prevSuit = suit;
                sequence.clear();
                sequence.add(value);
            }
        }
        result += sequence.size() * sum(sequence);
        System.out.println(result);
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        return sum;
    }

    private static int getValue(String face) {
        switch (face) {
            case "J": return 12;
            case "Q": return 13;
            case "K": return 14;
            case "A": return 15;
            default: return Integer.parseInt(face);
        }
    }
}
