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

    public SimleCircle getCircleArea() {
        return new SimleCircle(x, y, radius * 3);
    }

    //метод узнать пересекается ли круг с другим кругом
    public boolean isIntersect(SimleCircle circle) {
        return radius + circle.radius >= Math.sqrt(Math.pow(x - circle.x, 2) + Math.sqrt(Math.pow(y - circle.y, 2)));
    }
}
