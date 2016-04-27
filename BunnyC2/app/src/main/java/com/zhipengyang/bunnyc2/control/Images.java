package com.zhipengyang.bunnyc2.control;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class Images {
    /**
     * @param bitmap: Bitmap to resize.
     * @param width:  Don't resize if width = 0
     * @param height: Don't resize if height = 0
     * @return: Bitmap resized
     */
    public static Bitmap resizeBitmap(Bitmap bitmap, int width, int height) {
        if (bitmap == null)
            return null;
        int bitmapWidth = bitmap.getWidth(), bitmapHeight = bitmap.getHeight();
        float scaleWidth = width != 0 ? ((float) width) / bitmapWidth : 1f, scaleHeight = height != 0 ? ((float) height) / bitmapHeight : 1f;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmapWidth, bitmapHeight, matrix, true);
    }
}
