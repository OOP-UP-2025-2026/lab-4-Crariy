package ua.opnu;

import java.awt.*;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        super();
        z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(Math.pow((super.x - 0), 2) + Math.pow((super.y - 0), 2) + Math.pow((this.z - 0), 2));
    }

    public int getZ() {
        return z;
    }
}
