package com.example.abdelazim.code_19_expandablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AchievementsAdapter.OnChildClickListener {

    private List<String> headerList;
    private HashMap<String, List<String>> listHashMap;
    private AchievementsAdapter adapter;
    private ExpandableListView achievementsExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        achievementsExpandableListView = findViewById(R.id.achievements_expandableListView);
        setupData();
        adapter = new AchievementsAdapter(this, headerList, listHashMap, this);
        achievementsExpandableListView.setAdapter(adapter);
    }

    private void setupData() {

        headerList = new ArrayList<>();
        listHashMap = new HashMap<>();

        headerList.add("21 October");
        headerList.add("22 October");
        headerList.add("23 October");

        List<String> O21List = new ArrayList<>();
        O21List.add("no bread");
        listHashMap.put(headerList.get(0), O21List);

        List<String> O22List = new ArrayList<>();
        O22List.add("no bread");
        O22List.add("drink water");
        listHashMap.put(headerList.get(1), O22List);

        List<String> O23List = new ArrayList<>();
        O23List.add("no bread");
        O23List.add("drink water");
        O23List.add("strong breakfast");
        listHashMap.put(headerList.get(2), O23List);
    }

    @Override
    public void onChildClick(String header, String child) {

        Toast.makeText(this, "header: " + header + "child: " + child, Toast.LENGTH_SHORT).show();
    }
}
