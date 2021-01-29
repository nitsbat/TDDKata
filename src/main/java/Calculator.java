import java.rmi.server.ObjID;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    public int add(String input) {

        if (input.isEmpty())
            return 0;
        else {
            return calculateSum(input);
        }
    }

    private int calculateSum(String input) {
        int sum;
        try {
            String[] numbers = generateNumbers(input);
            List<Integer> negativeNumbers = areNegativeNumbersPresent(numbers);
            if (negativeNumbers.size() > 0) {
                String message = negativeNumbers.stream().map(Object::toString).collect(Collectors.joining(","));
                throw new RuntimeException("Negatives Not Allowed : " + message);
            }
            sum = getSumOfNumbers(numbers);
        } catch (Exception exception) {
            throw exception;
        }
        return sum;
    }

    private List<Integer> areNegativeNumbersPresent(String[] numbers) {
        List<Integer> integerList = new ArrayList<>();
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0)
                integerList.add(Integer.parseInt(number));
        }
        return integerList;
    }

    private int getSumOfNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private String[] generateNumbers(String input) {
        if (input.startsWith("//")) {
            return getNumbersSeparatedByRegexDelimiter(input);
        } else {
            return getNumbersSeparatedByCommaAndNewLine(input);
        }
    }

    private String[] getNumbersSeparatedByCommaAndNewLine(String input) {
        return input.split("[,\n]");
    }

    private String[] getNumbersSeparatedByRegexDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        matcher.matches();
        String delimiter = matcher.group(1);
        String str = matcher.group(2);
        return str.split(delimiter);
    }
}
