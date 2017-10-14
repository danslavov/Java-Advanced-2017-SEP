package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] curIndex = {0};
        int[] sum = {0};
        int result = sumElements(input, curIndex, sum);
        System.out.println(result);
    }

    private static int sumElements(int[] input, int[] curIndex, int[] sum) {
        if (curIndex[0] < input.length) {
            sum[0] += input[curIndex[0]];
            curIndex[0]++;
            sumElements(input, curIndex, sum);
        }
        return sum[0];
    }
}
