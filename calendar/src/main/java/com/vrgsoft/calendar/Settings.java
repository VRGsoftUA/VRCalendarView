package com.vrgsoft.calendar;

import android.graphics.drawable.Drawable;

import com.vrgsoft.calendar.calendar_listeners.OnCalendarClickListener;
import com.vrgsoft.calendar.calendar_listeners.OnCalendarLongClickListener;
import com.vrgsoft.calendar.calendar_listeners.VRCalendarMonthCallback;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Settings {
    private OnCalendarClickListener mOnCalendarClickListener;
    private OnCalendarLongClickListener mOnCalendarLongClickListener;
    private VRCalendarMonthCallback mVRCalendarMonthCallback;
    private DateFormat mDateFormat = new SimpleDateFormat("yyyy-MMMM", Locale.getDefault());

    private int mCurrentDayTextColor;
    private int mCurrentMonthTextColor;
    private int mOtherMonthTextColor;
    private int mCurrentMonthOtherDayTextColor;
    private int mChosenTextColor;

    private int mCurrentDayBackgroundColor;
    private int mCurrentMonthBackgroundColor;
    private int mOtherMonthBackgroundColor;
    private int mCurrentMonthOtherDayBackgroundColor;
    private int mChosenBackgroundColor;

    private int mCurrentDayTextStyle;
    private int mCurrentMonthTextStyle;
    private int mOtherMonthTextStyle;
    private int mCurrentMonthOtherDayTextStyle;
    private int mChosenTextStyle;

    private Drawable mCurrentDayBackgroundDrawable;
    private Drawable mCurrentMonthBackgroundDrawable;
    private Drawable mOtherMonthBackgroundDrawable;
    private Drawable mCurrentMonthOtherDayBackgroundDrawable;
    private Drawable mChosenBackgroundDrawable;

    private int mNextMonthButton;
    private int mPreviousMonthButton;

    private int mDayTextSize;
    private int mTitleTextSize;

    private int mBackgroundColor;
    private int mTitleTextColor;

    private int mDayOfWeeksColor;

    public int getDayOfWeeksColor() {
        return mDayOfWeeksColor;
    }

    public void setDayOfWeeksColor(int dayOfWeeksColor) {
        this.mDayOfWeeksColor = dayOfWeeksColor;
    }

    public void setNextMonthButton(int nextMonthButton) {
        mNextMonthButton = nextMonthButton;
    }

    public void setPreviousMonthButton(int previousMonthButton) {
        mPreviousMonthButton = previousMonthButton;
    }

    public void setDayTextSize(int dayTextSize) {
        mDayTextSize = dayTextSize;
    }

    public void setTitleTextSize(int titleTextSize) {
        mTitleTextSize = titleTextSize;
    }

    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
    }

    public void setTitleTextColor(int titleTextColor) {
        mTitleTextColor = titleTextColor;
    }

    public void setCurrentDayBackgroundDrawable(Drawable currentDayBackgroundDrawable) {
        mCurrentDayBackgroundDrawable = currentDayBackgroundDrawable;
    }

    public void setCurrentMonthBackgroundDrawable(Drawable currentMonthBackgroundDrawable) {
        mCurrentMonthBackgroundDrawable = currentMonthBackgroundDrawable;
    }

    public void setOtherMonthBackgroundDrawable(Drawable otherMonthBackgroundDrawable) {
        mOtherMonthBackgroundDrawable = otherMonthBackgroundDrawable;
    }

    public void setCurrentMonthOtherDayBackgroundDrawable(Drawable currentMonthOtherDayBackgroundDrawable) {
        mCurrentMonthOtherDayBackgroundDrawable = currentMonthOtherDayBackgroundDrawable;
    }

    public void setChosenBackgroundDrawable(Drawable chosenBackgroundDrawable) {
        mChosenBackgroundDrawable = chosenBackgroundDrawable;
    }

    public void setChosenBackgroundColor(int chosenBackgroundColor) {
        mChosenBackgroundColor = chosenBackgroundColor;
    }

    public void setChosenTextStyle(int chosenTextStyle) {
        mChosenTextStyle = chosenTextStyle;
    }

    public void setChosenTextColor(int chosenTextColor) {
        mChosenTextColor = chosenTextColor;
    }

    public void setVRCalendarMonthCallback(VRCalendarMonthCallback vrCalendarMonthCallback) {
        mVRCalendarMonthCallback = vrCalendarMonthCallback;
    }

    public void setCurrentDayTextStyle(int currentDayTextStyle) {
        mCurrentDayTextStyle = currentDayTextStyle;
    }

    public void setCurrentMonthTextStyle(int currentMonthTextStyle) {
        mCurrentMonthTextStyle = currentMonthTextStyle;
    }

    public void setOtherMonthTextStyle(int otherMonthTextStyle) {
        mOtherMonthTextStyle = otherMonthTextStyle;
    }

    public void setCurrentMonthOtherDayTextStyle(int currentMonthOtherDayTextStyle) {
        mCurrentMonthOtherDayTextStyle = currentMonthOtherDayTextStyle;
    }

    public void setCurrentDayBackgroundColor(int currentDayBackgroundColor) {
        mCurrentDayBackgroundColor = currentDayBackgroundColor;
    }

    public void setCurrentMonthBackgroundColor(int currentMonthBackgroundColor) {
        mCurrentMonthBackgroundColor = currentMonthBackgroundColor;
    }

    public void setOtherMonthBackgroundColor(int otherMonthBackgroundColor) {
        mOtherMonthBackgroundColor = otherMonthBackgroundColor;
    }

    public void setCurrentMonthOtherDayBackgroundColor(int currentMonthOtherDayBackgroundColor) {
        mCurrentMonthOtherDayBackgroundColor = currentMonthOtherDayBackgroundColor;
    }

    public void setOnCalendarClickListener(OnCalendarClickListener onCalendarClickListener) {
        this.mOnCalendarClickListener = onCalendarClickListener;
    }

    public void setOnCalendarLongClickListener(OnCalendarLongClickListener onCalendarLongClickListener) {
        this.mOnCalendarLongClickListener = onCalendarLongClickListener;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.mDateFormat = dateFormat;
    }

    public void setCurrentDayTextColor(int currentDayTextColor) {
        mCurrentDayTextColor = currentDayTextColor;
    }

    public void setCurrentMonthTextColor(int currentMonthTextColor) {
        mCurrentMonthTextColor = currentMonthTextColor;
    }

    public void setOtherMonthTextColor(int otherMonthTextColor) {
        mOtherMonthTextColor = otherMonthTextColor;
    }

    public void setCurrentMonthOtherDayTextColor(int currentMonthOtherDayTextColor) {
        mCurrentMonthOtherDayTextColor = currentMonthOtherDayTextColor;
    }

    int getNextMonthButton() {
        return mNextMonthButton;
    }

    int getPreviousMonthButton() {
        return mPreviousMonthButton;
    }

    int getDayTextSize() {
        return mDayTextSize;
    }

    int getTitleTextSize() {
        return mTitleTextSize;
    }

    int getBackgroundColor() {
        return mBackgroundColor;
    }

    int getTitleTextColor() {
        return mTitleTextColor;
    }

    Drawable getCurrentDayBackgroundDrawable() {
        return mCurrentDayBackgroundDrawable;
    }

    Drawable getCurrentMonthBackgroundDrawable() {
        return mCurrentMonthBackgroundDrawable;
    }

    Drawable getOtherMonthBackgroundDrawable() {
        return mOtherMonthBackgroundDrawable;
    }

    Drawable getCurrentMonthOtherDayBackgroundDrawable() {
        return mCurrentMonthOtherDayBackgroundDrawable;
    }

    Drawable getChosenBackgroundDrawable() {
        return mChosenBackgroundDrawable;
    }

    int getChosenBackgroundColor() {
        return mChosenBackgroundColor;
    }

    int getChosenTextStyle() {
        return mChosenTextStyle;
    }

    int getChosenTextColor() {
        return mChosenTextColor;
    }

    VRCalendarMonthCallback getmVRCalendarMonthCallback() {
        return mVRCalendarMonthCallback;
    }

    int getmCurrentDayTextStyle() {
        return mCurrentDayTextStyle;
    }

    int getmCurrentMonthTextStyle() {
        return mCurrentMonthTextStyle;
    }

    int getmOtherMonthTextStyle() {
        return mOtherMonthTextStyle;
    }

    int getmCurrentMonthOtherDayTextStyle() {
        return mCurrentMonthOtherDayTextStyle;
    }

    int getCurrentDayBackgroundColor() {
        return mCurrentDayBackgroundColor;
    }

    int getCurrentMonthBackgroundColor() {
        return mCurrentMonthBackgroundColor;
    }

    int getOtherMonthBackgroundColor() {
        return mOtherMonthBackgroundColor;
    }

    int getCurrentMonthOtherDayBackgroundColor() {
        return mCurrentMonthOtherDayBackgroundColor;
    }

    OnCalendarClickListener getOnCalendarClickListener() {
        return mOnCalendarClickListener;
    }

    OnCalendarLongClickListener getOnCalendarLongClickListener() {
        return mOnCalendarLongClickListener;
    }

    DateFormat getDateFormat() {
        return mDateFormat;
    }

    int getCurrentDayTextColor() {
        return mCurrentDayTextColor;
    }

    int getCurrentMonthTextColor() {
        return mCurrentMonthTextColor;
    }

    int getOtherMonthTextColor() {
        return mOtherMonthTextColor;
    }

    int getCurrentMonthOtherDayTextColor() {
        return mCurrentMonthOtherDayTextColor;
    }
}
