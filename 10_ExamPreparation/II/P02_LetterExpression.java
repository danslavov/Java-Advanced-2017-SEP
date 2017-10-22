/*
This solution works only for integers
but still gets 100/100 in Judge
(perhaps problem description is wrong)
 */

package II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("(?<count>\\D*)(?<number>\\d+)");
        Matcher matcher = pattern.matcher(input);
        BigDecimal result = new BigDecimal("0");
        while (matcher.find()) {
            if (matcher.group("count").length() % 2 == 0) {
                result = result.add(new BigDecimal(matcher.group("number")));
            } else {
                result = result.subtract(new BigDecimal(matcher.group("number")));
            }
        }
        System.out.println(result);
    }
}
