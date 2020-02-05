package ru.khasang.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class GameManager {
    public static final int MAX_CIRCLES = 10;
    //приватные поля
    private MainCircle mainCircle; //главный круг
    //хранить в коллекции можно только будет circles
    private ArrayList<EnemyCircle> circles; //вражеские круги
    private CanvasView canvasView;
    private static int width;
    private static int height;

    //конструктор с полями
    public GameManager(CanvasView canvasView, int w, int h) {
        //присваиваем значения
        //this - так как одинаковые названия у переменных
        this.canvasView =canvasView;
        width = w;
        height = h;
        //инициализируем
        initMainCircle();
        initEnemyCircle();
    }

    //метод для создания кругов врагов
    private void initEnemyCircle() {
        //область вокруг нашего круга
        SimleCircle mainCircleArea = mainCircle.getCircleArea();
        //выделим память под коллекцию
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            //создаем временный круг
            EnemyCircle circle;

            //пока круги пересекаются создаем ещё круг
            do {
                //проинициализируем circle
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
            //добавляем его в коллекцию
            circles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
    }

    public static int getWidht() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2,height / 2);
    }

    //когда данному кл. потребуется нарисовать круг он обратиться через интерфейс передаст
    //круг и кто инт. реализ. его и нарисует
    public void onDraw(Canvas canvas) {
        //то есть когда отображается гл.круг, то циклом выводим вражеские круги
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    //действие когда прикоснулись к экрану - передвинуть главный круг
    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        checkCollision();
        moveCircles();
    }

    //метод проверки пересечения
    private void checkCollision() {
        for (EnemyCircle circle : circles) {
            if (mainCircle.isIntersect(circle)) {
                gameEnd();
            }
        }
    }

    private void gameEnd() {
        mainCircle.initRadius();//возварщаем радиус в исходное состояние
        initEnemyCircle(); //переинициализируем вражеские круги
        canvasView.redraw();//перерисовка canvasView

    }

    private void moveCircles() {
        for (EnemyCircle circle : circles) {
            circle.moveOneStep();
        }
    }
}
