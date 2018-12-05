package zadanie5;

public abstract class Shape{
    public String name;

    public Shape(String _name)
    {
        this.name = _name;
    }
    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw();
}