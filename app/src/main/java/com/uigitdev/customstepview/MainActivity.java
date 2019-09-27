package com.uigitdev.customstepview;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import com.uigitdev.customstepview.adapter.CustomStepViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> groupItems;
    private ExpandableListView expandableListView;
    private CustomStepViewAdapter adapter;
    private int lastStepPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setType();
        initListData();
        setExpandAdapter();
    }

    private void initListData() {
        groupItems = new ArrayList<>();
        groupItems.add("Group title 1");
        groupItems.add("Group title 2");
        groupItems.add("Group title 3");
        groupItems.add("Group title 4");
        groupItems.add("Group title 5");
        groupItems.add("Group title 6");
        groupItems.add("Group title 7");
        groupItems.add("Group title 8");
    }

    private void setType() {
        expandableListView = findViewById(R.id.expand_list_view);
    }

    private void setExpandAdapter() {
        adapter = new CustomStepViewAdapter(MainActivity.this, groupItems);
        expandableListView.setAdapter(adapter);

        //Close open items
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastStepPos != -1 && groupPosition != lastStepPos) {
                    expandableListView.collapseGroup(lastStepPos);
                }
                lastStepPos = groupPosition;
            }
        });
        expandableListView.expandGroup(5);
    }
}
