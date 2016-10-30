package com.mvhs.sdconnected;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SDConnected extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] Titles = {"My Events", "Search Events", "Voting Locations", "Trending", "Options"};
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdconnected);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, Titles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = ((TextView) view).getText().toString();
        if(s.equals("Search Events"))
        {
            Intent i = new Intent(this,SearchEvents.class);
            startActivity(i);
        }
        else if(s.equals("Voting Locations"))
        {
            Intent i = new Intent(this,VotingLocationSearch.class);
            startActivity(i);
        }
        else
        {
            
        }

    }
}




