package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class L08_BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int lowerBound = Math.min(bounds[0], bounds[1]);
        int upperBound = Math.max(bounds[0], bounds[1]);
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .filter(num -> num >= lowerBound && num <= upperBound)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
