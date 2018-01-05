package com.vrgsoft.calendar;

import android.graphics.drawable.Drawable;

import com.vrgsoft.calendar.calendar_listeners.OnCalendarClickListener;
import com.vrgsoft.calendar.calendar_listeners.OnCalendarLongClickListener;
import com.vrgsoft.calendar.calendar_listeners.VRCalendarCustomViewCallback;
import com.vrgsoft.calendar.calendar_listeners.VRCalendarMonthCallback;
import com.vrgsoft.calendar.calendar_listeners.VRCalendarUpdateListener;

import java.util.ArrayList;
import java.util.List;

public class CalendarSettingWrapper {

    private OnCalendarClickListener mOnCalendarClickListener;
    private OnCalendarLongClickListener mOnCalendarLongClickListener;
    private VRCalendarMonthCallback mVRCalendarMonthCallback;
    private VRCalendarCustomViewCallback mVRCalendarCustomViewCallback;
    private List<VRCalendarUpdateListener> mVrCalendarUpdateListeners;

    private int mCurrentDayTextColor;
    private int mCurrentMonthTextColor;
    private int mOtherMonthTextColor;
    private int mCurrentMonthOtherDayTextColor;
    private int mCurrentDayBackgroundColor;
    private int mCurrentMonthBackgroundColor;
    private int mOtherMonthBackgroundColor;
    private int mCurrentMonthOtherDayBackgroundColor;
    private int mCurrentDayTextStyle;
    private int mCurrentMonthTextStyle;
    private int mOtherMonthTextStyle;
    private int mCurrentMonthOtherDayTextStyle;
    private int mChosenTextStyle;
    private int mChosenBackgroundColor;
    private int mChosenTextColor;
    private int mDayTextSize;

    private Drawable mCurrentDayBackgroundDrawable;
    private Drawable mCurrentMonthBackgroundDrawable;
    private Drawable mOtherMonthBackgroundDrawable;
    private Drawable mCurrentMonthOtherDayBackgroundDrawable;
    private Drawable mChosenBackgroundDrawable;

    CalendarSettingWrapper(Settings builder) {
        mOnCalendarClickListener = builder.getOnCalendarClickListener();
        mOnCalendarLongClickListener = builder.getOnCalendarLongClickListener();
        mCurrentDayTextColor = builder.getCurrentDayTextColor();
        mCurrentMonthTextColor = builder.getCurrentMonthTextColor();
        mOtherMonthTextColor = builder.getOtherMonthTextColor();
        mCurrentMonthOtherDayTextColor = builder.getCurrentMonthOtherDayTextColor();
        mCurrentDayBackgroundColor = builder.getCurrentDayBackgroundColor();
        mCurrentMonthBackgroundColor = builder.getCurrentMonthBackgroundColor();
        mOtherMonthBackgroundColor = builder.getOtherMonthBackgroundColor();
        mCurrentMonthOtherDayBackgroundColor = builder.getCurrentMonthOtherDayBackgroundColor();
        mCurrentDayTextStyle = builder.getmCurrentDayTextStyle();
        mCurrentMonthTextStyle = builder.getmCurrentMonthTextStyle();
        mOtherMonthTextStyle = builder.getmOtherMonthTextStyle();
        mCurrentMonthOtherDayTextStyle = builder.getmCurrentMonthOtherDayTextStyle();
        mVRCalendarMonthCallback = builder.getmVRCalendarMonthCallback();
        mChosenBackgroundColor = builder.getChosenBackgroundColor();
        mChosenTextStyle = builder.getChosenTextStyle();
        mChosenTextColor = builder.getChosenTextColor();
        mCurrentDayBackgroundDrawable = builder.getCurrentDayBackgroundDrawable();
        mCurrentMonthBackgroundDrawable = builder.getCurrentMonthBackgroundDrawable();
        mOtherMonthBackgroundDrawable = builder.getOtherMonthBackgroundDrawable();
        mCurrentMonthOtherDayBackgroundDrawable = builder.getCurrentMonthOtherDayBackgroundDrawable();
        mChosenBackgroundDrawable = builder.getChosenBackgroundDrawable();
        mDayTextSize = builder.getDayTextSize();
    }

    public CalendarSettingWrapper setDayTextSize(int dayTextSize) {
        this.mDayTextSize = dayTextSize;
        return this;
    }

    public VRCalendarCustomViewCallback getVRCalendarCustomViewCallback() {
        return mVRCalendarCustomViewCallback;
    }

    public CalendarSettingWrapper setVRCalendarCustomViewCallback(VRCalendarCustomViewCallback vrCalendarCustomViewCallback) {
        this.mVRCalendarCustomViewCallback = vrCalendarCustomViewCallback;
        return this;
    }

    public CalendarSettingWrapper setOnCalendarClickListener(OnCalendarClickListener mOnCalendarClickListener) {
        this.mOnCalendarClickListener = mOnCalendarClickListener;
        return this;
    }

    public CalendarSettingWrapper setOnCalendarLongClickListener(OnCalendarLongClickListener mOnCalendarLongClickListener) {
        this.mOnCalendarLongClickListener = mOnCalendarLongClickListener;
        return this;
    }

    void setVrCalendarUpdateListeners(List<VRCalendarUpdateListener> mVrCalendarUpdateListeners) {
        this.mVrCalendarUpdateListeners = mVrCalendarUpdateListeners;
    }

    public CalendarSettingWrapper setCurrentDayTextColor(int mCurrentDayTextColor) {
        this.mCurrentDayTextColor = mCurrentDayTextColor;
        return this;
    }

    public CalendarSettingWrapper setCurrentMonthTextColor(int mCurrentMonthTextColor) {
        this.mCurrentMonthTextColor = mCurrentMonthTextColor;
        return this;
    }

    public CalendarSettingWrapper setOtherMonthTextColor(int mOtherMonthTextColor) {
        this.mOtherMonthTextColor = mOtherMonthTextColor;
        return this;
    }

    public CalendarSettingWrapper setCurrentMonthOtherDayTextColor(int mCurrentMonthOtherDayTextColor) {
        this.mCurrentMonthOtherDayTextColor = mCurrentMonthOtherDayTextColor;
        return this;
    }

    public CalendarSettingWrapper setCurrentDayBackgroundColor(int mCurrentDayBackgroundColor) {
        this.mCurrentDayBackgroundColor = mCurrentDayBackgroundColor;
        return this;
    }

    public CalendarSettingWrapper setCurrentMonthBackgroundColor(int mCurrentMonthBackgroundColor) {
        this.mCurrentMonthBackgroundColor = mCurrentMonthBackgroundColor;
        return this;
    }

    public CalendarSettingWrapper setOtherMonthBackgroundColor(int mOtherMonthBackgroundColor) {
        this.mOtherMonthBackgroundColor = mOtherMonthBackgroundColor;
        return this;
    }

    public CalendarSettingWrapper setCurrentMonthOtherDayBackgroundColor(int mCurrentMonthOtherDayBackgroundColor) {
        this.mCurrentMonthOtherDayBackgroundColor = mCurrentMonthOtherDayBackgroundColor;
        return this;
    }

    public CalendarSettingWrapper setCurrentDayTextStyle(int mCurrentDayTextStyle) {

        if (mCurrentDayTextStyle > 2 || mCurrentDayTextStyle < 0)
            throw new IllegalArgumentException("CurrentDayTextStyle can be >= 0 or <=2");

        this.mCurrentDayTextStyle = mCurrentDayTextStyle;
        return this;
    }

    public CalendarSettingWrapper setCurrentMonthTextStyle(int mCurrentMonthTextStyle) {

        if (mCurrentMonthTextStyle > 2 || mCurrentMonthTextStyle < 0)
            throw new IllegalArgumentException("CurrentMonthTextStyle can be >= 0 or <=2");

        this.mCurrentMonthTextStyle = mCurrentMonthTextStyle;
        return this;
    }

    public CalendarSettingWrapper setOtherMonthTextStyle(int mOtherMonthTextStyle) {

        if (mOtherMonthTextStyle > 2 || mOtherMonthTextStyle < 0)
            throw new IllegalArgumentException("OtherMonthTextStyle can be >= 0 or <=2");

        this.mOtherMonthTextStyle = mOtherMonthTextStyle;
        return this;
    }

    public CalendarSettingWrapper setCurrentMonthOtherDayTextStyle(int mCurrentMonthOtherDayTextStyle) {

        if (mCurrentMonthOtherDayTextStyle > 2 || mCurrentMonthOtherDayTextStyle < 0)
            throw new IllegalArgumentException("CurrentMonthOtherDayTextStyle can be >= 0 or <=2");

        this.mCurrentMonthOtherDayTextStyle = mCurrentMonthOtherDayTextStyle;
        return this;
    }

    public CalendarSettingWrapper setChosenBackgroundColor(int mChosenBackgroundColor) {

        this.mChosenBackgroundColor = mChosenBackgroundColor;
        return this;
    }

    public CalendarSettingWrapper setChosenTextStyle(int mChosenTextStyle) {

        if (mChosenTextStyle > 2 || mChosenTextStyle < 0)
            throw new IllegalArgumentException("ChosenTextStyle can be >= 0 or <=2");

        this.mChosenTextStyle = mChosenTextStyle;
        return this;
    }

    public CalendarSettingWrapper setChosenTextColor(int mChosenTextColor) {
        this.mChosenTextColor = mChosenTextColor;
        return this;
    }

    public CalendarSettingWrapper setCurrentDayBackgroundDrawable(Drawable mCurrentDayBackgroundDrawable) {
        this.mCurrentDayBackgroundDrawable = mCurrentDayBackgroundDrawable;
        return this;
    }

    public CalendarSettingWrapper setCurrentMonthBackgroundDrawable(Drawable mCurrentMonthBackgroundDrawable) {
        this.mCurrentMonthBackgroundDrawable = mCurrentMonthBackgroundDrawable;
        return this;
    }

    public CalendarSettingWrapper setOtherMonthBackgroundDrawable(Drawable mOtherMonthBackgroundDrawable) {
        this.mOtherMonthBackgroundDrawable = mOtherMonthBackgroundDrawable;
        return this;
    }

    public CalendarSettingWrapper setCurrentMonthOtherDayBackgroundDrawable(Drawable mCurrentMonthOtherDayBackgroundDrawable) {
        this.mCurrentMonthOtherDayBackgroundDrawable = mCurrentMonthOtherDayBackgroundDrawable;
        return this;
    }

    public CalendarSettingWrapper setChosenBackgroundDrawable(Drawable mChosenBackgroundDrawable) {
        this.mChosenBackgroundDrawable = mChosenBackgroundDrawable;
        return this;
    }
    public int getDayTextSize() {
        return mDayTextSize;
    }
    public Drawable getCurrentDayBackgroundDrawable() {
        return mCurrentDayBackgroundDrawable;
    }

    public Drawable getCurrentMonthBackgroundDrawable() {
        return mCurrentMonthBackgroundDrawable;
    }

    public Drawable getOtherMonthBackgroundDrawable() {
        return mOtherMonthBackgroundDrawable;
    }

    public Drawable getCurrentMonthOtherDayBackgroundDrawable() {
        return mCurrentMonthOtherDayBackgroundDrawable;
    }

    public Drawable getChosenBackgroundDrawable() {
        return mChosenBackgroundDrawable;
    }

    public int getChosenBackgroundColor() {
        return mChosenBackgroundColor;
    }

    public int getChosenTextStyle() {
        return mChosenTextStyle;
    }

    public int getChosenTextColor() {
        return mChosenTextColor;
    }

    List<VRCalendarUpdateListener> getVrCalendarUpdateListener() {
        return mVrCalendarUpdateListeners;
    }

    void addVrCalendarUpdateListener(VRCalendarUpdateListener mVrCalendarUpdateListener) {
        if (mVrCalendarUpdateListeners == null) {
            mVrCalendarUpdateListeners = new ArrayList<>();
        }
        mVrCalendarUpdateListeners.add(mVrCalendarUpdateListener);
    }

    void removeVrCalendarUpdateListener(VRCalendarUpdateListener mVrCalendarUpdateListener) {
        if (mVrCalendarUpdateListeners != null) {
            mVrCalendarUpdateListeners.remove(mVrCalendarUpdateListener);
        }
    }

    public VRCalendarMonthCallback getVRCalendarMonthCallback() {
        return mVRCalendarMonthCallback;
    }

    public CalendarSettingWrapper setVRCalendarMonthCallback(VRCalendarMonthCallback callback) {
        this.mVRCalendarMonthCallback = callback;
        return this;
    }

    public void updateCalendarDay(VrCalendarDay day, boolean hasToSelect) {
        List<VRCalendarUpdateListener> listeners = getVrCalendarUpdateListener();
        if (listeners != null) {
            for (VRCalendarUpdateListener listener : listeners) {
                listener.updateItem(day, hasToSelect);
            }
        }
    }

    public void updateCalendar() {
        List<VRCalendarUpdateListener> listeners = getVrCalendarUpdateListener();
        if (listeners != null) {
            for (VRCalendarUpdateListener listener : listeners) {
                listener.updateAll();
            }
        }
    }


    public int getCurrentDayTextStyle() {
        return mCurrentDayTextStyle;
    }


    public int getCurrentMonthTextStyle() {
        return mCurrentMonthTextStyle;
    }


    public int getOtherMonthTextStyle() {
        return mOtherMonthTextStyle;
    }


    public int getCurrentMonthOtherDayTextStyle() {
        return mCurrentMonthOtherDayTextStyle;
    }


    public int getCurrentDayBackgroundColor() {
        return mCurrentDayBackgroundColor;
    }


    public int getCurrentMonthBackgroundColor() {
        return mCurrentMonthBackgroundColor;
    }


    public int getOtherMonthBackgroundColor() {
        return mOtherMonthBackgroundColor;
    }


    public int getCurrentMonthOtherDayBackgroundColor() {
        return mCurrentMonthOtherDayBackgroundColor;
    }


    public OnCalendarClickListener getOnCalendarClickListener() {
        return mOnCalendarClickListener;
    }


    public OnCalendarLongClickListener getOnCalendarLongClickListener() {
        return mOnCalendarLongClickListener;
    }


    public int getCurrentDayTextColor() {
        return mCurrentDayTextColor;
    }


    public int getCurrentMonthTextColor() {
        return mCurrentMonthTextColor;
    }


    public int getOtherMonthTextColor() {
        return mOtherMonthTextColor;
    }


    public int getCurrentMonthOtherDayTextColor() {
        return mCurrentMonthOtherDayTextColor;
    }


}
