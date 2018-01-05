package com.vrgsoft.calendar;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

class VRCalendarHolder extends RecyclerView.ViewHolder {

    TextView tvDay;
    View vBackground;
    FrameLayout vCustomBack;

    VRCalendarHolder(View itemView) {
        super(itemView);
        tvDay = itemView.findViewById(R.id.tv_day);
        vBackground = itemView.findViewById(R.id.vBackground);
        vCustomBack = itemView.findViewById(R.id.vCustomBack);

    }

    void setTextToTextView(int style, int color, int textSize) {
        tvDay.setTypeface(null, style);
        tvDay.setTextColor(color);
        tvDay.setTextSize(textSize);
    }

    void setBackgroundToView(int color, Drawable drawable) {
        itemView.setBackgroundColor(color);
        vBackground.setBackground(drawable);
    }


    void addCustomView(View newCustomiseView) {
        if (newCustomiseView != null) {
            ViewGroup viewGroup = (ViewGroup) newCustomiseView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(newCustomiseView);
            }
            vCustomBack.addView(newCustomiseView);
        } else {
            vCustomBack.removeAllViews();
        }
    }
}
