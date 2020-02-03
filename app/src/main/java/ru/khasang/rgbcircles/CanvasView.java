package ru.khasang.rgbcircles;
//класс, чтобы рисовать на экране

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;

public class CanvasView extends View {
    //ширина и высота экрана
    private static int width;
    private static int height;
    private GameManager gameManager;

    //конструктор CanvasView
    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //определяем width, height через метод
        initWidthAndHeight(context);

        //выделяем память, проинициализировав
        //передаем ссылку на себя this (CanvasView)
        gameManager = new GameManager(this, width, height);

    }

    private void initWidthAndHeight(Context context) {
        //узнаем ширину / высоту окна
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //получаем дисплей
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        //point правая нижняя точка экрана и из нее получаем x|y
        width = point.x;
        height = point.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gameManager.onDraw(canvas);
    }
}
