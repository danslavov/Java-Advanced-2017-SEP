package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {

        List<String> names = getInput();
        names.stream()
                .filter(n -> n.split(" ")[0].compareTo(n.split(" ")[1]) < 0)
                .forEach(System.out::println);
    }

    static List<String> getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = new ArrayList<>();
        while (true) {
            String name = reader.readLine();
            if ("END".equals(name)) {
                break;
            }
            if (!name.isEmpty()) {
                names.add(name);
            }
        }
        return names;
    }
}
