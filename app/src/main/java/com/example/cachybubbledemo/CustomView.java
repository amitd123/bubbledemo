package com.example.cachybubbledemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class CustomView extends View  {

    private Paint paintCircle;
    private Paint paintCircleL;
    //ArrayList<String> a;
    public Queue<String> stringList;
    public Queue<String> stringListCopy = new ArrayDeque<>();
    ArrayList<Circles> circles = new ArrayList<>();
    int lastWidth,lastHeight;
    TextPaint mTextPaint;
    int mWidth = 0, mHeight = 0;
    boolean afterSelection = false;

    public CustomView(Context context) {
        super(context);
        stringList = new ArrayDeque<>();
        paintCircle = new Paint();
        paintCircle.setColor(Color.GRAY);
        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.WHITE);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        setLayoutParams(new ViewGroup.LayoutParams(mWidth, mHeight));
        setWillNotDraw(false);
    }

    public CustomView(Context context, AttributeSet attrs ) {
        super(context,attrs);
        stringList = new ArrayDeque<>();
        setBackgroundColor(Color.RED);
        paintCircle = new Paint();
        paintCircle.setColor(Color.GRAY);
        paintCircleL = new Paint();
        paintCircleL.setColor(Color.WHITE);
        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.WHITE);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        setLayoutParams(new ViewGroup.LayoutParams(mWidth, mHeight));
        setWillNotDraw(false);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    Canvas canvasL;
    @Override
    protected void onDraw(Canvas canvas) {
        canvasL = canvas;
        if(mHeight==0 || mWidth==0)
            return;
        if(afterSelection){
            afterSelection = false;
            drawCircle(canvas);
        }else {
            afterSelection = false;
            int diffHeight = mHeight - lastHeight > 0 ? (mHeight - lastHeight) / 2 : 0;
            int diffWidth = mWidth - lastWidth > 0 ? (mWidth - lastWidth) / 2 : 0;
            for (int i = 0; i < circles.size(); i++) {
                circles.get(i).setX(circles.get(i).getX() + diffWidth);
                circles.get(i).setY(circles.get(i).getY() + diffHeight);
            }
            lastHeight = mHeight;
            lastWidth = mWidth;
            boolean unblock = true;
            while (stringList.size() > 0 && unblock) {
                int text_width = 0;
                String text = stringList.element();
                stringListCopy.add(text);
                Rect bounds = new Rect();
                mTextPaint.setTypeface(Typeface.DEFAULT);// your preference here
                mTextPaint.setTextSize(30);// have this the same as your text size
                mTextPaint.getTextBounds(text, 0, text.length(), bounds);
                text_width = bounds.width();

                boolean done = true;
                int execution = 0;
                while (done) {
                    Random random = new Random();
                    int radius = text_width / 2 + 50;
                    int max = mWidth - radius;
                    int maxH = mHeight - radius;
                    int min = radius;
                    int randX = random.nextInt(max + 1 - min) + min;
                    int randY = random.nextInt(maxH + 1 - min) + min;

                    boolean touching = false;
                    for (int i = 0; i < circles.size(); i++) {
                        int t = circle(circles.get(i).x, circles.get(i).y, randX, randY, circles.get(i).ra, radius);
                        if (t < 0) {
                        } else {
                            touching = true;
                        }

                    }
                    if (!touching) {
                        Log.d("HHHHHHHHHH", text);
                        Circles circle = new Circles();
                        circle.setRa(radius);
                        circle.setX(randX);
                        circle.setY(randY);
                        circle.setText(text);
                        circle.setTp(mTextPaint);
                        circle.setBounds(bounds);
                        circles.add(circle);
                        done = false;
                        stringList.poll();
                    }
                    execution++;
                    if (execution > 1000) {
                        done = false;
                        unblock = false;
                    }
                }
            }
            if (!unblock) {
                //circles = new ArrayList<>();
                increaseSize.increaseSize(mWidth, mHeight);
            }
            drawCircle(canvas);
//        AsyncTaskExample asyncTask=new AsyncTaskExample();
//        asyncTask.execute(canvas);
        }

    }


    private void drawCircle(Canvas canvas) {
        int text_height = circles.size();
        for(int i =0;i<text_height;i++){
            int x  = circles.get(i).x;
            int y = circles.get(i).y;
            int ra = circles.get(i).ra;
            if(circles.get(i).isSelected())
                canvasL.drawCircle(x,y , ra+15, paintCircle);
            else
                canvasL.drawCircle(x,y , ra, paintCircle);
            //if(!circles.get(i).isSelected()) {
                int yOffset = circles.get(i).getBounds().height() / 2;
                int xx = x - ra + 50;
//            if(circles.get(i).isSelected())
//                canvasL.drawText("selected", xx, y+yOffset, circles.get(i).tp);
//            else
                canvasL.drawText(circles.get(i).text, xx, y + yOffset, circles.get(i).tp);
            //}
        }
        //canvasL.drawCircle(200, 300, 80, paintCircle);
    }

    int circle(int x1, int y1, int x2, int y2, int r1, int r2)
    {
        int distSq = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
        int radSumSq = (r1 + r2) * (r1 + r2);
        if (distSq == radSumSq)
            return 1;
        else if (distSq - radSumSq > (130*130))
            return -1;
        else
            return 0;
    }

    boolean circle2(int x1, int y1, int x2,int y2, int r1, int r2)
    {
        int distSq = (int)Math.sqrt(((x1 - x2)
                * (x1 - x2))
                + ((y1 - y2)
                * (y1 - y2)));

        if (distSq + r2 == r1)
        {
            return false;
        }
        else if (distSq + r2 < r1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    IncreaseSize increaseSize;
    public void setListners( IncreaseSize increaseSize) {
        this.increaseSize = increaseSize;
    }

    public void clickedPosition(int toInt, int toInt1) {
        for (int i = 0; i < circles.size(); i++) {
            boolean t = circle2(circles.get(i).x, circles.get(i).y, toInt, toInt1, circles.get(i).ra, 1);
            if(t){
                circles.get(i).setSelected(!circles.get(i).isSelected());
//                Circles circle = new Circles();
//                circle.setRa(5);
//                circle.setX(toInt);
//                circle.setY(toInt1);
//                circle.setText("a");
//                circle.setSelected(true);
//                //circle.setTp(mTextPaint);
//                //circle.setBounds(bounds);
//                circles.add(circle);
                invalidate();
                break;
            }
        }
    }

//    private class AsyncTaskExample extends AsyncTask<Canvas, Canvas, Canvas> {
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//        @Override
//        protected Canvas doInBackground(Canvas... strings) {
//            //for (int i = 0; i < a.size(); i++) {
//            while (stringList.size()>0){
//
//                int text_width = 0;
//                String text = stringList.poll();
//
//                Rect bounds = new Rect();
//                mTextPaint.setTypeface(Typeface.DEFAULT);// your preference here
//                mTextPaint.setTextSize(30);// have this the same as your text size
//                mTextPaint.getTextBounds(text, 0, text.length(), bounds);
//                text_width = bounds.width();
//
//                boolean done = true;
//                int execution =0;
//                while (done) {
//                    Random random = new Random();//define this outside you onDraw fucntion
//                //                int w = getWidth();
//                //                int h = getHeight();
//                    int randX = random.nextInt(mWidth - 5);
//                    int randY = random.nextInt(mHeight - 5);
//                    int radius = text_width / 2 + 5;
//                    boolean touching = false;
//                    for (int i = 0; i < circles.size(); i++) {
//                        int t = circle(circles.get(i).x, circles.get(i).y, randX, randY, circles.get(i).ra, radius);
//                        if(t < 0){
//                            done = false;
////                            Circles circle = new Circles();
////                            circle.setRa(radius);
////                            circle.setX(randX);
////                            circle.setY(randY);
////                            circle.setTp(mTextPaint);
////                            circles.add(circle);
//                        }else{
//                            touching = true;
//                        }
//
//                    }
//                    if(!touching){
//                        Circles circle = new Circles();
//                        circle.setRa(radius);
//                        circle.setX(randX);
//                        circle.setY(randY);
//                        circle.setTp(mTextPaint);
//                        circles.add(circle);
//                    }
//                    execution++;
//                    if(execution>1000){
//                        done = false;
//                    }
//                }
//            }
//            return strings[0];
//        }
//        @Override
//        protected void onPostExecute(Canvas bitmap) {
//            super.onPostExecute(bitmap);
//            drawCircle(bitmap);
//        }
//
//        int circle(int x1, int y1, int x2,
//                          int y2, int r1, int r2)
//        {
//            int distSq = (x1 - x2) * (x1 - x2) +
//                    (y1 - y2) * (y1 - y2);
//            int radSumSq = (r1 + r2) * (r1 + r2);
//            if (distSq == radSumSq)
//                return 1;
//            else if (distSq > radSumSq)
//                return -1;
//            else
//                return 0;
//        }
//    }
//
//
//    public static void getLocation(double x0, double y0, int radius) {
//        Random random = new Random();
//
//        // Convert radius from meters to degrees
//        double radiusInDegrees = radius / 111000f;
//
//        double u = random.nextDouble();
//        double v = random.nextDouble();
//        double w = radiusInDegrees * Math.sqrt(u);
//        double t = 2 * Math.PI * v;
//        double x = w * Math.cos(t);
//        double y = w * Math.sin(t);
//
//        // Adjust the x-coordinate for the shrinking of the east-west distances
//        double new_x = x / Math.cos(Math.toRadians(y0));
//
//        double foundLongitude = new_x + x0;
//        double foundLatitude = y + y0;
//        System.out.println("Longitude: " + foundLongitude + "  Latitude: " + foundLatitude);
//    }

}