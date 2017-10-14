package Lab;

import java.util.Scanner;

public class L01_ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.next();
        String secondString = scanner.next();
        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();
        scanner.nextLine();
        String thirdString = scanner.nextLine();
        int sumOfNumbers = firstInt + secondInt + thirdInt;
        System.out.printf("%s %s %s %d", firstString, secondString, thirdString, sumOfNumbers);
    }
}
