package Exercises;

import java.util.Scanner;

public class P03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String first = String.format("%-10s", Integer
                .toHexString(a).toUpperCase());
        String second = String.format("%10s", Integer
                .toBinaryString(a));
        second = second.replace(' ', '0');
        String third = String.format("%10.2f", b);
        String fourth = String.format("%-10.3f", c);
        System.out.printf("|%s|%s|%s|%s|", first, second, third, fourth);
    }
}
