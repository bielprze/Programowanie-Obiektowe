package zadanie5;

import java.util.Scanner;
/**
 * Klasa Main pozwalająca na przetestowanie klasy MicroDVD
 * @author Przemysław Bielecki
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       // Scanner object

        System.out.println("opóźnienie w ms");
        int _ms = sc.nextInt();
        System.out.println("Ścieżka do pliku");
        String name = sc.next();
        System.out.println("Framerate filmu");
        int fps_fr = sc.nextInt();
        System.out.println("gdzie zapisać?");
        String name2 = sc.next();
        sc.close();

        MicroDVD a = new MicroDVD(name, name2, _ms, fps_fr);
        a.delay();
    }
}
