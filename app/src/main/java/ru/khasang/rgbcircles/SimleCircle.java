package ru.khasang.rgbcircles;

//предок всех кругов - примитивный круг (для главного/еды/врагов)
public class SimleCircle {
    protected int x;
    protected int y;
    protected int radius;
    //храним цвет круга
    private int color;

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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
