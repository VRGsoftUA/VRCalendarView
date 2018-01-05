# VRCalendarView

# Usage

*For a working implementation, Have a look at the Sample Project - app*

1. Include the library as local library project.
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

dependencies {

   compile 'com.github.VRGsoftUA:VRCalendarView:1.0'

}
```
2. Include the VRCalendarView widget in your layout.

	```xml
       <com.vrgsoft.calendar.VRCalendarView
             android:id="@+id/calendar"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             app:vr_background_color="@color/colorDark"
             app:vr_calendar_day_text_size="15sp"
             app:vr_chosen_day_background_color="@color/colorGreen"
             app:vr_chosen_day_background_drawable="@drawable/background"
             app:vr_current_day_text_color="@android:color/darker_gray"
             app:vr_current_month_other_days_background_drawable="@drawable/background"
             app:vr_current_month_other_days_text_color="@color/colorAccent"
             app:vr_current_month_text_color="@android:color/darker_gray"
             app:vr_next_button="@drawable/ic_next"
             app:vr_other_month_text_color="@color/colorPrimary"
             app:vr_previous_button="@drawable/ic_previous"
             app:vr_title_text_color="@color/colorGreen"
             app:vr_week_days_color="@android:color/darker_gray" />
    ```
3. You can do same with java
    ```java
        vrCalendarView.getSettings().setOtherMonthTextStyle(VRCalendarView.BOLD)
                              .setCurrentMonthBackgroundColor(Color.CYAN)
                              .updateCalendar();
    ```
or
    ```java
        vrCalendarView.getSettings()
                       .setOnCalendarClickListener(this)
                       .setOnCalendarLongClickListener(this)
                       .setVRCalendarMonthCallback(this);
    ```

4. You can update all days by calling VRCalendarView.getSettings().updateCalendar();

    ```java
     vrCalendarView.getSettings().setOtherMonthTextStyle(VRCalendarView.BOLD)
                                  .setCurrentMonthBackgroundColor(Color.CYAN)
                                  .updateCalendar();
    ```
    if VRCalendarView.getSettings().updateCalendar(); is called and you want to save some custom day
    List<VrCalendarDay> getCustomizeDayView(Calendar calendar) method should be overridden
    getCustomizeDayView(Calendar calendar) is return all days you need to make custom.
    With parameter calendar you can get the year and the month to return customised days from specific month
    ```java
        @Override
        public List<VrCalendarDay> getCustomizeDayView(Calendar calendar) {
            List<VrCalendarDay> vrCalendarDays = new ArrayList<>();
            VrCalendarDay today = new VrCalendarDay();
            today.setDate(new Date());

            VrCalendarDaySettings todaySettings = new VrCalendarDaySettings();
            todaySettings.setDayTextColor(Color.CYAN);
            today.setVrCalendarDaySettings(todaySettings);
            today.setVRCalendarCustomViewCallback(new VRCalendarCustomViewCallback() {
                @Override
                public View getNewCustomiseView() {
                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setImageResource(R.drawable.ic_stat_name);
                    return imageView;
                }
            });

            vrCalendarDays.add(today);

            VrCalendarDay tomorrow = new VrCalendarDay();
            Date d = new Date(1513435110633L);// December 16, 2017
            tomorrow.setDate(d);
            VrCalendarDaySettings vrtomorCalendarDaySettings = new VrCalendarDaySettings();
            vrtomorCalendarDaySettings.setDayTextStyle(VRCalendarView.BOLD);
            vrtomorCalendarDaySettings.setDayBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            vrtomorCalendarDaySettings.setDayTextColor(ContextCompat.getColor(this, R.color.colorYellow));
            tomorrow.setVrCalendarDaySettings(vrtomorCalendarDaySettings);

            vrCalendarDays.add(tomorrow);

            return vrCalendarDays;
        }
    ```
    You can set set whatever view you want and customise it like you want if standard customisation does not fit
    Attention!!!
    View getNewCustomiseView() should always return new View. other wise it doesn't work properly
    ```java
    today.setVRCalendarCustomViewCallback(new VRCalendarCustomViewCallback() {
                @Override
                public View getNewCustomiseView() {
                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setImageResource(R.drawable.ic_stat_name);
                    return imageView;
                }
            });
    ```

    but if you need to update specific day it is better to call

    ```java
        vrCalendarView.getSettings().updateCalendarDay(VrCalendarDay today, boolean hasToSelect);
    ```
    where VrCalendarDay has settings to customise specific day - hasToSelect should be false than
    and hasToSelect is boolean that sets specific customisation
    not from VrCalendarDay settings but from default settings that has attribute "chosen". Like below
    ```xml
    app:vr_chosen_day_background_color="@color/colorGreen"
    app:vr_chosen_day_background_drawable="@drawable/background"
    ```
    to update specific day you have to set VRCalendarDay.setDate(Date date); - it is required
    ```java
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
    ```



5. There is onClick listener and onLongClick
	```java

      public interface OnCalendarLongClickListener {
          void onCalendarDayLongClick(VrCalendarDay day);
      }
    ```

   and

    ```java
    public interface OnCalendarClickListener {
        void onCalendarDayClick(VrCalendarDay day);
    }

    ```
that returns VrCalendarDay you click on

     #### Customisation
     You can add fields via xml or VrCalendarView or VrCalendarView.getSettings().
Supported fields:
     ```xml
         <attr name="vr_current_day_text_color" format="color" />
               <attr name="vr_current_month_text_color" format="color" />
               <attr name="vr_other_month_text_color" format="color" />
               <attr name="vr_current_month_other_days_text_color" format="color" />
               <attr name="vr_chosen_day_text_color" format="color" />

               <attr name="vr_current_day_background_color" format="color" />
               <attr name="vr_current_month_background_color" format="color" />
               <attr name="vr_other_month_background_color" format="color" />
               <attr name="vr_current_month_other_days_background_color" format="color" />
               <attr name="vr_chosen_day_background_color" format="color" />

               <attr name="vr_current_day_background_drawable" format="integer" />
               <attr name="vr_current_month_background_drawable" format="integer" />
               <attr name="vr_other_month_background_drawable" format="integer" />
               <attr name="vr_current_month_other_days_background_drawable" format="integer" />
               <attr name="vr_chosen_day_background_drawable" format="integer" />

               <attr name="vr_calendar_day_text_size" format="dimension" />
               <attr name="vr_calendar_title_text_size" format="dimension" />

               <attr name="vr_next_button" format="integer" />
               <attr name="vr_previous_button" format="integer" />
               <attr name="vr_title_text_color" format="color" />
               <attr name="vr_background_color" format="color" />
               <attr name="vr_week_days_color" format="color" />


               <attr name="vr_current_day_text_style">
                   <flag name="normal" value="0" />
                   <flag name="bold" value="1" />
                   <flag name="italic" value="2" />
               </attr>
               <attr name="vr_current_month_text_style">
                   <flag name="normal" value="0" />
                   <flag name="bold" value="1" />
                   <flag name="italic" value="2" />
               </attr>
               <attr name="vr_other_month_text_style">
                   <flag name="normal" value="0" />
                   <flag name="bold" value="1" />
                   <flag name="italic" value="2" />
               </attr>
               <attr name="vr_current_month_other_days_text_style">
                   <flag name="normal" value="0" />
                   <flag name="bold" value="1" />
                   <flag name="italic" value="2" />
               </attr>
               <attr name="vr_chosen_day_text_style">
                   <flag name="normal" value="0" />
                   <flag name="bold" value="1" />
                   <flag name="italic" value="2" />
               </attr>
     ```
     #### Contributing
* Contributions are always welcome
* If you want a feature and can code, feel free to fork and add the change yourself and make a pull request
