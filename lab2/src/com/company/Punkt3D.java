package com.company;

/**
 * Created by student on 2018-10-09.
 */
public class Punkt3D extends Punkt2D {
    protected double z;

    public Punkt3D(double _x, double _y, double _z)
    {
        super(_x, _y);
        z=_z;
    }

    public double getZ()
    {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distance(Punkt3D a)
    {
        double dist=Math.sqrt(Math.pow(a.getX()-x, 2)+Math.pow(a.getY()-y,2)+Math.pow(a.getZ()-z, 2));
        return dist;
    }
}
