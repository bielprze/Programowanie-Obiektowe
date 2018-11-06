package excp;
import java.io.*;
/**
 * Created by student on 2018-11-06.
 */
public class TooBigNumberException extends Exception {
    private double number;
    public TooBigNumberException(double x)
    {
        this.number=x;
    }
    public double getNumber()
    {
        return this.number;
    }
}
