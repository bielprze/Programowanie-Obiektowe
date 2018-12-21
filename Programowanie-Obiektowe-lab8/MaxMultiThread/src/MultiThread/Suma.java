package MultiThread;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Suma implements Runnable{

    int [] numbers3= new int [1000000];
    public Suma(int [] num)
    {
        for(int i=0; i<1000000; i++)
        {
            numbers3[i] = num[i];
        }
    }
    @Override
    public void run() {
        long sumaa=0;
        for(int i=0; i<1000000; i++)
        {
            sumaa+=numbers3[i];
        }
        try {
            PrintWriter pr = new PrintWriter("suma.txt");
            pr.println("" + sumaa);
            pr.close();
        }
        catch(FileNotFoundException e)
        {

        }
    }
}
