package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L02_HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int cycle = Integer.parseInt(reader.readLine());
        List<String> players = new LinkedList<>();
        players.addAll(Arrays.asList(input));
        printResult(players, cycle);
    }

    private static void printResult(List<String> players, int cycle) {
        int index = 0;
        int counter = 1;
        while (players.size() > 1) {
            boolean notRemoved = true;
            if (counter % cycle == 0) {
                System.out.println("Removed " + players.get(index));
                players.remove(index);
                notRemoved = false;
            }
            counter++;
            if (notRemoved) {
                index++;
            }
            if (index >= players.size()) {
                index = 0;
            }
        }
        System.out.println("Last is " + players.get(0));
    }
}
