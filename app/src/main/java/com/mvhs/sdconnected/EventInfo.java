package com.mvhs.sdconnected;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class EventInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);
        final ListView ListView = (ListView) findViewById(R.id.listvi);
//        Intent i = getIntent();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item, getListEventInformation(SDEvent.getSDEventByID(getIntent().getIntExtra("infocall",0))));
        if(adapter!=null)
            ListView.setAdapter(adapter);
    }

    private static ArrayList<String> getListEventInformation(SDEvent e)
    {
        ArrayList<String> i = new ArrayList<>();
        i.add(Integer.toString(e.getId()));
//        try {
//            i.add(Integer.toString(e.getId()));
//        }
//        catch (NullPointerException pe) {
//            System.out.println(pe);
//        }
        if(e.getTitle() != null || e.getSubtitle().equals(""))
        {
            i.add(e.getTitle());
        }
//        try {
//            i.add(e.getTitle());
//        }
//        catch (NullPointerException pe) {
//            System.out.println(pe);
//        }
        if(e.getDesc() != null || e.getDesc().equals(""))
        {
            i.add(e.getDesc());
        }
//        try {
//            i.add(e.getDesc());
//        }
//        catch (NullPointerException pe) {
//            System.out.println(pe);
//        }
        if(e.getType() != null || e.getType().equals(""))
        {
            i.add(e.getType());
        }
        if(e.getStart() != null || e.getStart().equals(""))
        {
            i.add(e.getStart().toString());
        }
        if(e.getEnd() != null || e.getEnd().equals(""))
        {
            i.add(e.getEnd().toString());
        }
        if(e.getHost() != null || e.getHost().equals(""))
        {
            i.add(e.getHost());
        }
//        try {
//            i.add(e.getHost());
//        }
//        catch (NullPointerException pe) {
//            System.out.println(pe);
//        }
        if(e.getUrl() != null || !e.getUrl().equals("") || !e.getUrl().equals(" "))
        {
            i.add(e.getUrl());
        }
//        try {
//            i.add(e.getUrl());
//        }
//        catch (NullPointerException pe) {
//            System.out.println(pe);
//        }
        i.add(Integer.toString(e.getId()));
//        try {
//            i.add(Integer.toString(e.getId()));
//        }
//        catch (NullPointerException pe) {
//            System.out.println(pe);
//        }
        if(e.getLoc() != null || e.getLoc().equals(""))
        {
            i.add(e.getLoc());
        }
//        try {
//            i.add(e.getAddress());
//        }
//        catch (NullPointerException pe) {
//            System.out.println(pe);
//        }
        return(i);
    }


}
