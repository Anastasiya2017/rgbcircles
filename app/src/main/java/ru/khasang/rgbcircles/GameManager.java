package ru.khasang.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {
    //приватные поля
    private MainCircle mainCircle;
    private CanvasView canvasView;
    private static int width;
    private static int height;
    private Paint paint;

    //конструктор с полями
    public GameManager(CanvasView canvasView, int w, int h) {
        //присваиваем значения
        //this - так как одинаковые названия у переменных
        this.canvasView =canvasView;
        width = w;
        height = h;

        initMainCircle();
        initPaint();

    }

    //инициализирует кисточку для рисования
    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        //разглаживание
        paint.setStyle(Paint.Style.FILL);
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(width / 2,height / 2);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(),mainCircle.getY(), mainCircle.getRadius(), paint);

    }
}
