package Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L02_EncryptSortPrintArray {
    public static void main(String[] args) {
        int[] numbers = fillStrings();
        sortAndPrintResult(numbers);
    }

    private static void sortAndPrintResult(int[] numbers) {
        Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static int[] fillStrings() {
        Scanner scanner = new Scanner(System.in);
        byte arrLength = Byte.parseByte(scanner.nextLine());
        int[] numbers = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            String name = scanner.nextLine();
            numbers[i] = calculateNumber(name);
        }
        return numbers;
    }

    private static int calculateNumber(String name) {
        List<Character> vowels = Arrays.asList(
                'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        int result = 0;
        for (char letter : name.toCharArray()) {
            if (vowels.contains(letter)) {
                result += letter * name.length();
            } else {
                result += letter / name.length();
            }
        }
        return result;
    }
}
