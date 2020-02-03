package ru.khasang.rgbcircles;
//класс, чтобы рисовать на экране

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class CanvasView extends View {
    private MainCircle mainCircle;
    private Paint paint;
    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mainCircle.getX(),mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
