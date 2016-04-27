package com.zhipengyang.bunnyc2.control;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class Images {
    public static Bitmap resizeBitmap(Bitmap bitmap, int width, int height) {
        if (bitmap == null)
            return null;
        int bitmapWidth = bitmap.getWidth(), bitmapHeight = bitmap.getHeight();
        float scaleWidth = ((float) width) / bitmapWidth, scaleHeight = ((float) height) / bitmapHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth, bitmapHeight, matrix, true);
    }
}
