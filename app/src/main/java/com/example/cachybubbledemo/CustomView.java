package com.example.cachybubbledemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;

public class CustomView extends View {

    private Paint paintCircle;
    //ArrayList<String> a;
    public ArrayList<String> a;


    TextPaint mTextPaint;
    int mWidth = 0, mHeight = 0;

    public CustomView(Context context) {
        super(context);
        setBackgroundColor(Color.RED);
        a = new ArrayList<>();
        // create the Paint and set its color
        paintCircle = new Paint();
        paintCircle.setColor(Color.GRAY);
        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.WHITE);
        mWidth = this.getResources().getDisplayMetrics().widthPixels;
        mHeight = this.getResources().getDisplayMetrics().heightPixels;
        setLayoutParams(new ViewGroup.LayoutParams(mWidth, mHeight));
    }

    public CustomView(Context context, AttributeSet attrs ) {
        super(context,attrs);
        a = new ArrayList<>();
        setBackgroundColor(Color.RED);
        // create the Paint and set its color
        paintCircle = new Paint();
        paintCircle.setColor(Color.GRAY);
        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.WHITE);
        mWidth = this.getResources().getDisplayMetrics().widthPixels;
        mHeight = this.getResources().getDisplayMetrics().heightPixels;
        setLayoutParams(new ViewGroup.LayoutParams(mWidth, mHeight));
    }

    public void setA(ArrayList<String> cc) {
        a = cc;
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //  canvas.drawColor(Color.BLUE);
        drawCircle(canvas);
    }

    private void drawCircle(Canvas canvas) {
        int text_height = 0;
        int text_width = 0;
        for (int i = 0; i < a.size(); i++) {

            String text = a.get(i);
            Rect bounds = new Rect();
            mTextPaint.setTypeface(Typeface.DEFAULT);// your preference here
            mTextPaint.setTextSize(30);// have this the same as your text size
            mTextPaint.getTextBounds(text, 0, text.length(), bounds);
            text_height = bounds.height();
            text_width = bounds.width();


            int minRadius = 100;
            Random random = new Random();//define this outside you onDraw fucntion
            int w = getWidth();
            int h = getHeight();
            //            int randX = random.nextInt(w);
            //            int randY = random.nextInt(h);
            int randX = random.nextInt(mWidth - 5);
            int randY = random.nextInt(mHeight - 5);
            int randR = minRadius + random.nextInt(1000);


            //            Paint paint = new Paint();
            //
            //            paint.setColor(Color.WHITE);


            canvas.drawCircle(Math.round(randX), Math.round(randY), text_width / 2, paintCircle);
            // canvas.drawText(text, Math.round(randX) - Math.round(text_width/2) , Math.round
            // (text_width/2)  , mTextPaint);
        }


    }


    public static void getLocation(double x0, double y0, int radius) {
        Random random = new Random();

        // Convert radius from meters to degrees
        double radiusInDegrees = radius / 111000f;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(y0));

        double foundLongitude = new_x + x0;
        double foundLatitude = y + y0;
        System.out.println("Longitude: " + foundLongitude + "  Latitude: " + foundLatitude);
    }

}