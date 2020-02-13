package ru.khasang.rgbcircles;

//главный круг, которым мы будем управлять во время игры

import android.graphics.Color;

public class MainCircle extends SimleCircle {

    public static final int INIT_RADIUS = 50;
    public static final int MAIN_SPEED = 30;
    public static final int OUR_COLOR = Color.BLUE;

    public MainCircle(int x, int y) {
        super(x, y, INIT_RADIUS);
        //добавили цвет кругу
        setColor(OUR_COLOR);
    }


    public void moveMainCircleWhenTouchAt(int x1, int y1) {
        //расчитаем скорость передвижения
        //чем ближе к кружку нажимаем тем V будет меньше
        int dx = (x - x1) * MAIN_SPEED / GameManager.getWidht();
        int dy = (y - y1) * MAIN_SPEED / GameManager.getHeight();
        x -= dx;
        y -= dy;
    }

    public void initRadius() {
        radius = INIT_RADIUS;
    }

    //увеличения круга на радиус круга, которого коснулись
    public void growRadius(EnemyCircle circle) {
        //pi * newr ^ 2 == pi * r ^ 2 + pi * reat ^ 2;
        //newr = sqrt(r ^ 2 + reat ^ 2);
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(circle.radius, 2));

    }
}
