import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void shouldTestEmptyString(){
        Assert.assertEquals(0,Calculator.add(""));
    }
}
