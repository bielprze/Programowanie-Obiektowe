package com.company;

import java.util.LinkedList;
import java.util.Scanner;
/**
 * Created by student on 2018-10-09.
 */
public class Main {
    static LinkedList<Punkt3D> punkty;

    public static void main(String[] args) {
        int i;
        int j=1;
        int x, y, z;
        int a, b;

        punkty = new LinkedList<Punkt3D>();

        Punkt3D pkt=new Punkt3D(0, 0, 0);

        Scanner input = new Scanner(System.in);
        while(j!=4)
        {
            System.out.println("Wybierz działanie:\n1. Wczytaj punkt 3D\n2. Wyświetl wszystkie punkty\n3. Oblicz odległośc\n4. Zakończ");
            i=input.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Podaj x");
                    x=input.nextInt();
                    System.out.println("Podaj y");
                    y=input.nextInt();
                    System.out.println("Podaj z");
                    z=input.nextInt();

                    punkty.add(new Punkt3D(x, y, z));
                    break;
                case 2:
                    for(int k=0; k<punkty.size(); ++k)
                    {
                        System.out.println("Punkt nr "+(k+1)+": "+punkty.get(k).getX()+", "+punkty.get(k).getY()+", "+punkty.get(k).getZ());
                    }
                    break;
                case 3:
                    System.out.println("Między którymi punktami policzyć odległość?");
                    a=input.nextInt();
                    b=input.nextInt();
                    a-=1;
                    b-=1;
                    System.out.println("odległość to: "+punkty.get(a).distance(punkty.get(b)));
                    break;
                case 4:
                    j=4;
                    break;
                default:
                    System.out.println("zła komenda");
                    break;
            }
        }

    }
}
