//Zadanie 3
package com.company;
import java.io.*;

public class Reader{
    public static void main(String[] argv){
        InputStreamReader rd = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(rd);

        System.out.print("Wpisz jakis tekst: ");
        try {
            String text = bfr.readLine();
            System.out.println("Wpisales: " + text);
        }
        catch(IOException ex)
        {
            System.out.println (ex.toString());
        }
    }
}