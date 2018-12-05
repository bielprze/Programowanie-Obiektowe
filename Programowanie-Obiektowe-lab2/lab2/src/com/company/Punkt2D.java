package com.company;

/**
 * Created by student on 2018-10-09.
 */
public class Punkt2D {
    protected double x;
    protected double y;

    public Punkt2D(double _x, double _y)
    {
        x=_x;
        y=_y;
    }

    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Punkt2D a)
    {
        double dist=Math.sqrt(Math.pow(a.getX()-x, 2)+Math.pow(a.getY()-y, 2));
        return dist;
    }
}
