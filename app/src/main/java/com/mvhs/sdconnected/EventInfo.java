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
//        Intent i = getIntent();
        SDEvent e = new SDEvent(0,"title","subtitle","description","location","type", new Date(1999,12,17),new Date(1999,12,18),"host","url",0,0,"address",0,0);
        getListEventInformation(e);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_event_list, (String[]) getListEventInformation(e).toArray());
        ((ListView) findViewById(R.id.datlist)).setAdapter(adapter);
    }

    private static ArrayList<String> getListEventInformation(SDEvent e)
    {
        ArrayList<String> i = new ArrayList<>();
//        i.add(Integer.toString(e.getId()));
        try {
            i.add(Integer.toString(e.getId()));
        }
        catch (NullPointerException pe) {
            System.out.println(pe);
        }
//        if(e.getTitle() != null || e.getSubtitle().equals(""))
//        {
//            i.add(e.getTitle());
//        }
        try {
            i.add(e.getTitle());
        }
        catch (NullPointerException pe) {
            System.out.println(pe);
        }
//        if(e.getSubtitle() != null || e.getSubtitle().equals(""))
//        {
//            i.add(e.getSubtitle());
//        }
        try {
            i.add(e.getSubtitle());
        }
        catch (NullPointerException pe) {
            System.out.println(pe);
        }
//        if(e.getDesc() != null || e.getDesc().equals(""))
//        {
//            i.add(e.getDesc());
//        }
        try {
            i.add(e.getDesc());
        }
        catch (NullPointerException pe) {
            System.out.println(pe);
        }
//        if(e.getType() != null || e.getType().equals(""))
//        {
//            i.add(e.getType());
//        }
//        if(e.getStart() != null || e.getStart().equals(""))
//        {
//            i.add(e.getStart().toString());
//        }
//        if(e.getEnd() != null || e.getEnd().equals(""))
//        {
//            i.add(e.getEnd().toString());
//        }
//        if(e.getHost() != null || e.getHost().equals(""))
//        {
//            i.add(e.getHost());
//        }
        try {
            i.add(e.getHost());
        }
        catch (NullPointerException pe) {
            System.out.println(pe);
        }
//        if(e.getUrl() != null || e.getUrl().equals(""))
//        {
//            i.add(e.getUrl());
//        }
        try {
            i.add(e.getUrl());
        }
        catch (NullPointerException pe) {
            System.out.println(pe);
        }
//        i.add(Integer.toString(e.getId()));
        try {
            i.add(Integer.toString(e.getId()));
        }
        catch (NullPointerException pe) {
            System.out.println(pe);
        }
//        if(e.getAddress() != null || e.getAddress().equals(""))
//        {
//            i.add(e.getAddress());
//        }
        try {
            i.add(e.getAddress());
        }
        catch (NullPointerException pe) {
            System.out.println(pe);
        }
        return(i);
    }


}
