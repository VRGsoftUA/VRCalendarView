package com.vrgsoft.calendar;

import java.util.Date;

public class VrCalendarDay {

    private VRCalendarCustomViewCallback customViewCallback;
    private Date date;
    private VrCalendarDaySettings vrCalendarDaySettings;
    private boolean isChoosen;

    boolean isChoosen() {
        return isChoosen;
    }

    void setChoosen(boolean choosen) {
        isChoosen = choosen;
    }

    public VrCalendarDaySettings getVrCalendarDaySettings() {
        return vrCalendarDaySettings;
    }

    public void setVrCalendarDaySettings(VrCalendarDaySettings vrCalendarDaySettings) {
        this.vrCalendarDaySettings = vrCalendarDaySettings;
    }

    public VRCalendarCustomViewCallback getVRCalendarCustomViewCallback() {
        return customViewCallback;
    }

    public void setVRCalendarCustomViewCallback(VRCalendarCustomViewCallback callback) {
        this.customViewCallback = callback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
