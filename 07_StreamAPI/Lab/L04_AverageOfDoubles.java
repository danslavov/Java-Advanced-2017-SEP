package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class L04_AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble average =
                Stream.of(reader.readLine().split("\\s+"))
                        .filter(str -> !str.isEmpty())
                        .mapToDouble(Double::valueOf)
                        .average();
        if (average.isPresent()) {
            System.out.printf("%.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
