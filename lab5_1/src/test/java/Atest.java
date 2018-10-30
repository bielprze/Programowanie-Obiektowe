import org.junit.Test;
import org.junit.Assert;

/**
 * Created by student on 2018-10-30.
 */
public class Atest {
    @Test
    public void pierwszy_test(){
        Assert.assertEquals("pierwszy", A.met(1));
    }

    @Test
    public void drugi_test(){
        Assert.assertEquals("drugi", A.met(2));
    }

    @Test
    public void inny_test(){
        Assert.assertEquals("inny", A.met(3));
    }
}
