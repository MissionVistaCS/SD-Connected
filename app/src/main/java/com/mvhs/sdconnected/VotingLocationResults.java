package com.mvhs.sdconnected;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mvhs.sdconnected.network.GetVoterInfo;


public class VotingLocationResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(VotingLocationSearch.EXTRA_MESSAGE);
        setContentView(R.layout.activity_voting_location_results);
        TextView address = (TextView) findViewById(R.id.textView4);
        address.setText(message);
    }
}


