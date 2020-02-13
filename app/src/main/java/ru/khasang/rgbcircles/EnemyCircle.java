package ru.khasang.rgbcircles;

//вражеские круги

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimleCircle {

    public static final int MAIN_SPEED = 30;
    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int FOOD_COLOR = Color.rgb(0, 200, 0);
    public static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;

    //конструктор вражеских кругов
    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        //выделим память для random
        int x = random.nextInt(GameManager.getWidht());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + /*random.nextInt(RANDOM_SPEED) - */random.nextInt(RANDOM_SPEED);
        int dy = 1 + /*random.nextInt(RANDOM_SPEED) - */random.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius, dx, dy);
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

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)) {
            setColor(FOOD_COLOR);
        }
        else {
            setColor(ENEMY_COLOR);
        }
    }

    //метод сравнивает круги между собой
    public boolean isSmallerThan(SimleCircle circle) {
        if (radius < circle.radius) {
            return true;
        }
        return false;
    }

    //метод передвижения круга на один шаг
    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();
    }

    //проверка границ экрана для кругов
    private void checkBounds() {
        if (x > GameManager.getWidht() || x < 0) {
            dx = -dx;
        }
        if (y > GameManager.getHeight() || y < 0) {
            dy = -dy;
        }

    }
}
