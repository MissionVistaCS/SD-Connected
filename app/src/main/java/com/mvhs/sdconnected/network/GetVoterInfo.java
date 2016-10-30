package com.mvhs.sdconnected.network;

import android.os.AsyncTask;
import android.util.Log;

import com.mvhs.sdconnected.SDConnected;
import com.mvhs.sdconnected.SDEvent;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by allangarcia-zych on 10/29/16.
 */

public class GetVoterInfo extends AsyncTask<String, Integer, Boolean> {

    @Override
    protected Boolean doInBackground(String[] params) {
        try {
            Log.d(SDConnected.APP_NAME, "Starting data scraping!");
            HttpHandler sh = new HttpHandler();
            String json = sh.makeServiceCall(params[0]);

            if (json != null) {
                JSONObject object = new JSONObject(json);
                JSONObject address = object.getJSONArray("pollingLocations").getJSONObject(0).getJSONObject("address");


                String type = address.getString("locationName");
                String title = address.getString("line1");
                String subtitle = address.getString("city");
                String desc = address.getString("state");
                String loc = address.getString("zip");

                String hours = object.getJSONArray("pollingLocations").getJSONObject(0).getString("pollingHours");


                return true;
            }
        } catch (Exception e) {
            Log.e(SDConnected.APP_NAME, "Error", e);
            return false;
        }

        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
