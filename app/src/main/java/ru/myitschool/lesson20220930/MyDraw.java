package ru.myitschool.lesson20220930;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {
    Paint paint = new Paint();
    int N = 100;
    int[] MassPointX = new int[N];
    int[] MassPointY = new int[N];
    int[] rad = new int[N];
    int[] x = new int[N];
    int[] y = new int[N];
    int[] vx = new int[N];
    int[] vy = new int[N];
    int[] R = new int[N];
    int[] G = new int[N];
    int[] B = new int[N];

    float TouchX;
    float TouchY;

    public MyDraw(Context context) {
        super(context);

        paint.setColor(Color.BLACK);
        //paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        Canvas canvas = new Canvas();
        InitBalls(canvas);
    }

    public int MyRand(int a, int b) {
        return a + (int) (Math.random() * (b - a + 1));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    int i = 0;

    public void InitBalls(Canvas canvas) {
        for (int i = 0; i < N; i++) {
            x[i] = MyRand(0, 500);
            vx[i] = MyRand(-5, 10);
            y[i] = MyRand(0, 500);
            vy[i] = MyRand(-5, 10);
            R[i] = MyRand(0, 255);
            G[i] = MyRand(0, 255);
            B[i] = MyRand(0, 255);
            rad[i] = MyRand(20, 50);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            i++;
            MassPointX[i % N] = (int) event.getX();
            MassPointY[i % N] = (int) event.getY();
        }


        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        for (int i = 0; i < N; i++) {
            canvas.drawRect(MassPointX[i] - 50, MassPointY[i] - 50, MassPointX[i] + 50, MassPointY[i] + 50, paint);
        }


        for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(R[i], G[i], B[i]));
            canvas.drawCircle(x[i], y[i], rad[i], paint);
            x[i] += vx[i];
            y[i] += vy[i];

            if (x[i] > getWidth() - rad[i] || x[i] - rad[i] < 0)
                vx[i] *= -1;
            if (y[i] > getHeight() - rad[i] || y[i] - rad[i] < 0)
                vy[i] *= -1;
        }
        invalidate();

       /* int i = 0;
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
        canvas.drawText("Hello", 100, 100, paint);
        canvas.drawLine(canvas.getWidth() / 2, 0, canvas.getWidth() / 2,
                canvas.getHeight(), paint);
        canvas.drawLine(0, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight() / 2, paint);
*/
    }
}
