package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class L07_MapDistricts {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Map<String, List<Integer>> cities = getCityData();
        int minPopulation = Integer.parseInt(reader.readLine());
        cities.entrySet().stream()
                .filter(getFilterPredicate(minPopulation))
                .sorted((e1, e2) -> Integer.compare(sum.apply(e2.getValue()), sum.apply(e1.getValue())))
                .forEach(getPrintConsumer());
        }

    private static Map<String, List<Integer>> getCityData() throws IOException {

        List<String> input = Arrays.asList(reader.readLine().split(" "));
        Map<String, List<Integer>> cities = new HashMap<>();
        for (String element : input) {
            String[] tokens = element.split(":");
            String name = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            if (!cities.containsKey(name)) {                    // .putIfAbsent
                cities.put(name, new ArrayList<>());
            }
            cities.get(name).add(population);
        }
        return cities;
    }

    private static Consumer<Map.Entry<String,List<Integer>>> getPrintConsumer() {
        return e -> {
            System.out.print(e.getKey() + ": ");
            e.getValue().stream()
                    .sorted((pop1, pop2) -> Integer.compare(pop2, pop1))
                    .limit(5)
                    .forEach(pop -> System.out.print(pop + " "));
            System.out.println();
        };
    }

    private static Predicate<Map.Entry<String,List<Integer>>> getFilterPredicate(int minPopulation) {
        return e -> sum.apply(e.getValue()) > minPopulation;
    }

    private static Function<List<Integer>, Integer> sum = list -> {
        int sum = 0;
        for (int element : list) {
            sum += element;
        }
        return sum;
    };
}
