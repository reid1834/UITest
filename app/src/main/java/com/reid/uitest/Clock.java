package com.reid.uitest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by reid on 2018/3/28.
 */

public class Clock extends View {
    private Paint mPaintCircle;
    private Paint mPaintDegree;
    private Paint mPaintHour;
    private Paint mPaintMin;
    private int mWidth;
    private int mHeight;

    public Clock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setStrokeWidth(5);

        mPaintDegree = new Paint();
        mPaintDegree.setAntiAlias(true);

        mPaintHour = new Paint();
        mPaintHour.setAntiAlias(true);
        mPaintHour.setStrokeWidth(20);

        mPaintMin = new Paint();
        mPaintMin.setAntiAlias(true);
        mPaintMin.setStrokeWidth(10);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        mWidth = getWidth();
        mHeight = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, mPaintCircle);

        for (int i = 0; i < 24; i++) {
            String num = String.valueOf(i);
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                mPaintDegree.setStrokeWidth(5);
                mPaintDegree.setTextSize(30);
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2,
                        mWidth / 2, mHeight / 2 - mWidth / 2 + 60, mPaintDegree);
                canvas.drawText(num, mWidth / 2 - mPaintDegree.measureText(num) / 2, mHeight / 2 - mWidth / 2 + 90, mPaintDegree);
            } else {
                mPaintDegree.setStrokeWidth(3);
                mPaintDegree.setTextSize(15);
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2,
                        mWidth / 2, mHeight / 2 - mWidth / 2 + 30, mPaintDegree);
                canvas.drawText(num, mWidth / 2- mPaintDegree.measureText(num) / 2, mHeight / 2 - mWidth / 2 + 60, mPaintDegree);
            }

            canvas.rotate(15, mWidth / 2, mHeight / 2);
        }

        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawLine(0, 0, 100, 100, mPaintHour);
        canvas.drawLine(0, 0, 100, 200, mPaintMin);
    }
}
