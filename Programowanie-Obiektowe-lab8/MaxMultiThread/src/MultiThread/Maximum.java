package MultiThread;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Maximum implements Runnable {

    int [] numbers1 = new int [1000000];
    public Maximum(int [] num)
    {
        for(int i=0; i<1000000; i++)
        {
            numbers1[i] = num[i];
        }
    }
    @Override
    public void run() {
        int max=numbers1[0];
        for(int i=1; i<1000000; i++)
        {
            if(numbers1[i]>max)
                max=numbers1[i];
        } try {
            PrintWriter pr = new PrintWriter("max.txt");
            pr.println("" + max);
            pr.close();
        }
        catch(FileNotFoundException e)
        {

        }
    }
}
