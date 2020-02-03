package ru.khasang.rgbcircles;
//класс, чтобы рисовать на экране

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class CanvasView extends View {
    private GameManager gameManager;

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //выделяем память, проинициализировав
        gameManager = new GameManager();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gameManager.onDraw(canvas);
    }
}
