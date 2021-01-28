public class Calculator {
    public int add(String input) {
        if (input.isEmpty())
            return 0;
        else if (input.contains(",")) {
            String numbers[] = input.split(",");
            int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            return sum;
        } else {
            return Integer.parseInt(input);
        }
    }
}
