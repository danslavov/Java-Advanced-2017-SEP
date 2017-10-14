package Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class L03_EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double quantity = scanner.nextDouble();
        double pricePerKg = quantity * 1.2;
        BigDecimal pricePerKgDecimal = new BigDecimal(pricePerKg);
        BigDecimal price = new BigDecimal("4210500000000").multiply(pricePerKgDecimal);
        System.out.printf("%.2f marks", price);
    }
}
