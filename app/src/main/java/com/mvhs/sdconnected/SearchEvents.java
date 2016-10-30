package com.mvhs.sdconnected;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SearchEvents extends AppCompatActivity implements View.OnClickListener {

    static ArrayList<SDEvent> list2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_events);

        final Button button = (Button) findViewById(R.id.Search);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, EventList.class);
        list2.addAll(SDConnected.sdevents);
        startActivity(i);
    }
}
