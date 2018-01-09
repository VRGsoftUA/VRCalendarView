package com.vrgsoft.calendarview;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.vrgsoft.calendar.VRCalendarCustomViewCallback;
import com.vrgsoft.calendar.VRCalendarView;
import com.vrgsoft.calendar.VrCalendarDay;
import com.vrgsoft.calendar.VrCalendarDaySettings;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomDayUtils {

    public List<VrCalendarDay> getCustomizeDayView(final Context context) {
        List<VrCalendarDay> vrCalendarDays = new ArrayList<>();

        vrCalendarDays.add(getToday(context));
        vrCalendarDays.add(getSomeDay(context));
        vrCalendarDays.add(getAnotherDay(context));
        vrCalendarDays.add(getOneMoreDay(context));
        vrCalendarDays.add(getDay0(context));
        vrCalendarDays.add(getDay1(context));
        vrCalendarDays.add(getDay2(context));
        vrCalendarDays.add(getDay3(context));

        return vrCalendarDays;
    }

    private VrCalendarDay getAnotherDay(final Context context) {
        VrCalendarDay tomorrow = new VrCalendarDay();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date d = cal.getTime();
        tomorrow.setDate(d);
        VrCalendarDaySettings vrtomorCalendarDaySettings = new VrCalendarDaySettings();
        vrtomorCalendarDaySettings.setDayTextStyle(VRCalendarView.BOLD);
        vrtomorCalendarDaySettings.setDayBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        vrtomorCalendarDaySettings.setDayTextColor(ContextCompat.getColor(context, R.color.colorYellow));
        tomorrow.setVrCalendarDaySettings(vrtomorCalendarDaySettings);

        return tomorrow;
    }

    private VrCalendarDay getOneMoreDay(final Context context) {
        VrCalendarDay tomorrow = new VrCalendarDay();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date d = cal.getTime();
        tomorrow.setDate(d);
        tomorrow.setVRCalendarCustomViewCallback(new VRCalendarCustomViewCallback() {
            @Override
            public View getNewCustomiseView() {
                CustomView customView = new CustomView(context);
                return customView;
            }
        });
        VrCalendarDaySettings vrtomorCalendarDaySettings = new VrCalendarDaySettings();
        vrtomorCalendarDaySettings.setDayTextStyle(VRCalendarView.BOLD);
        vrtomorCalendarDaySettings.setDayTextSize(21);
        vrtomorCalendarDaySettings.setDayTextColor(ContextCompat.getColor(context, R.color.colorDark));
        tomorrow.setVrCalendarDaySettings(vrtomorCalendarDaySettings);

        return tomorrow;
    }

    private VrCalendarDay getSomeDay(final Context context) {

        VrCalendarDay someDay = new VrCalendarDay();

        VrCalendarDaySettings someDaySettings = new VrCalendarDaySettings();
        someDaySettings.setDayTextColor(Color.CYAN);
        someDay.setVrCalendarDaySettings(someDaySettings);
        someDay.setVRCalendarCustomViewCallback(new VRCalendarCustomViewCallback() {
            @Override
            public View getNewCustomiseView() {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.simple_ex);
                return imageView;
            }
        });

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -2);
        someDay.setDate(cal.getTime());
        someDay.setVrCalendarDaySettings(someDaySettings);
        return someDay;
    }

    private VrCalendarDay getToday(final Context context) {
        VrCalendarDay today = new VrCalendarDay();
        today.setDate(new Date());

        VrCalendarDaySettings todaySettings = new VrCalendarDaySettings();
        todaySettings.setDayTextColor(Color.TRANSPARENT);
        today.setVrCalendarDaySettings(todaySettings);
        today.setVRCalendarCustomViewCallback(new VRCalendarCustomViewCallback() {
            @Override
            public View getNewCustomiseView() {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.ic_stat_name);
                return imageView;
            }
        });
        return today;
    }

    private VrCalendarDay getDay1(final Context context) {
        VrCalendarDay today = new VrCalendarDay();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 5);
        today.setDate(cal.getTime());
        VrCalendarDaySettings todaySettings = new VrCalendarDaySettings();
        todaySettings.setDayTextColor(Color.RED);
        today.setVrCalendarDaySettings(todaySettings);
        return today;
    }

    private VrCalendarDay getDay0(final Context context) {
        VrCalendarDay today = new VrCalendarDay();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 8);
        today.setDate(cal.getTime());
        VrCalendarDaySettings todaySettings = new VrCalendarDaySettings();
        todaySettings.setDayTextColor(Color.WHITE);
        todaySettings.setDayTextSize(10);
        today.setVrCalendarDaySettings(todaySettings);
        return today;
    }

    private VrCalendarDay getDay2(final Context context) {
        VrCalendarDay today = new VrCalendarDay();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 6);
        today.setDate(cal.getTime());
        VrCalendarDaySettings todaySettings = new VrCalendarDaySettings();
        todaySettings.setDayTextColor(Color.GREEN);
        todaySettings.setDayBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.background_sample));
        today.setVrCalendarDaySettings(todaySettings);
        return today;
    }

    private VrCalendarDay getDay3(final Context context) {
        VrCalendarDay today = new VrCalendarDay();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 4);
        today.setDate(cal.getTime());
        VrCalendarDaySettings todaySettings = new VrCalendarDaySettings();
        todaySettings.setDayTextColor(Color.BLUE);
        today.setVrCalendarDaySettings(todaySettings);
        return today;
    }


}
