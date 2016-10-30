package com.mvhs.sdconnected;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventList extends AppCompatActivity {

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<SDEvent> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        String s = getIntent().getDataString();

        final ListView listView = (ListView) findViewById(R.id.datlist);


        adapter = new ArrayAdapter<SDEvent>(this, R.layout.drawer_list_item, SearchEvents.list2);
        System.out.println("words");
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });*/
    }

    public void addItems(View v) {

        adapter.notifyDataSetChanged();
    }


}
