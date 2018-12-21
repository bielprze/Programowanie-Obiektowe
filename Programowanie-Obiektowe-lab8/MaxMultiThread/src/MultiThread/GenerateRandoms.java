package MultiThread;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandoms implements Runnable {
    int line;
    static int[][] numbers = new int[100][10000];

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            for(int j=0; j<10000; j++) {
                int rand = ThreadLocalRandom.current().nextInt(0, 1000);
                numbers[i][j] = rand;
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("randoms.txt"));
            for (int i=0; i<100 ; i++) {
                for (int j = 0; j < 10000; j++) {
                    writer.write("" + numbers[i][j]+" ");
                }
                writer.newLine();
            }
            writer.close();
        }
        catch(FileNotFoundException e)
        {

        }
        catch (IOException io)
        {

        }
    }
}
