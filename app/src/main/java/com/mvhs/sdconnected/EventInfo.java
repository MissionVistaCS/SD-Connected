package com.mvhs.sdconnected;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mvhs.sdconnected.SDConnected.myList;

public class EventInfo extends AppCompatActivity{

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


    public void save(View view){
        boolean write=true;
        this.getFilesDir();
        String path = "myevent.txt";
        File file = SDConnected.RFile;
        List<String> writing = new ArrayList<String>();
        int thisID = getIntent().getIntExtra("infocall",0);
        try {
            FileReader fInput = new FileReader(file);
            BufferedReader br = new BufferedReader(fInput);
            String fileLines;
            List<String> ids = new ArrayList<String>();
            while (br.ready()) {
                fileLines = br.readLine();
                ids = Arrays.asList(fileLines.split(","));
                if(ids.contains(thisID)) {
                    write = false;


                }
            }
            writing = ids;
        }
        catch (IOException ioe)
        {ioe.printStackTrace();}



        if(write) {
            try {
                FileOutputStream fOut = openFileOutput(path, MODE_WORLD_READABLE);
                OutputStreamWriter osw = new OutputStreamWriter(fOut);

                String temp = "";
                for(int i =0;i<writing.size();i++)
                {
                    temp+=writing.get(i);
                    temp+=",";
                }
                temp+=thisID;
                osw.write(temp);

                osw.flush();
                osw.close();
                SDEvent.setFileArrayList(myList);
                int dur = Toast.LENGTH_SHORT;
                Toast to = Toast.makeText(this, "You Have Saved", dur);
                to.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                to.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}
