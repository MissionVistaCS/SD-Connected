package com.mvhs.sdconnected.network;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.mvhs.sdconnected.R;
import com.mvhs.sdconnected.SDConnected;
import com.mvhs.sdconnected.SDEvent;
import com.mvhs.sdconnected.VotingInfo;
import com.mvhs.sdconnected.VotingLocationResults;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by allangarcia-zych on 10/29/16.
 */

public class GetVoterInfo extends AsyncTask<String, Integer, VotingInfo> {

    VotingLocationResults results;
    public GetVoterInfo(VotingLocationResults results)
    {
        this.results=results;
    }

    @Override
    protected VotingInfo doInBackground(String[] params) {
        try {
            Log.d(SDConnected.APP_NAME, "Starting data scraping!");
            HttpHandler sh = new HttpHandler();
            String json = sh.makeServiceCall(params[0]);

            if (json != null) {
                JSONObject object = new JSONObject(json);
                JSONObject address = object.getJSONArray("pollingLocations").getJSONObject(0).getJSONObject("address");


                String type = address.getString("locationName");
                String title = address.getString("line1");
                String city = address.getString("city");
                String state = address.getString("state");
                String zip = address.getString("zip");

                String hours = object.getJSONArray("pollingLocations").getJSONObject(0).getString("pollingHours");


                return new VotingInfo(type, title, city, state, zip, hours);
            }
        } catch (Exception e) {
            Log.e(SDConnected.APP_NAME, "Error", e);
            return null;
        }

        return null;
    }

    @Override
    protected void onPostExecute(VotingInfo info) {
        super.onPostExecute(info);
        try{
            results.setPlaceName(info.getPlaceName());
            results.setAddress(info.getLine1());
            results.setCity(info.getCity());
            results.setState(info.getState());
            results.setZip(info.getZip());

        }
        catch (NullPointerException n){

        }
    }
}
