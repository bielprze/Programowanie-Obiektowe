package zadanie5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Shape> lista_ksztaltow = new ArrayList();
        Scanner sc = new Scanner(System.in);

        int i=1;
        double a;
        double b;


        while(i!=5) {
            System.out.println("Co chcesz zrobić?\n 1. Dodaj nowy kwadrat\n 2. Dodaj nowy prostokąt\n 3. Dodaj nowy trójkąt\n 4. Wyświetl zapisane kształty\n 5. Zakończ");
            i = sc.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Podaj długość boku");
                    a=sc.nextDouble();
                    lista_ksztaltow.add(new kwadrat(a, "kwadrat"));
                    break;
                case 2:
                    System.out.println("Podaj długość boków");
                    a=sc.nextDouble();
                    b=sc.nextDouble();
                    lista_ksztaltow.add(new prostokat(a, b, "prostakat"));
                    break;
                case 3:
                    System.out.println("Podaj długość boku i wysokosc");
                    a=sc.nextDouble();
                    b=sc.nextDouble();
                    lista_ksztaltow.add(new trojkat(a, b, "trojkat"));
                    break;
                case 4:
                    for(int k=0; k<lista_ksztaltow.size(); ++k)
                    {
                        System.out.println("kształt: "+lista_ksztaltow.get(k).name);
                    }
                    break;
            }
        }
    }
}
