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

import com.mvhs.sdconnected.network.GetSDEvents;

import java.util.ArrayList;
import java.util.List;

public class SDConnecte extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static String APP_NAME = "SD Connected";
    public static List<SDEvent> sdevents = new ArrayList<>();
    public static int LIMIT = 50;
    public static String link = "http://data.sandiego.gov/api/action/datastore/search.json?resource_id=8a5018b2-7635-416f-a252-cf04e54d6719&limit=";

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

        GetSDEvents.reloadEvents();
    }

    /**
     * This method is called after GetSDEvents is finished.
     */
    public static void onEventGetFinish()
    {
        //Do stuff like updating UI elements
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




