package com.uigitdev.customstepview.uigitdev.design;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.uigitdev.customstepview.R;

public class GroupContent {
    private Context context;
    private View parent_line;

    public GroupContent(Context context, View view) {
        this.context = context;
        setType(view);
    }

    private void setType(View view) {
        parent_line = view.findViewById(R.id.parent_line);
    }

    public void parentLineColor(String color) {
        parent_line.setBackgroundColor(Color.parseColor(color));
    }

    public void setFailed(int currentPos, int failedPos, String failedColor) {
        if (currentPos == failedPos) {
            parentLineColor(failedColor);
        }
    }
}
