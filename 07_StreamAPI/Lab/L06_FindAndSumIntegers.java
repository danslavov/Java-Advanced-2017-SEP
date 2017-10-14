package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Function;

public class L06_FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Boolean> checkIfIsNumber = str -> {
            if (str.isEmpty()) {
                return false;
            }
            boolean startsWithSignOrDigit =
                    str.charAt(0) == '+' || str.charAt(0) == '-' ||
                            (str.charAt(0) >= '0' && str.charAt(0) <= '9');
            if (!startsWithSignOrDigit) {
                return false;
            }
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        };
        OptionalInt min = Arrays.stream(reader.readLine().split(" "))
                .filter(checkIfIsNumber::apply)
                .mapToInt(Integer::valueOf)
                .reduce((a, b) -> a + b);
        System.out.println(min.isPresent() ? min.getAsInt() : "No match");
    }
}
