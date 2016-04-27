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

    public HomeCanvas(Context context) {
        super(context);
        init();
    }

    public HomeCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.home));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        canvas.drawColor(Color.LTGRAY);
        canvas.drawBitmap(Images.resizeBitmap(bitmaps.get(1), canvas.getWidth(), canvas.getHeight()), 0, 0, null);
        canvas.drawBitmap(bitmaps.get(0), canvas.getWidth() / 4, canvas.getHeight() / 4, null);
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
