package Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class L04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        UnaryOperator<Double> addVAT = n -> n * 1.2;
        System.out.println("Prices with VAT:");
        for (double n : numbers) {
            String result = String.format("%.2f%n", addVAT.apply(n))
                    .replace('.', ',');
            System.out.printf(result);
        }
    }
}
