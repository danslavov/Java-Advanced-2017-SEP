package Lab;

import java.util.Scanner;

public class L10_ModifyBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        byte index = scanner.nextByte();
        byte bitValue = scanner.nextByte();
        int result;

        if (bitValue == 0) {
            int mask = ~(1 << index);
            result = number & mask;
        } else {
            int mask = 1 << index;
            result = number | mask;
        }
        System.out.println(result);
    }
}
