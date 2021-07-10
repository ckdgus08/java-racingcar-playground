import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int splitAndSum(String input) {
        if (isNullOrEmpty(input))
            return 0;

        String[] numbers = input.split(",|:");

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
        }

        return Arrays.stream(numbers)
                .filter(this::isValid)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isValid(String element) {
        if (Integer.parseInt(element) < 0)
            throw new RuntimeException("음수는 입력으로 올 수 없습니다.");
        return true;
    }

    private boolean isNullOrEmpty(String input) {
        if (input == null || input.isEmpty())
            return true;
        return false;
    }
}
