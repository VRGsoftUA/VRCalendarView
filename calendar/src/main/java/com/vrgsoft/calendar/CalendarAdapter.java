package com.vrgsoft.calendar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class CalendarAdapter extends RecyclerView.Adapter<VRCalendarHolder> {

    private List<VrCalendarDay> mCells;
    private CalendarSettingWrapper mCalendarSettingWrapper;
    private VrCalendarDay chosen;

    CalendarAdapter(List<VrCalendarDay> mCells, CalendarSettingWrapper calendarSettingWrapper) {
        this.mCells = mCells;
        mCalendarSettingWrapper = calendarSettingWrapper;
    }

    @Override
    public VRCalendarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VRCalendarHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar_day, parent, false));
    }

    @Override
    public void onBindViewHolder(final VRCalendarHolder holder, int position) {
        final VrCalendarDay vrCalendarDay = mCells.get(position);

        // TODO: 03.01.18 need to set drawable to custom any user want to
        if (vrCalendarDay.getVRCalendarCustomViewCallback() != null) {
            VRCalendarCustomViewCallback vrCalendarCustomViewCallback = vrCalendarDay.getVRCalendarCustomViewCallback();
            holder.addCustomView(vrCalendarCustomViewCallback.getNewCustomiseView());
        } else {
            holder.addCustomView(null);
        }
        vrCalendarDay.setVRCalendarCustomViewCallback(null);
        if (vrCalendarDay.isChoosen()) {
            holder.setBackgroundToView(mCalendarSettingWrapper.getChosenBackgroundColor(), mCalendarSettingWrapper.getChosenBackgroundDrawable());
            holder.setTextToTextView(mCalendarSettingWrapper.getChosenTextStyle(), mCalendarSettingWrapper.getChosenTextColor(), mCalendarSettingWrapper.getDayTextSize());
        } else {
            holder.setBackgroundToView(vrCalendarDay.getVrCalendarDaySettings().getDayBackgroundColor(), vrCalendarDay.getVrCalendarDaySettings().getDayBackgroundDrawable());
            holder.setTextToTextView(vrCalendarDay.getVrCalendarDaySettings().getDayTextStyle(), vrCalendarDay.getVrCalendarDaySettings().getDayTextColor(), vrCalendarDay.getVrCalendarDaySettings().getDayTextSize());
        }
        holder.tvDay.setText(String.valueOf(vrCalendarDay.getVrCalendarDaySettings().getDay()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCalendarSettingWrapper.getOnCalendarClickListener() != null) {
                    mCalendarSettingWrapper.getOnCalendarClickListener().onCalendarDayClick(vrCalendarDay);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mCalendarSettingWrapper.getOnCalendarLongClickListener() != null) {
                    mCalendarSettingWrapper.getOnCalendarLongClickListener().onCalendarDayLongClick(vrCalendarDay);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCells == null ? 0 : mCells.size();
    }

    void updateAll(List<VrCalendarDay> cells) {
        mCells = cells;
        notifyDataSetChanged();
    }

    void updateDay(VrCalendarDay day, boolean hasToSelect) {
        for (int i = 0; i < mCells.size(); i++) {

            if (chosen != null && VrCalendarUtils.isSameDay(mCells.get(i).getDate(), chosen.getDate())) {
                if (hasToSelect) {
                    mCells.get(i).setChoosen(false);
                    notifyItemChanged(i);
                }
                break;
            }
        }
        for (int i = 0; i < mCells.size(); i++) {
            if (VrCalendarUtils.isSameDay(mCells.get(i).getDate(), day.getDate())) {
                mCells.set(i, day);
                if (hasToSelect) {
                    mCells.get(i).setChoosen(true);
                    chosen = mCells.get(i);
                }
                notifyItemChanged(i);
                break;
            }
        }
    }

}
