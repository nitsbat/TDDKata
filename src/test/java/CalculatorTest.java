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
    public void shouldTestWhenMultipleNumbersAreOnString() {
        Assert.assertEquals(22, calculator.add("3,7,1,9,2"));
    }

    @Test
    public void shouldTestWhenMultipleNumbersAndDelimiterIsNewLineAndComma() {
        Assert.assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test(expected = Exception.class)
    public void shouldTestWhenDelimiterIsOtherNewLineAndComma() {
        calculator.add("1\n2,/3");
    }

    @Test
    public void shouldAcceptDifferentDelimiters() {
        Assert.assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionOnNegativeNumbers() {
        calculator.add("-1,-2,5");
    }

    @Test
    public void shouldThrowExceptionWithMessageOnNegativeNumbers() {
        try {
            calculator.add("-1,-2,5");
        } catch (Exception ex) {
            Assert.assertEquals("Negatives Not Allowed : -1,-2", ex.getMessage());
        }
    }

    @Test
    public void shouldThrowExceptionOnNegativeWithDiffDelimiters() {
        try {
            calculator.add("1\n2,-3");
        } catch (Exception ex) {
            Assert.assertEquals("Negatives Not Allowed : -3", ex.getMessage());
        }
    }

    @Test
    public void shouldNotConsiderNumberMoreThan1000() {
        Assert.assertEquals(3, calculator.add("1\n2,1002"));

    }
}
