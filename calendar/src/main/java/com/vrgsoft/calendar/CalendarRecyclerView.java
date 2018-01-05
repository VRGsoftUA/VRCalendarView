package com.vrgsoft.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.vrgsoft.calendar.calendar_listeners.VRCalendarUpdateListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SuppressLint("ViewConstructor")
public class CalendarRecyclerView extends LinearLayout implements VRCalendarUpdateListener {

    private static final int DAYS_COUNT = 42;
    private CalendarSettingWrapper mCalendarSettingWrapper;
    private CalendarAdapter mAdapter;
    private VrCalendarUtils vrCalendarUtils;
    private int mPosition;

    public CalendarRecyclerView(Context context, int position, CalendarSettingWrapper calendarSettingWrapper) {
        super(context);
        mCalendarSettingWrapper = calendarSettingWrapper;
        setupViews(position);
    }

    private void setupViews(int position) {
        vrCalendarUtils = new VrCalendarUtils();
        mPosition = position;

        View view = LayoutInflater.from(getContext()).inflate(R.layout.recycler_calendar, this);
        RecyclerView calendarRv = view.findViewById(R.id.calendar_recycler);

        mAdapter = new CalendarAdapter(getDays(), mCalendarSettingWrapper);

        calendarRv.setLayoutManager(new GridLayoutManager(getContext(), 7));
        calendarRv.setItemAnimator(null);
        calendarRv.setAdapter(mAdapter);

    }

    @Override
    public void updateItem(VrCalendarDay day, boolean hasToSelect) {
        if (mAdapter != null) {
            mAdapter.updateDay(vrCalendarUtils.transfer(day, mCalendarSettingWrapper, mPosition), hasToSelect);
        }
    }

    @Override
    public void updateAll() {
        if (mAdapter != null) {
            mAdapter.updateAll(getDays());
        }
    }

    private List<VrCalendarDay> getDays() {
        List<VrCalendarDay> cells = new ArrayList<>();
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.MONTH, mPosition);
        Calendar calendar = (Calendar) currentDate.clone();

        List<VrCalendarDay> customDays = null;
        if (mCalendarSettingWrapper.getVRCalendarMonthCallback() != null) {
            customDays = mCalendarSettingWrapper.getVRCalendarMonthCallback().getCustomizeDayView(calendar);
        }

        // determine the cell for current month's beginning
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int monthBeginningCell = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        if (monthBeginningCell < 0) {
            monthBeginningCell = 6;
        }
        // move calendar backwards to the beginning of the week
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        // fill cells
        while (cells.size() < DAYS_COUNT) {
            VrCalendarDay vrCalendarDay = new VrCalendarDay();
            vrCalendarDay.setDate(calendar.getTime());
            if (customDays != null) {
                for (int i = 0; i < customDays.size(); i++) {
                    if (VrCalendarUtils.isSameDay(customDays.get(i).getDate(), vrCalendarDay.getDate())) {
                        vrCalendarDay.setVRCalendarCustomViewCallback(customDays.get(i).getVRCalendarCustomViewCallback());
                        vrCalendarDay.setVrCalendarDaySettings(vrCalendarUtils.getDaySettings(currentDate
                                , vrCalendarDay.getDate(), mCalendarSettingWrapper, customDays.get(i).getVrCalendarDaySettings()));
                        break;
                    }
                }
            }
            if (vrCalendarDay.getVrCalendarDaySettings() == null) {
                vrCalendarDay.setVrCalendarDaySettings(vrCalendarUtils.getDaySettings(currentDate
                        , vrCalendarDay.getDate(), mCalendarSettingWrapper, null));
            }

            cells.add(vrCalendarDay);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return cells;
    }
}
