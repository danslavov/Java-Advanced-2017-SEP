package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class L05_MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble minNumber =
                Stream.of(reader.readLine().split(" "))
                        .filter(str -> !str.isEmpty())
                        .mapToDouble(Double::parseDouble)
                        .filter(num -> num % 2 == 0)
                        .min();

        if (minNumber.isPresent()) {
            System.out.printf("%.2f", minNumber.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
