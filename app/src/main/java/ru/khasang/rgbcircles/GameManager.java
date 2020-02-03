package ru.khasang.rgbcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {
    private MainCircle mainCircle;
    private Paint paint;

    public GameManager( ) {
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
        mainCircle = new MainCircle(200,500);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(),mainCircle.getY(), mainCircle.getRadius(), paint);

    }
}
