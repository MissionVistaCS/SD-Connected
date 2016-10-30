package com.mvhs.sdconnected;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.mvhs.sdconnected.network.GetVoterInfo;


public class VotingLocationResults extends AppCompatActivity {


    private TextView myAddress;
    private TextView address;
    private TextView city;
    private TextView state;
    private TextView zip;
    private TextView place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String message = intent.getStringExtra(VotingLocationSearch.EXTRA_MESSAGE);
        setContentView(R.layout.activity_voting_location_results);
        myAddress = (TextView) findViewById(R.id.textView4);
        address = (TextView) findViewById(R.id.addressLine);
        city = (TextView) findViewById(R.id.cityLabel);
        state = (TextView) findViewById(R.id.stateLabel);
        zip = (TextView) findViewById(R.id.zipLabel);
        place = (TextView) findViewById(R.id.nameLabel);
        myAddress.setText(message);

        new GetVoterInfo(this).execute(makeRequest(message));


    }

    String makeRequest(String rawAddress){
        String[] tokens = rawAddress.split(" ");
        String output = "https://www.googleapis.com/civicinfo/v2/voterinfo?address=";
        output += TextUtils.join("+", tokens) + "&key=AIzaSyCK-XMR_gtggfXHAinOvIbGKJMOm4ljWCA";
        return (output);
    }



    public void setPlaceName(String place) {
        this.place.setText(place);

    }

    public void setAddress(String address) {
        this.address.setText(address);
    }

    public void setCity(String city) {
        this.city.setText(city);
    }

    public void setState(String state) {
        this.state.setText(state);
    }

    public void setZip(String zip) {
        this.zip.setText(zip);
    }
}


