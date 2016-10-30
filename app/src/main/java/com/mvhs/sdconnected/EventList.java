package com.mvhs.sdconnected;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;

import static com.mvhs.sdconnected.SDConnected.sdevents;
import static com.mvhs.sdconnected.SearchEvents.list2;

public class EventList extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<SDEvent> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        String s = getIntent().getDataString();

        final ListView ListView = (ListView) findViewById(R.id.datlist);
        String forList[] = new String[list2.size()];

        for(int i =0;i<forList.length;i++)
        {
            forList[i]=""+list2.get(i).getTitle();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.drawer_list_item,forList);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int itemPosition = position;
        //String itemValue = (String) ListView.getItemAtPosition(position);
        //System.out.println(itemValue);
        Intent i = new Intent(this,EventInfo.class);
        i.putExtra("yo",list2.get(position).getId());


    }

    public void addItems(View v) {

        adapter.notifyDataSetChanged();
    }


}
