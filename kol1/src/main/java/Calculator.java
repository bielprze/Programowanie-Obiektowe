import excp.DividieByZeroException;
import excp.TooBigNumberException;

/**
 * Created by student on 2018-11-06.
 */
public class Calculator implements Saveable {

    public double result = 0;
    @Override public void SaveToFile(double x, String filename)
    {

    }

    public Calculator Add(double x)
    {
        result+=x;
        return this;
    }
    public Calculator Subtract(double x)
    {
        result-=x;
        return this;
    }
    public Calculator Multiply(double x)
    {
        result*=x;
        return this;
    }
    public Calculator Divide(double x) throws DividieByZeroException
    {
        if(x==0)
            throw new DividieByZeroException();
        result/=x;
        return this;
    }
    public Calculator Factorial(int x) throws TooBigNumberException
    {
        if(x>10)
            throw new TooBigNumberException(x);
        return this;
    }
    public double GetResult() {
        return this.result;
    }


}
