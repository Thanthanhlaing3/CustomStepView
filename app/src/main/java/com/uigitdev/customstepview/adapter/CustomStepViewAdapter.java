package com.uigitdev.customstepview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.uigitdev.customstepview.R;
import com.uigitdev.customstepview.uigitdev.design.GroupContent;
import com.uigitdev.customstepview.uigitdev.design.GroupHeader;

import java.util.ArrayList;

public class CustomStepViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<String> groupItems;
    private GroupHeader groupHeader;

    public CustomStepViewAdapter(Context context, ArrayList<String> groupItems) {
        this.context = context;
        this.groupItems = groupItems;
    }

    @Override
    public int getGroupCount() {
        return groupItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.groupItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.groupItems.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_group, null);

        groupHeader = new GroupHeader(context, convertView);
        groupHeader.setCount(groupPosition + 1);
        groupHeader.setGroupTitle(groupItems.get(groupPosition));
        groupHeader.hideTopBottomLine(groupPosition, 0, groupItems.size() - 1);
        groupHeader.setTitleColor(context.getString(R.color.colorWhite));
//        groupHeader.setCountTextColor(context.getString(R.color.colorPrimary));
//        groupHeader.setCountBackgroundColor(context.getString(R.color.colorWhite));
//        groupHeader.setTopLineColor(context.getString(R.color.colorWhite));
//        groupHeader.setBottomLineColor(context.getString(R.color.colorWhite));
        groupHeader.setCountBackgroundColor(groupPosition + 1, 4, context.getString(R.color.colorSelect));
        groupHeader.setFailed(groupPosition + 1, 6, context.getString(R.color.colorFailed), "Failed msg");
        return convertView;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //todo Create a new view for each item.

        switch (groupPosition + 1) {
            case 1:
                //todo item_group_content_1
                convertView = layoutInflater.inflate(R.layout.item_group_content_2, null);
                return convertView;
            case 2:
                //todo item_group_content_2
                convertView = layoutInflater.inflate(R.layout.item_group_content_2, null);
                return convertView;
            case 3:
                //todo item_group_content_3
                convertView = layoutInflater.inflate(R.layout.item_group_content_2, null);
                return convertView;
            case 4:
                //todo item_group_content_4
                convertView = layoutInflater.inflate(R.layout.item_group_content_2, null);
                return convertView;
            case 5:
                //todo item_group_content_5
                convertView = layoutInflater.inflate(R.layout.item_group_content_2, null);
                return convertView;
            case 6:
                convertView = layoutInflater.inflate(R.layout.item_group_content, null);
                GroupContent groupContent = new GroupContent(context, convertView);
                groupContent.setFailed(groupPosition + 1, 6, context.getString(R.color.colorFailed));
                return convertView;
            case 7:
                //todo item_group_content_7
                convertView = layoutInflater.inflate(R.layout.item_group_content_2, null);
                return convertView;
            case 8:
                //todo item_group_content_8
                convertView = layoutInflater.inflate(R.layout.item_group_content, null);
                groupHeader.showBottomLine(groupPosition, groupItems.size() - 1);
                return convertView;
        }
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
