package com.example.abdelazim.code_19_expandablerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class AchievementsAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> headerList;
    private HashMap<String, List<String>> listHashMap;

    private final OnChildClickListener onChildClickListener;

    public interface OnChildClickListener {
        void onChildClick(String header, String child);
    }

    public AchievementsAdapter(Context context, List<String> headerList, HashMap<String, List<String>> listHashMap, OnChildClickListener onChildClickListener) {
        this.context = context;
        this.headerList = headerList;
        this.listHashMap = listHashMap;
        this.onChildClickListener = onChildClickListener;
    }

    @Override
    public int getGroupCount() {
        return headerList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashMap.get(headerList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(headerList.get(groupPosition)).get(childPosition);
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievements_header, parent, false);
        }
        TextView headerTitleTextView = convertView.findViewById(R.id.day_textView);
        headerTitleTextView.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childTitle = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievements_child, parent, false);
        }
        TextView childTitleTextView = convertView.findViewById(R.id.achievement_textView);
        childTitleTextView.setText(childTitle);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String header = (String) getGroup(groupPosition);
                String child = (String) getChild(groupPosition, childPosition);
                onChildClickListener.onChildClick(header, child);
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
