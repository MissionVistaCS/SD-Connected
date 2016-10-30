package com.mvhs.sdconnected;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;


public class VotingLocationSearch extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.mvhs.sdconnected";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_location_search);
    }

    public void searchButton(View button){
        Intent intent = new Intent(this, VotingLocationResults.class);
        EditText addressField = (EditText) findViewById(R.id.editText2);
        String string = addressField.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, string);
        startActivity(intent);
    }
}
