package ru.myitschool.lesson20220930;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {
    Paint paint = new Paint();

    public MyDraw(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        //paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int i = 0;
        int r = canvas.getWidth() / 2;
        while (r > 0) {
            i++;
            paint.setColor(i % 2 == 0 ? Color.WHITE : Color.BLACK);

            canvas.drawCircle(canvas.getWidth() / 2,
                    canvas.getHeight() / 2,
                    r,
                    paint);
            r = r - 100;
        }

        paint.setColor(Color.RED);
        paint.setTextSize(100f);
        canvas.drawText("Hello",100,100,paint);
        canvas.drawLine(canvas.getWidth() / 2, 0, canvas.getWidth() / 2,
                canvas.getHeight(), paint);
        canvas.drawLine(0, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight() / 2, paint);

    }
}
