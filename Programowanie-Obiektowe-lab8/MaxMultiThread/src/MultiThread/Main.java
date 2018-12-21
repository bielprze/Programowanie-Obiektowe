package MultiThread;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{

        Thread t = new Thread(new GenerateRandoms());
        t.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("[0] - suma \n[1] - minimum \n [2] - maksimum\n");
        int funkcja = scanner.nextInt();

        MaxMultiThread thread = new MaxMultiThread();
        switch (funkcja) {
            case 0:
                File suma_file = new File("suma.txt");
                Scanner scan = new Scanner(suma_file);
                System.out.println("Suma: "+scanner.nextInt());
                break;
            case 1:
                File min_file = new File("suma.txt");
                Scanner scan2 = new Scanner(min_file);
                System.out.println("Suma: "+scanner.nextInt());
                break;
            case 2:
                File max_file = new File("suma.txt");
                Scanner scan3 = new Scanner(max_file);
                System.out.println("Suma: "+scanner.nextInt());
                break;
        }
    }
}
