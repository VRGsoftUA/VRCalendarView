package com.vrgsoft.calendar;

import android.graphics.drawable.Drawable;
import android.view.View;

import java.util.Calendar;
import java.util.Date;

class VrCalendarUtils {

    private Calendar calendar = Calendar.getInstance();
    private Calendar calendarToday = Calendar.getInstance();

    VrCalendarDaySettings getDaySettings(Calendar calendarMonth, Date date, CalendarSettingWrapper mCalendarSettingWrapper, VrCalendarDaySettings customSettings) {
        VrCalendarDaySettings vrCalendarDaySettings = new VrCalendarDaySettings();
        Date today = new Date();

        calendar.setTimeInMillis(date.getTime());
        calendarToday.setTimeInMillis(today.getTime());

        if (customSettings == null) {
            customSettings = new VrCalendarDaySettings();
        }

        if (calendar.get(Calendar.MONTH) == calendarToday.get(Calendar.MONTH) &&
                calendar.get(Calendar.YEAR) == calendarToday.get(Calendar.YEAR) &&
                calendar.get(Calendar.DAY_OF_MONTH) != calendarToday.get(Calendar.DAY_OF_MONTH)) {
            setSettings(vrCalendarDaySettings, customSettings
                    , mCalendarSettingWrapper.getCurrentMonthTextStyle()
                    , mCalendarSettingWrapper.getCurrentMonthBackgroundColor()
                    , mCalendarSettingWrapper.getCurrentMonthTextColor()
                    , mCalendarSettingWrapper.getCurrentMonthBackgroundDrawable());
        } else if (calendar.get(Calendar.MONTH) == calendarToday.get(Calendar.MONTH) &&
                calendar.get(Calendar.YEAR) == calendarToday.get(Calendar.YEAR) &&
                calendar.get(Calendar.DAY_OF_MONTH) == calendarToday.get(Calendar.DAY_OF_MONTH)) {
            setSettings(vrCalendarDaySettings, customSettings
                    , mCalendarSettingWrapper.getCurrentDayTextStyle()
                    , mCalendarSettingWrapper.getCurrentDayBackgroundColor()
                    , mCalendarSettingWrapper.getCurrentDayTextColor()
                    , mCalendarSettingWrapper.getCurrentDayBackgroundDrawable());
        } else if (calendar.get(Calendar.MONTH) != calendarToday.get(Calendar.MONTH) ||
                calendar.get(Calendar.YEAR) != calendarToday.get(Calendar.YEAR)) {

            if (calendarMonth != null && calendarMonth.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
                setSettings(vrCalendarDaySettings, customSettings
                        , mCalendarSettingWrapper.getOtherMonthTextStyle()
                        , mCalendarSettingWrapper.getOtherMonthBackgroundColor()
                        , mCalendarSettingWrapper.getOtherMonthTextColor()
                        , mCalendarSettingWrapper.getOtherMonthBackgroundDrawable());
            } else {
                setSettings(vrCalendarDaySettings, customSettings
                        , mCalendarSettingWrapper.getCurrentMonthOtherDayTextStyle()
                        , mCalendarSettingWrapper.getCurrentMonthOtherDayBackgroundColor()
                        , mCalendarSettingWrapper.getCurrentMonthOtherDayTextColor()
                        , mCalendarSettingWrapper.getCurrentMonthOtherDayBackgroundDrawable());
            }
        }

        vrCalendarDaySettings.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        vrCalendarDaySettings.setDayTextSize(customSettings.getDayTextSize() == 0 ? mCalendarSettingWrapper.getDayTextSize() : customSettings.getDayTextSize());

        return vrCalendarDaySettings;
    }

    VrCalendarDay transfer(final VrCalendarDay day, CalendarSettingWrapper calendarSettingWrapper, int position) {
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.MONTH, position);
        VrCalendarDay vrCalendarDay = new VrCalendarDay();
        vrCalendarDay.setChoosen(day.isChoosen());
        vrCalendarDay.setDate(day.getDate());
        VRCalendarCustomViewCallback calendarCustomViewCallback = new VRCalendarCustomViewCallback() {
            @Override
            public View getNewCustomiseView() {
                return day.getVRCalendarCustomViewCallback().getNewCustomiseView();
            }
        };
        vrCalendarDay.setVRCalendarCustomViewCallback(calendarCustomViewCallback);
        vrCalendarDay.setVrCalendarDaySettings(getDaySettings(currentDate
                , vrCalendarDay.getDate(), calendarSettingWrapper, day.getVrCalendarDaySettings()));
        return vrCalendarDay;
    }

    private void setSettings(VrCalendarDaySettings settings, VrCalendarDaySettings customSettings, int style, int background, int text, Drawable backgroundDrawable) {
        settings.setDayBackgroundColor(customSettings.getDayBackgroundColor() == 0
                ? background : customSettings.getDayBackgroundColor());
        settings.setDayTextColor(customSettings.getDayTextColor() == 0
                ? text : customSettings.getDayTextColor());
        settings.setDayTextStyle(customSettings.getDayTextStyle() == 0
                ? style : customSettings.getDayTextStyle());
        settings.setDayBackgroundDrawable(customSettings.getDayBackgroundDrawable() == null
                ? backgroundDrawable : customSettings.getDayBackgroundDrawable());
    }

    static boolean isSameDay(Date myDate1, Date myDate2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(myDate1);
        calendar2.setTime(myDate2);

        return (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH) &&
                calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) &&
                calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH));
    }

}
