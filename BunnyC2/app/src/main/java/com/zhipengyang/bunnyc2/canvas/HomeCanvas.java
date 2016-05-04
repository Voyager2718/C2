package com.zhipengyang.bunnyc2.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.control.Images;

import java.util.ArrayList;
import java.util.List;

public class HomeCanvas extends View {
    private List<Bitmap> bitmaps = new ArrayList<>();
    private Canvas canvas;
    private Paint paintBrush;

    public HomeCanvas(Context context) {
        super(context);
        init();
    }

    public HomeCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private Bitmap home = BitmapFactory.decodeResource(getResources(), R.drawable.home);

    private void init() {
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2));
        /*
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2_hand1));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2_hand2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2_hand3));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2_hand4));
        */
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.home));
        paintBrush = new Paint();
    }

    protected void animateCharacter(final Canvas canvas) {
        //TODO
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        paintBrush.setColor(Color.parseColor("lightgray"));
        paintBrush.setStrokeWidth(10);

        canvas.drawColor(Color.LTGRAY);
        canvas.drawBitmap(Images.resizeBitmap(bitmaps.get(1), canvas.getWidth(), canvas.getHeight()), 0, 0, null);
        //canvas.drawBitmap(Images.resizeBitmap(home, canvas.getWidth(), canvas.getHeight()), 0, 0, null);

        canvas.drawBitmap(bitmaps.get(0), canvas.getWidth() / 4, canvas.getHeight() / 4, null);

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Bitmap bitmap : bitmaps) {
                    canvas.drawBitmap(bitmap, canvas.getWidth() / 4, canvas.getHeight() / 4, null);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                }
            }
        }).start();
        */

        //canvas.drawRect(100, 100, 800, 800, paintBrush);
    }

    public void drawWindow(int width, int height) {
        Rect rect = new Rect();
        Paint paint = new Paint();
        paint.setColor(Color.argb(200, 240, 240, 240));

        rect.left = canvas.getWidth() - width;
        rect.right = canvas.getWidth() - width;
        rect.top = canvas.getHeight() - height;
        rect.bottom = canvas.getHeight() - height;
        canvas.drawRect(rect, paint);
    }
}
