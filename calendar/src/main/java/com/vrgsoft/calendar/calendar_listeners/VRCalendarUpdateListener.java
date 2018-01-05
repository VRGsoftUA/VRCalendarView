package com.vrgsoft.calendar.calendar_listeners;

import com.vrgsoft.calendar.VrCalendarDay;

public interface VRCalendarUpdateListener {

    void updateItem(VrCalendarDay day, boolean hasToSelect);
    void updateAll();

}
