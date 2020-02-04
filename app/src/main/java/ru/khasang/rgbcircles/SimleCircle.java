package ru.khasang.rgbcircles;

//предок всех кругов - примитивный круг (для главного/еды/врагов)
public class SimleCircle {
    protected int x;
    protected int y;
    protected int radius;

    //конструктор
    public SimleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}
