/* The slower methods for printing output
   and especially for getting input fail the last Judge test.
   Slower processing method makes almost no difference.
*/

package I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P02_Earthquake {
    public static void main(String[] args) throws IOException {
//        Queue<List<Integer>> activities = getInputSlower();
        Queue<List<Integer>> activities = getInputFaster();
        List<Integer> result = processActivities(activities);
//        printResultSlower(result);
        printResultFaster(result);
    }

    private static Queue<List<Integer>> getInputFaster() throws IOException {
        Queue<List<Integer>> activities = new ArrayDeque<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            List<Integer> activity = new ArrayList<>();
            for (String s : line) {
                activity.add(Integer.parseInt(s));
            }
            activities.offer(activity);
        }
        return activities;
    }

    private static List<Integer> processActivities(Queue<List<Integer>> activities) {
        List<Integer> result = new ArrayList<>();
        while (!activities.isEmpty()) {
            List<Integer> current = activities.poll();
//            processSlower(activities, result, current);
            processFaster(activities, result, current);
        }
        return result;
    }

    private static void processFaster(Queue<List<Integer>> activities, List<Integer> result, List<Integer> current) {
        int seismicity = current.get(0);
        for (int i = 1; i < current.size(); i++) {
            int wave = current.get(i);
            if (seismicity < wave) {
                activities.offer(current.subList(i, current.size()));
                break;
            }
        }
        result.add(seismicity);
    }

    private static void printResultFaster(List<Integer> result) {
        System.out.println(result.size());
        System.out.println(
                Arrays.toString(result.toArray())
                        .replaceAll("[\\[\\],]", ""));
    }

    private static Queue<List<Integer>> getInputSlower() throws IOException {
        Queue<List<Integer>> activities = new ArrayDeque<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            List<Integer> activity = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::valueOf)
                    .boxed()
                    .collect(Collectors.toList());
            activities.offer(activity);
        }
        return activities;
    }

    private static void processSlower(Queue<List<Integer>> activities, List<Integer> result, List<Integer> current) {
        while (current.size() > 1) {
            int seismicity = current.get(0);
            int wave = current.get(1);
            if (seismicity >= wave) {
                current.remove(1);
            } else {
                break;
            }
        }
        result.add(current.get(0));
        current.remove(0);
        if (!current.isEmpty()) {
            activities.offer(current);
        }
    }

    private static void printResultSlower(List<Integer> result) {
        String toPrint = result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.printf("%d%n%s", result.size(), toPrint);
    }
}