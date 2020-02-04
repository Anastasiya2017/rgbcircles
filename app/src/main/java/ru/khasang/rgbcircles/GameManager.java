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
        //выделим память под коллекцию
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            //создаем временный круг
            EnemyCircle circle;
            //проинициализируем circle
            circle = EnemyCircle.getRandomCircle();
            //добавляем его в коллекцию
            circles.add(circle);
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
        canvasView.drawCircle(mainCircle);
        //то есть когда отображается гл.круг, то циклом выводим вражеские круги
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    //действие когда прикоснулись к экрану - передвинуть главный круг
    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
    }
}
