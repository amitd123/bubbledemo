package com.example.cachybubbledemo;

import android.graphics.Rect;
import android.text.TextPaint;

public class Circles {
    int x;
    int y;
    int ra;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    boolean selected;

    public Rect getBounds() {
        return bounds;
    }

    public void setBounds(Rect bounds) {
        this.bounds = bounds;
    }

    Rect bounds;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String text;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public TextPaint getTp() {
        return tp;
    }

    public void setTp(TextPaint tp) {
        this.tp = tp;
    }

    TextPaint tp;

}
