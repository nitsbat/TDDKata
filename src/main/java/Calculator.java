public class Calculator {
    public int add(String input) {
        if (input.isEmpty())
            return 0;
        else if (input.contains(",")) {
            String[] numbers = input.split(",");
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
            return sum;
        } else {
            return Integer.parseInt(input);
        }
    }
}
