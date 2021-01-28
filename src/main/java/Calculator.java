public class Calculator {

    public int add(String input) {

        if (input.isEmpty())
            return 0;
        else if (input.contains(",") || input.contains("\n")) {
            int sum = 0;
            try {
                String[] numbers = input.split("[,\n]");
                for (String number : numbers) {
                    sum += Integer.parseInt(number);
                }
            } catch (Exception ex) {
                throw ex;
            }
            return sum;
        } else {
            return Integer.parseInt(input);
        }
    }

}
