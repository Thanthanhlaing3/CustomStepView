package com.uigitdev.customstepview.uigitdev.design;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.uigitdev.customstepview.R;

public class GroupHeader {
    private View top_line, bottom_line;
    private CardView group_count_circle_parent;
    private TextView group_count, group_item_title, group_item_subtitle;

    public GroupHeader(Context context, View view) {
        setType(view);
    }

    private void setType(View view) {
        top_line = view.findViewById(R.id.top_line);
        bottom_line = view.findViewById(R.id.bottom_line);
        group_count_circle_parent = view.findViewById(R.id.group_count_circle_parent);
        group_count = view.findViewById(R.id.group_count);
        group_item_title = view.findViewById(R.id.group_item_title);
        group_item_subtitle = view.findViewById(R.id.group_item_subtitle);
    }

    public void setCount(int count) {
        group_count.setText(String.valueOf(count));
    }

    public void setGroupTitle(String title) {
        group_item_title.setText(title);
    }

    public void setGroupSubtitle(String subtitle) {
        group_item_subtitle.setText(subtitle);
    }

    public void hideTopBottomLine(int pos, int firstPos, int lastPos) {
        if (pos == firstPos) {
            top_line.setVisibility(View.GONE);
        }
        if (pos == lastPos) {
            bottom_line.setVisibility(View.GONE);
        }
    }

    public void showBottomLine(int pos, int lastPos) {
        if (pos == lastPos) {
            bottom_line.setVisibility(View.VISIBLE);
        }
    }

    public void setCountTextColor(String color) {
        group_count.setTextColor(Color.parseColor(color));
    }

    public void setTitleColor(String color) {
        group_item_title.setTextColor(Color.parseColor(color));
    }

    public void setSubtitleColor(String color) {
        group_item_subtitle.setTextColor(Color.parseColor(color));
    }

    public void setCountBackgroundColor(String color) {
        group_count_circle_parent.setCardBackgroundColor(Color.parseColor(color));
    }

    public void setTopLineColor(String color) {
        top_line.setBackgroundColor(Color.parseColor(color));
    }

    public void setBottomLineColor(String color) {
        bottom_line.setBackgroundColor(Color.parseColor(color));
    }

    public void setCountBackgroundColor(int currentPos, int colorPos, String color) {
        if (currentPos == colorPos) {
            group_count_circle_parent.setCardBackgroundColor(Color.parseColor(color));
        }
    }

    public void setFailed(int currentPos, int failedPos, String failedColor, String failedText) {
        if (currentPos == failedPos) {
            group_item_subtitle.setVisibility(View.VISIBLE);
            setGroupSubtitle(failedText);
            setSubtitleColor(failedColor);
            setCountBackgroundColor(failedColor);
            setBottomLineColor(failedColor);
        }
    }
}
