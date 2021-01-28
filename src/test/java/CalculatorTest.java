import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void shouldTestEmptyString() {
        Assert.assertEquals(0, calculator.add(""));
    }

    @Test
    public void shouldTestOnlyOneNumberOnString() {
        Assert.assertEquals(2, calculator.add("2"));
    }

    @Test
    public void shouldTestWhenTwoNumbersAreOnString() {
        Assert.assertEquals(7, calculator.add("2,5"));
    }

    @Test
    public void shouldTestWhenMultipleStringsAreOnString() {
        Assert.assertEquals(22, calculator.add("3,7,1,9,2"));
    }
}
