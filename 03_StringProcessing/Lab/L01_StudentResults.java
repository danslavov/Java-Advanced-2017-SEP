package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L01_StudentResults {
    public static void main(String[] args) {
        List<Double> grades = new ArrayList<>();
        String name = readInput(grades);
        printResult(name, grades);
    }

    private static String readInput(List<Double> grades) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("-");
        Arrays.stream(input[1].split(","))
                .forEach(s -> grades.add(Double.parseDouble(s.trim())));
        return input[0].trim();
    }

    private static void printResult(String name, List<Double> grades) {
        double average = grades.stream().mapToDouble(g -> g)
                .sum() / grades.size();
        System.out.printf("%-10s|%7s|%7s|%7s|%7s|\n",
                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|",
                name, grades.get(0), grades.get(1), grades.get(2), average);
    }
}
