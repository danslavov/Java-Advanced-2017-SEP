package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L06_AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int length = Integer.parseInt(reader.readLine());
        String[] students = new String[length];
        List<Double> averageGrades = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            // write student name
            students[i] = reader.readLine();

            // write average grade
            averageGrades.add(calculateAverage(reader.readLine()));
        }

        printResult(students, averageGrades);


    }

    private static double calculateAverage(String input) {
        double[] grades = Arrays.stream(input.split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    private static void printResult(String[] students, List<Double> averageGrades) {
        for (int i = 0; i < students.length; i++) {
            String avg = cutZeroes(averageGrades.get(i));
            System.out.printf("%s is graduated with %s%n",
                    students[i], avg);
        }
    }

    private static String cutZeroes(double num) {
        String numAsString = Double.toString(num);
        int index = numAsString.length() - 1;
        for (int i = numAsString.length() - 1; i < 1; i--) {
            if (numAsString.charAt(i) == '0') {
                index--;
            }
        }
        return numAsString.substring(0, index + 1);
    }
}
