package Lab;

import java.util.Scanner;

public class L02_AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();
        double average = (firstNum + secondNum + thirdNum) / 3;
        System.out.printf("%.2f", average);
    }
}
