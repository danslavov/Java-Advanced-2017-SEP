package Lab;

import java.util.Scanner;

public class L01_CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        float area = calculateArea();
        printResult(area);
    }

    private static void printResult(float area) {
        System.out.printf("Area = %.2f", area);
    }

    private static float calculateArea() {
        Scanner scanner = new Scanner(System.in);
        float base = scanner.nextFloat();
        float height = scanner.nextFloat();
        return base * height / 2f;
    }
}
