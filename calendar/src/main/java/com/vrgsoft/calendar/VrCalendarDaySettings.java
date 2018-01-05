package com.vrgsoft.calendar;

import android.graphics.drawable.Drawable;

public class VrCalendarDaySettings {

    private int mDayTextColor;
    private int mDayBackgroundColor;
    private Drawable mDayBackgroundDrawable;
    private int mDayTextStyle;
    private int mDayTextSize;
    private int day;

    public VrCalendarDaySettings() {
    }

    public int getDayTextSize() {
        return mDayTextSize;
    }

    public void setDayTextSize(int mDayTextSize) {
        this.mDayTextSize = mDayTextSize;
    }

    public Drawable getDayBackgroundDrawable() {
        return mDayBackgroundDrawable;
    }

    public void setDayBackgroundDrawable(Drawable mDayBackgroundDrawable) {
        this.mDayBackgroundDrawable = mDayBackgroundDrawable;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDayTextColor() {
        return mDayTextColor;
    }

    public void setDayTextColor(int mDayTextColor) {
        this.mDayTextColor = mDayTextColor;
    }

    public int getDayBackgroundColor() {
        return mDayBackgroundColor;
    }

    public void setDayBackgroundColor(int mDayBackgroundColor) {
        this.mDayBackgroundColor = mDayBackgroundColor;
    }

    public int getDayTextStyle() {
        return mDayTextStyle;
    }

    public void setDayTextStyle(int mDayTextStyle) {
        this.mDayTextStyle = mDayTextStyle;
    }
}
