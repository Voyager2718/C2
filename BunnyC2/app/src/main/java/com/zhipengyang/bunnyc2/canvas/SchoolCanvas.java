package com.zhipengyang.bunnyc2.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.control.Images;

import java.util.ArrayList;
import java.util.List;

public class SchoolCanvas extends View {
    private List<Bitmap> bitmaps = new ArrayList<>();
    private Canvas canvas = null;

    public SchoolCanvas(Context context) {
        super(context);

        init();
    }

    public SchoolCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        init();
    }

    private void init() {
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.school));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        canvas.drawBitmap(Images.resizeBitmap(bitmaps.get(0), canvas.getWidth(), canvas.getHeight()), 0, 0, null);//Draw background
    }
}
