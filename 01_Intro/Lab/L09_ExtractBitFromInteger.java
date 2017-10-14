package Lab;

import java.util.Scanner;

public class L09_ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int index = scanner.nextInt();
        int extractedBit = (number >> index) & 1;
        System.out.println(extractedBit);
    }
}
