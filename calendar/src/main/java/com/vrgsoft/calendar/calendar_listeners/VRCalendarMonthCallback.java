package com.vrgsoft.calendar.calendar_listeners;

import com.vrgsoft.calendar.VrCalendarDay;

import java.util.Calendar;
import java.util.List;

public interface VRCalendarMonthCallback {

    List<VrCalendarDay> getCustomizeDayView(Calendar calendar);

}
