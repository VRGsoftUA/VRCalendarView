package com.vrgsoft.calendarview;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.vrgsoft.calendar.VRCalendarCustomViewCallback;
import com.vrgsoft.calendar.calendar_listeners.OnCalendarClickListener;
import com.vrgsoft.calendar.calendar_listeners.OnCalendarLongClickListener;
import com.vrgsoft.calendar.VRCalendarView;
import com.vrgsoft.calendar.calendar_listeners.VRCalendarMonthCallback;
import com.vrgsoft.calendar.VrCalendarDay;
import com.vrgsoft.calendar.VrCalendarDaySettings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnCalendarClickListener, OnCalendarLongClickListener, VRCalendarMonthCallback {

    private VRCalendarView vrCalendarView;
    private DateFormat df = new SimpleDateFormat("yyyy-MMMM-dd", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vrCalendarView = findViewById(R.id.calendar);
        vrCalendarView.getSettings()
                .setOnCalendarClickListener(this)
                .setOnCalendarLongClickListener(this)
                .setVRCalendarMonthCallback(this);

        findViewById(R.id.prev).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, 2019);
                calendar.set(Calendar.MONTH, 6);
                calendar.set(Calendar.DAY_OF_MONTH, 27);
                vrCalendarView.moveToDate(new Date(calendar.getTimeInMillis()));
            }
        });
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, 2015);
                calendar.set(Calendar.MONTH, 6);
                calendar.set(Calendar.DAY_OF_MONTH, 27);
                vrCalendarView.moveToDate(new Date(calendar.getTimeInMillis()));
            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vrCalendarView.getSettings()
                        .setOtherMonthTextStyle(VRCalendarView.BOLD)
                        .setCurrentMonthBackgroundColor(Color.CYAN)
                        .updateCalendar();
            }
        });

        vrCalendarView.setDateFormat(df);
        vrCalendarView.getDayOfWeekTextView(VRCalendarView.TUESDAY).setTextColor(Color.CYAN);
        vrCalendarView.getDayOfWeekTextView(VRCalendarView.WEDNESDAY).setTextSize(20);
        vrCalendarView.getDayOfWeekTextView(VRCalendarView.FRIDAY).setTextColor(Color.GREEN);
        vrCalendarView.getDayOfWeekTextView(VRCalendarView.SUNDAY).setTextColor(Color.RED);
        vrCalendarView.getNextMonthImageButton().setImageResource(R.drawable.ic_next_button_example);
        vrCalendarView.weekContainer().setBackgroundColor(Color.LTGRAY);
        vrCalendarView.titleContainer().setBackgroundColor(Color.GRAY);
    }

    @Override
    public void onCalendarDayClick(VrCalendarDay day) {
        Toast.makeText(MainActivity.this, " " + df.format(day.getDate()), Toast.LENGTH_SHORT).show();

        VrCalendarDay today = new VrCalendarDay();
        today.setVRCalendarCustomViewCallback(new VRCalendarCustomViewCallback() {
            @Override
            public View getNewCustomiseView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.ic_stat_name);
                return imageView;
            }
        });
        today.setDate(day.getDate());

        vrCalendarView.getSettings().updateCalendarDay(today, true);

    }

    @Override
    public void onCalendarDayLongClick(VrCalendarDay day) {
        Toast.makeText(MainActivity.this, "Long " + df.format(day.getDate()), Toast.LENGTH_SHORT).show();

        VrCalendarDay today = new VrCalendarDay();
        today.setDate(day.getDate());
        VrCalendarDaySettings vrCalendarDaySettings = new VrCalendarDaySettings();
        vrCalendarDaySettings.setDayTextStyle(VRCalendarView.BOLD);
        vrCalendarDaySettings.setDayTextSize(13);
        vrCalendarDaySettings.setDayBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        vrCalendarDaySettings.setDayTextColor(ContextCompat.getColor(this, R.color.colorToday));
        today.setVrCalendarDaySettings(vrCalendarDaySettings);

        vrCalendarView.getSettings().updateCalendarDay(today, false);
    }

    @Override
    public List<VrCalendarDay> getCustomizeDayView(Calendar calendar) {

        CustomDayUtils customDayUtils = new CustomDayUtils();

        return customDayUtils.getCustomizeDayView(this);
    }
}
