package com.vrgsoft.calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class VRCalendarView extends LinearLayout {

    public static final int NORMAL = 0;
    public static final int BOLD = 1;
    public static final int ITALIC = 2;

    private CalendarPagerAdapter mCalendarPagerAdapter;
    private ViewPager viewPager;
    private DateFormat df = new SimpleDateFormat("yyyy-MMMM", Locale.getDefault());
    private TextView tvCalendarDate;
    private Context mContext;
    private ImageButton mPrevious;
    private ImageButton mNext;
    private CalendarSettingWrapper mCalendarSettingWrapper;
    private TextView[] mTvWeekDays;

    public VRCalendarView(Context context) {
        super(context);
        mContext = context;
    }

    public VRCalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttributes(attrs);
    }

    public VRCalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initAttributes(attrs);
    }

    private void initAttributes(AttributeSet attributeSet) {
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(attributeSet
                , R.styleable.VRCalendarView, 0, 0);
        Settings settings;
        try {
            int color = ContextCompat.getColor(mContext, R.color.colorText);
            settings = new com.vrgsoft.calendar.Settings();
            settings.setCurrentDayTextColor(typedArray.getColor(R.styleable.VRCalendarView_vr_current_day_text_color, color));
            settings.setCurrentMonthOtherDayTextColor(typedArray.getColor(R.styleable.VRCalendarView_vr_current_month_other_days_text_color, color));
            settings.setCurrentMonthTextColor(typedArray.getColor(R.styleable.VRCalendarView_vr_current_month_text_color, color));
            settings.setOtherMonthTextColor(typedArray.getColor(R.styleable.VRCalendarView_vr_other_month_text_color, color));
            settings.setChosenTextColor(typedArray.getColor(R.styleable.VRCalendarView_vr_chosen_day_text_color, Color.WHITE));

            color = ContextCompat.getColor(mContext, R.color.colorBackGround);
            settings.setCurrentDayBackgroundColor(typedArray.getColor(R.styleable.VRCalendarView_vr_current_day_background_color, color));
            settings.setCurrentMonthOtherDayBackgroundColor(typedArray.getColor(R.styleable.VRCalendarView_vr_current_month_other_days_background_color, color));
            settings.setCurrentMonthBackgroundColor(typedArray.getColor(R.styleable.VRCalendarView_vr_current_month_background_color, color));
            settings.setOtherMonthBackgroundColor(typedArray.getColor(R.styleable.VRCalendarView_vr_other_month_background_color, color));
            settings.setChosenBackgroundColor(typedArray.getColor(R.styleable.VRCalendarView_vr_chosen_day_background_color, ContextCompat.getColor(mContext, R.color.colorText)));

            settings.setCurrentDayTextStyle(typedArray.getInt(R.styleable.VRCalendarView_vr_current_day_text_style, BOLD));
            settings.setCurrentMonthOtherDayTextStyle(typedArray.getInt(R.styleable.VRCalendarView_vr_current_month_other_days_text_style, NORMAL));
            settings.setCurrentMonthTextStyle(typedArray.getInt(R.styleable.VRCalendarView_vr_current_month_text_style, NORMAL));
            settings.setOtherMonthTextStyle(typedArray.getInt(R.styleable.VRCalendarView_vr_other_month_text_style, NORMAL));
            settings.setChosenTextStyle(typedArray.getInt(R.styleable.VRCalendarView_vr_chosen_day_text_style, NORMAL));

            int currentDayBackgroundDrawable = typedArray.getResourceId(R.styleable.VRCalendarView_vr_current_day_background_drawable, -1);
            if (currentDayBackgroundDrawable > 0) {
                settings.setCurrentDayBackgroundDrawable(ContextCompat.getDrawable(getContext(), currentDayBackgroundDrawable));
            }
            int currentMonthBackgroundDrawable = typedArray.getResourceId(R.styleable.VRCalendarView_vr_current_month_background_drawable, -1);
            if (currentMonthBackgroundDrawable > 0) {
                settings.setCurrentMonthBackgroundDrawable(ContextCompat.getDrawable(getContext(), currentMonthBackgroundDrawable));
            }
            int otherMonthBackgroundDrawable = typedArray.getResourceId(R.styleable.VRCalendarView_vr_other_month_background_drawable, -1);
            if (otherMonthBackgroundDrawable > 0) {
                settings.setOtherMonthBackgroundDrawable(ContextCompat.getDrawable(getContext(), otherMonthBackgroundDrawable));
            }
            int currentMonthOtherDayBackgroundDrawable = typedArray.getResourceId(R.styleable.VRCalendarView_vr_current_month_other_days_background_drawable, -1);
            if (currentMonthOtherDayBackgroundDrawable > 0) {
                settings.setCurrentMonthOtherDayBackgroundDrawable(ContextCompat.getDrawable(getContext(), currentMonthOtherDayBackgroundDrawable));
            }
            int chosenBackgroundDrawable = typedArray.getResourceId(R.styleable.VRCalendarView_vr_chosen_day_background_drawable, -1);
            if (chosenBackgroundDrawable > 0) {
                settings.setChosenBackgroundDrawable(ContextCompat.getDrawable(getContext(), chosenBackgroundDrawable));
            }
            settings.setNextMonthButton(typedArray.getResourceId(R.styleable.VRCalendarView_vr_next_button, -1));
            settings.setPreviousMonthButton(typedArray.getResourceId(R.styleable.VRCalendarView_vr_previous_button, -1));

            int dayTextSize = typedArray.getDimensionPixelSize(R.styleable.VRCalendarView_vr_calendar_day_text_size, -1);
            settings.setDayTextSize(dayTextSize != -1 ? (int) DensityUtils.convertPixelsToDp(dayTextSize, getContext()) : 14);
            settings.setTitleTextSize(typedArray.getDimensionPixelSize(R.styleable.VRCalendarView_vr_calendar_title_text_size, 14));

            settings.setBackgroundColor(typedArray.getColor(R.styleable.VRCalendarView_vr_background_color, Color.BLACK));
            settings.setTitleTextColor(typedArray.getColor(R.styleable.VRCalendarView_vr_title_text_color, Color.BLACK));
            settings.setDayOfWeeksColor(typedArray.getColor(R.styleable.VRCalendarView_vr_week_days_color, Color.BLACK));

        } finally {
            typedArray.recycle();
        }
        setupViews(settings);
    }

    public void moveToDate(Date date) {
        Calendar currentDate = Calendar.getInstance();
        Calendar moveTo = Calendar.getInstance();
        moveTo.setTimeInMillis(date.getTime());
        int scrollTo = 0;
        if (currentDate.getTimeInMillis() > moveTo.getTimeInMillis()) {
            while (true) {
                scrollTo--;
                currentDate.add(Calendar.MONTH, -1);
                if (currentDate.get(Calendar.YEAR) == moveTo.get(Calendar.YEAR) && currentDate.get(Calendar.MONTH) == moveTo.get(Calendar.MONTH)) {
                    break;
                }
            }
        } else if (currentDate.getTimeInMillis() < moveTo.getTimeInMillis()) {
            while (true) {
                scrollTo++;
                currentDate.add(Calendar.MONTH, 1);
                if (currentDate.get(Calendar.YEAR) == moveTo.get(Calendar.YEAR) && currentDate.get(Calendar.MONTH) == moveTo.get(Calendar.MONTH)) {
                    break;
                }
            }
        }
        int pos = (CalendarPagerAdapter.MONTH_QUANTITY / 2 + scrollTo);
        viewPager.setCurrentItem(pos);
    }

    public void setDateFormat(DateFormat dateFormat) {
        df = dateFormat;
        handleDateFormate();
    }

    public CalendarSettingWrapper getSettings() {
        return mCalendarSettingWrapper;
    }

    public ImageButton getNextMonthImageButton() {
        return mNext;
    }

    public ImageButton getPreviousMonthImageButton() {
        return mPrevious;
    }

    public TextView getTitleCalendarDate() {
        return tvCalendarDate;
    }

    public View titleContainer() {
        return findViewById(R.id.rBarTitle);
    }

    public View weekContainer() {
        return findViewById(R.id.calendar_days);
    }

    public TextView getDayOfWeekTextView(int dayOfWeek) {
        return mTvWeekDays[dayOfWeek];
    }

    public View getCalendarContainerView() {
        return findViewById(R.id.container);
    }

    private void setupViews(Settings settings) {
        setClickable(true);
        inflate(mContext, R.layout.calendar_view, this);
        tvCalendarDate = findViewById(R.id.tv_calendar_date);
        viewPager = findViewById(R.id.view_pager);
        mPrevious = findViewById(R.id.calendar_prev_month);
        mTvWeekDays = new TextView[]{findViewById(R.id.tvMonday)
                , findViewById(R.id.tvTuesday)
                , findViewById(R.id.tvWednesday)
                , findViewById(R.id.tvThursday)
                , findViewById(R.id.tvFriday)
                , findViewById(R.id.tvSaturday)
                , findViewById(R.id.tvSunday)};
        for (TextView textView : mTvWeekDays) {
            textView.setTextColor(settings.getDayOfWeeksColor());
        }
        findViewById(R.id.container).setBackgroundColor(settings.getBackgroundColor());
        mPrevious.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        mNext = findViewById(R.id.calendar_next_month);
        mNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        if (settings.getNextMonthButton() != -1) {
            mNext.setImageResource(settings.getNextMonthButton());
        }
        if (settings.getPreviousMonthButton() != -1) {
            mPrevious.setImageResource(settings.getPreviousMonthButton());
        }

        tvCalendarDate.setTextColor(settings.getTitleTextColor());
        tvCalendarDate.setTextSize(settings.getTitleTextSize());
        Date date = new Date();

        tvCalendarDate.setText(df.format(date.getTime()));

        mCalendarSettingWrapper = new CalendarSettingWrapper(settings);

        mCalendarPagerAdapter = new CalendarPagerAdapter(mContext, mCalendarSettingWrapper);
        viewPager.setAdapter(mCalendarPagerAdapter);
        viewPager.setCurrentItem(CalendarPagerAdapter.MONTH_QUANTITY / 2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                handleDateFormate();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        df = settings.getDateFormat();
    }

    private void handleDateFormate() {
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.MONTH, -(CalendarPagerAdapter.MONTH_QUANTITY / 2 - viewPager.getCurrentItem()));
        tvCalendarDate.setText(df.format(currentDate.getTimeInMillis()));
    }

}
