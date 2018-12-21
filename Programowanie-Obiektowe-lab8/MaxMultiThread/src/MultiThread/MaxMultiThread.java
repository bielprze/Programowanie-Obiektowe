package MultiThread;

import java.io.*;
import java.util.Scanner;

public class MaxMultiThread {
    int [] numbers0 = new int[100000];


    public void calculateFunction(int functionType) throws IOException {


        File rand_txt = new File("randoms.txt");
        Scanner scanner = new Scanner(rand_txt);
        int iter = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers0[iter] = (scanner.nextInt());
                iter++;
            } else {
                scanner.next();
            }

        }

        switch (functionType) {
            case 0: //suma
                Thread t= new Thread(new Suma(numbers0));
                t.start();
                try {
                    t.join();
                }
                catch (InterruptedException e)
                {

                }
                break;
            case 1: //min
                Thread t2= new Thread(new Minimum(numbers0));
                t2.start();
                try {
                    t2.join();
                }
                catch (InterruptedException e)
                {

                }
                break;
            case 2: //max
                Thread t3= new Thread(new Maximum(numbers0));
                t3.start();
                try {
                    t3.join();
                }
                catch (InterruptedException e)
                {

                }
                break;
        }


    }
}
