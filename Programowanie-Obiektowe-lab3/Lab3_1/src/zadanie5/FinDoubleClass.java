
package zadanie5;

import java.util.*;

public class FinDoubleClass {
    void metoda1(final double var)
    {
        //var=12.99; <-- nie można tego zrobić
    }
    void metoda2(final LinkedList<Double> list)
    {
        list.add(12.99);
        list.remove(12.99);
        //Do listy ze słowem kluczowym final można dodawać i usuwać wartości. Nie można stworzyć dla tej listy nowe
        //(np. list = new LinkedList<double>(); lub nie można jej wyzerować (list = null)
    }
}
