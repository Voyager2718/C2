package com.zhipengyang.bunnyc2.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.control.Images;

import java.util.ArrayList;
import java.util.List;

public class HomeCanvas extends View {
    List<Bitmap> bitmaps = new ArrayList<Bitmap>();

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

        canvas.drawColor(Color.LTGRAY);
        //Log.d("Nothing", String.valueOf(bitmaps.get(1).getWidth()) + String.valueOf(bitmaps.get(1).getHeight()));
        //for (Bitmap bitmap : bitmaps)
        canvas.drawBitmap(Images.resizeBitmap(bitmaps.get(1), canvas.getWidth(), canvas.getHeight()), 0, 0, null);
        canvas.drawBitmap(bitmaps.get(0), canvas.getWidth() / 4, canvas.getHeight() / 4, null);
    }
}
