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
import android.widget.ImageView;

import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.control.Images;

import java.util.ArrayList;
import java.util.List;

public class HomeCanvas extends View {
    private List<Bitmap> bitmaps = new ArrayList<>();

    private List<Bitmap> character = new ArrayList<>();
    private int characterFlame = 0;
    private int flameDirection = -1;
    private int flames = 0;
    private int characterFlamesPerSecond = 4;

    private ImageView characterAnimationImageView;

    private Canvas canvas;
    private Paint paintBrush;

    private Thread animationThread;

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
        paintBrush = new Paint();

        character.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2_hand1));
        character.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2_hand2));
        character.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2_hand3));
        character.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2_hand4));

        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.home));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.c2));

        animationThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        canvas.drawBitmap(Images.resizeBitmap(bitmaps.get(0), canvas.getWidth(), canvas.getHeight()), 0, 0, null);//Draw background
        //canvas.drawBitmap(bitmaps.get(1), canvas.getWidth() / 4, canvas.getHeight() / 4, null);//Draw C2

        /*
        //animate with invalidate();
        //flames = flames >= 1000 ? 0 : flames + 10;
        //if (flames % (1000 / 4) == 0) {
        if (characterFlame >= character.size() - 1 || characterFlame <= 0) {
            flameDirection *= -1;
            characterFlame = characterFlame + flameDirection;
        } else
            characterFlame += flameDirection;
        //The structure above can reverse the direction of animation.
        canvas.drawBitmap(character.get(characterFlame), canvas.getWidth() / 4, canvas.getHeight() / 4, null);
        //}

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }

        invalidate();
        */


        /*
        //Draw a lightgray rectangle
        paintBrush.setColor(Color.parseColor("lightgray"));
        paintBrush.setStrokeWidth(10);
        canvas.drawRect(100, 100, 800, 800, paintBrush);
        */

        if (characterFlame >= character.size() - 1 || characterFlame <= 0) {
            flameDirection *= -1;
            characterFlame = characterFlame + flameDirection;
        } else
            characterFlame += flameDirection;
        //The structure above can reverse the direction of animation.
        canvas.drawBitmap(character.get(characterFlame), canvas.getWidth() / 4, canvas.getHeight() / 4, null);
        postInvalidateDelayed(250);
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
