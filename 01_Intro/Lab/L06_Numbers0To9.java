package Lab;

import java.util.Scanner;

public class L06_Numbers0To9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte counter = 0;
        while (counter < 10) {
            System.out.println("Number: " + counter);
            counter++;
        }
    }
}
