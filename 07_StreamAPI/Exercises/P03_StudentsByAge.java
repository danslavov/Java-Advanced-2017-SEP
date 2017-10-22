package Exercises;

import java.io.IOException;
import java.util.List;

import static Exercises.P02_StudentsByFirstAndLastName.getInput;    // cannot be accessed by Judge

public class P03_StudentsByAge {
    public static void main(String[] args) throws IOException {
        List<String> names = getInput();
        names.stream()
                .filter(n -> 18 <= Integer.valueOf(n.split(" ")[2]))
                .filter(n -> Integer.valueOf(n.split(" ")[2]) <= 24)
                .forEach(System.out::println);

    }
}
