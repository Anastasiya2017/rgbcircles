package ru.khasang.rgbcircles;

//вражеские круги

import java.util.Random;

public class EnemyCircle extends SimleCircle {

    public static final int MAIN_SPEED = 35;
    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        //выделим память для random
        int x = random.nextInt(GameManager.getWidht());
        int y = random.nextInt(GameManager.getHeight());
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle(x,y,radius);
        return enemyCircle;
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
