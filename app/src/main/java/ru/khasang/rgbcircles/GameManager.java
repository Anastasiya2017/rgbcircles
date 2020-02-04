package ru.khasang.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {
    //приватные поля
    private MainCircle mainCircle;
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

        initMainCircle();

    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2,height / 2);
    }

    //когда данному кл. потребуется нарисовать круг он обратиться через интерфейс передаст
    //круг и кто инт. реализ. его и нарисует
    public void onDraw(Canvas canvas) {
        canvasView.drawCircle(mainCircle);
    }
}
