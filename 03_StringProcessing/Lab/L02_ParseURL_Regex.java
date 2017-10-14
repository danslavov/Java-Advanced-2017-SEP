// Judge 20/100

package Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L02_ParseURL_Regex {
    public static void main(String[] args) {
        Matcher matcher = matchInput();
        processAndPrintResult(matcher);
    }

    private static void processAndPrintResult(Matcher matcher) {
        if (matcher.matches()) {
            String protocol = matcher.group("protocol");
            String server = matcher.group("server");
            String resources = matcher.group("resources");
            System.out.printf("Protocol = %s\nServer = %s\nResources = %s",
                    protocol, server, resources);
        } else {
            System.out.println("Invalid URL");
        }
    }

    private static Matcher matchInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(
                "(?<protocol>^[a-z]+(?=:\\/\\/))\\:\\/\\/(?<server>[A-Za-z.]+)\\/(?<resources>[A-Za-z\\/-]+)$");
        return pattern.matcher(input);
    }
}
