package MultiThread;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Minimum implements Runnable {

    int mini;
    int [] numbers2 = new int [1000000];
    public Minimum(int [] num)
    {
        for(int i=0; i<1000000; i++)
        {
            numbers2[i] = num[i];
        }
    }
    @Override
    public void run() {
        int min=numbers2[0];
        for(int i=1; i<1000000; i++)
        {
            if(numbers2[i]<min)
                min=numbers2[i];
        } try {
            PrintWriter pr = new PrintWriter("min.txt");
            pr.println("" + min);
            pr.close();
        }
        catch(FileNotFoundException e)
        {

        }
    }
}
