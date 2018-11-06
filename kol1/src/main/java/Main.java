import excp.DividieByZeroException;

import java.io.Console;
import static java.lang.System.out;
/**
 * Created by student on 2018-11-06.
 */
public class Main {
    public static void main(String[] argv) {
        double result = new Calculator().Add(5).Add(7).GetResult(); //Dodawanie 5+7
        System.out.println("Dodawanie: " + result);

        result = new Calculator().Add(5).Subtract(7).GetResult(); //Odejmowanie 5-7
        System.out.println("Odejmowanie: " + result);

        result = new Calculator().Add(15).Multiply(10).GetResult(); //Mnożenie 15*10
        System.out.println("Mnożenie: " + result);

        try {
            result = new Calculator().Add(12).Divide(0).GetResult(); //Dzielenie 12/3
            System.out.println("Dzielenie: " + result);
        }
        catch(DividieByZeroException e)
        {
        }
        try {
            result = new Calculator().Add(12).Divide(6).GetResult(); //Dzielenie 12/3
            System.out.println("Dzielenie: " + result);
        }
        catch(DividieByZeroException e)
        {
        }

    }
}
