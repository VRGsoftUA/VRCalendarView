package com.vrgsoft.calendar;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.vrgsoft.calendar.calendar_listeners.VRCalendarUpdateListener;

class CalendarPagerAdapter extends PagerAdapter {

    static int MONTH_QUANTITY = 2400;
    private Context context;
    private int pos = MONTH_QUANTITY / 2;
    private CalendarRecyclerView calendarRecyclerView;
    private CalendarSettingWrapper mCalendarSettingWrapper;

    CalendarPagerAdapter(Context context, CalendarSettingWrapper calendarSettingWrapper) {
        this.context = context;
        mCalendarSettingWrapper = calendarSettingWrapper;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        calendarRecyclerView = new CalendarRecyclerView(context, -(pos - position), mCalendarSettingWrapper);
        LinearLayout view = calendarRecyclerView;
        mCalendarSettingWrapper.addVrCalendarUpdateListener(calendarRecyclerView);
        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        mCalendarSettingWrapper.removeVrCalendarUpdateListener((VRCalendarUpdateListener) view);
        collection.removeView((LinearLayout) view);
    }

    @Override
    public int getCount() {
        return MONTH_QUANTITY;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
