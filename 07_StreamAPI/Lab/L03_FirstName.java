package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class L03_FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split(" ");
        Set<Character> firstLetters = Arrays.stream(reader.readLine().split(" "))
                .map(letter -> letter.toUpperCase().charAt(0))
                .collect(Collectors.toSet());
        Optional<String> foundName = Arrays.stream(names)
                .filter(name -> firstLetters.contains(name.charAt(0)))
                .sorted()
                .findFirst();
        if (foundName.isPresent()) {
            System.out.println(foundName.get());
        } else {
            System.out.println("No match");
        }

    }
}
