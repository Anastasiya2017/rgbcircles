package ru.khasang.rgbcircles;

//главный круг, которым мы будем управлять во время игры

public class MainCircle extends SimleCircle {

    public static final int INIT_RADIUS = 50;
    public static final int MAIN_SPEED = 35;

    public MainCircle(int x, int y) {
        super(x, y, INIT_RADIUS);
    }


    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        //расчитаем скорость передвижения
        //чем ближе к кружку нажимаем тем V будет меньше
        int dx = (x - x1) * MAIN_SPEED / GameManager.getWidht();
        int dy = (y - y1) * MAIN_SPEED / GameManager.getHeight();
        x -= dx;
        y -= dy;
    }
}
