package com.vrgsoft.calendarview;

import android.content.Context;
import android.widget.RelativeLayout;

public class CustomView extends RelativeLayout {

    public CustomView(Context context) {
        super(context);
        init();
    }

    private void init() {

        inflate(getContext(), R.layout.custom_view, this);

    }


}
