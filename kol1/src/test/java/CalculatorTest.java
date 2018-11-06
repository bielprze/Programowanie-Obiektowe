/**
 * Created by student on 2018-11-06.
 */
import excp.DividieByZeroException;
import excp.TooBigNumberException;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
    @Test
    public void AddTest()
    {
        double result = new Calculator().Add(5).Add(7).GetResult();
        Assert.assertEquals(12,result, 1.e-15);
    }
    @Test
    public void throwsExc() throws DividieByZeroException{
        double result = new Calculator().Add(12).Divide(0).GetResult();
    }
}
