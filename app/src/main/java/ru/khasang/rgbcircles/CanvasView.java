package ru.khasang.rgbcircles;
//класс, чтобы рисовать на экране

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.*;
import android.widget.Toast;
import androidx.annotation.Nullable;
import org.w3c.dom.Text;

public class CanvasView extends View implements iCanvasView {
    //ширина и высота экрана
    private static int width;
    private static int height;
    private GameManager gameManager;
    private Paint paint;
    private Canvas canvas;
    private Toast toast;


    //конструктор CanvasView
    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //определяем width, height через метод
        initWidthAndHeight(context);

        //выделяем память, проинициализировав
        //передаем ссылку на себя this (CanvasView)
        initPaint();
        gameManager = new GameManager(this, width, height);

    }

    //инициализирует кисточку для рисования
    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        //разглаживание
        paint.setStyle(Paint.Style.FILL);
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
        //чтобы нарисовать надо сохранить ссылку на canvas, пч он не доступен из drawCircle
        this.canvas = canvas;
        gameManager.onDraw(canvas);
    }

    //помощью circle будем рисовать основной круг, еду, врагов
    @Override
    public void drawCircle(SimleCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(),circle.getY(), circle.getRadius(), paint);
    }

    //перерисовка вьюшки
    @Override
    public void redraw() {

    }

    @Override
    public void showMessage(String text) {
        if (toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
        //centr
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    //метод, чтобы пальцем перемещать кружочек
    //переопределим метод onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //метод будет вызван когда прикасаемся пальцем к экрану
        //получаем координаты касания
       int x = (int) event.getX();
       int y = (int) event.getY();

       //если палец по экрану двигается, то вызовем метод onTouchEvent
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            gameManager.onTouchEvent(x, y);
        }
        //вызываем метод для перересовки
        invalidate();
        return true;
    }
}
