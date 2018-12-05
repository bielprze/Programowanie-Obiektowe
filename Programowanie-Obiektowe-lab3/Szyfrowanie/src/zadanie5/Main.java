package zadanie5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {   //argumenty od 0!!
        Scanner reader = new Scanner(System.in);
        System.out.println("Podaj ścieżkę do pliku");
        String name = reader.next();
        String path = name;
        path = path.replace("\\", "/");
// or
        path = path.replaceAll("\\\\", "/");

        System.out.println("Podaj ścieżkę do pliku wyjściowego");
        name = reader.next();
        String path2 = name;
        path2 = path2.replace("\\", "/");
// or
        path2 = path2.replaceAll("\\\\", "/");


        System.out.println("\nCo chcesz zrobić użytkowniku? Wybierz opcję:\n");
        System.out.println("1 - szyfrować algorytmem ROT11:\n");
        System.out.println("2 - szyfrować algorytmem Polibiusz:\n");
        System.out.println("3 - deszyfrować algorytmem ROT11:\n");
        System.out.println("4 - deszyfrować algorytmem Polibiusz:\n");
        int choice = reader.nextInt();
        switch(choice) {
            case 1 :
                ROT11 crtrot = new ROT11();
                Cryptographer.cryptfile(path, path2, crtrot);
                break;
            case 2 :
                Polibiusz crtpol = new Polibiusz();
                Cryptographer.cryptfile(path, path2, crtpol);
                break;
            case 3 :
                ROT11 dcrtrot = new ROT11();
                Cryptographer.decryptfile(path, path2, dcrtrot);
                break;
            case 4 :
                Polibiusz dcrtpol = new Polibiusz();
                Cryptographer.decryptfile(path, path2, dcrtpol);
                break;
            default:
                System.out.println("Nie ma takiej opcji.");
        }
    }
}
