package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P12_StudentsJoinedToSpecialties {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Set<StudentOrSpecialty> specialties = getInput("Students:", 0, 1, 2);
        Set<StudentOrSpecialty> students = getInput("END", 1, 2, 0);
        printResult(students, specialties);
    }

    private static void printResult(
            Set<StudentOrSpecialty> students, Set<StudentOrSpecialty> specialties) {
        students.stream()
                .sorted(Comparator.comparing(StudentOrSpecialty::getName))
                .forEach(student -> {
                    specialties
                            .stream()
                            .filter(spec -> student.getNumber() == (spec.getNumber()))
                            .forEach(spec -> System.out.printf("%s %d %s%n",
                                    student.getName(), student.getNumber(), spec.getName()));
                });
    }

    private static Set<StudentOrSpecialty> getInput(
            String stop, int firstName, int lastName, int numberIndex) throws IOException {
        Set<StudentOrSpecialty> result = new HashSet<>();
        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if (stop.equals(input[0])) {
                break;
            }
            String name = input[firstName] + " " + input[lastName];
            int number = Integer.parseInt(input[numberIndex]);
            result.add(new StudentOrSpecialty(name, number));
        }
        return result;
    }
}

class StudentOrSpecialty {

    private String name;
    private int number;

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getNumber() {
        return this.number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    StudentOrSpecialty(String name, int number) {
        this.name = name;
        this.number = number;
    }

    StudentOrSpecialty() {
    }
}


