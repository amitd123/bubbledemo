package com.example.cachybubbledemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class CustomRelativelayout extends RelativeLayout {

    private Paint paintCircle;
    ArrayList<String> a;
    TextPaint mTextPaint;
    int mWidth = 0, mHeight = 0;

    public CustomRelativelayout(Context context, ArrayList<String> a) {
        super(context);
        int x = 200;

        for (int i = 0; i < a.size() ; i++){
          ////  CustomView cc = new CustomView(context,a.get(i));
            x =  x + 500;
            LayoutParams layoutParams=new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(x  , 200,0, 0);
          //  addView(cc);
        }

//        CustomView cc1 = new CustomView(context,a);
//        CustomView cc2 = new CustomView(context,a);
//        CustomView cc3 = new CustomView(context,a);



       // addView(cc);
//        LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.setMargins(Math.round(cc.getX())  + cc.getWidth(), cc.getHeight(),0, 0);
//        cc1.setLayoutParams(layoutParams);
//        addView(cc1);
//
//       // layoutParams.setMargins(Math.round(cc1.getX())  + cc1.getWidth(), cc1.getHeight(),0, 0);
//        addView(cc2);
//        addView(cc3);
    }

    private void createCircles(CustomView customView) {

    }


    public CustomRelativelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRelativelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomRelativelayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


}
