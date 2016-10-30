package com.mvhs.sdconnected.network;

import android.os.AsyncTask;
import android.util.Log;
import com.mvhs.sdconnected.SDConnected;
import com.mvhs.sdconnected.SDEvent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetSDEvents extends AsyncTask<String, Integer, Boolean> {

    private SDConnected sdConnected;

    public GetSDEvents(SDConnected sdConnected)
    {
        this.sdConnected = sdConnected;
    }

    public static void reloadEvents(SDConnected sdConnected)
    {
        new GetSDEvents(sdConnected).execute(SDConnected.link + SDConnected.LIMIT);
    }

    @Override
    protected Boolean doInBackground(String... params) {
        try {
            Log.d(SDConnected.APP_NAME, "Starting data scraping!");
            HttpHandler sh = new HttpHandler();

            String json = sh.makeServiceCall(params[0]);

            if (json != null) {
                JSONObject object = new JSONObject(json);
                JSONArray events = object.getJSONObject("result").getJSONArray("records");

                for (int i = 0; i < events.length(); i++) {
                    JSONObject eventObj = events.getJSONObject(i);
                    int id = eventObj.getInt("event_id");
                    String title = eventObj.getString("event_title");
                    String subtitle = eventObj.getString("event_subtitle");
                    String desc = eventObj.getString("event_desc");
                    String loc = eventObj.getString("event_loc");
                    String type = eventObj.getString("event_type");
                    String start = eventObj.getString("event_start").split("T")[0];
                    String startTime = eventObj.getString("event_start").split("T")[1];
                    String end = eventObj.getString("event_end").split("T")[0];
                    String endTime = eventObj.getString("event_end").split("T")[1];
                    String host = eventObj.getString("event_host");
                    String url = eventObj.getString("event_url");
                    //int att = Integer.parseInt(eventObj.getString("exp_attendance").replaceAll(",", ""));
                    //int partips = Integer.parseInt(eventObj.getString("exp_participants").replace(",", ""));
                    String address = eventObj.getString("event_address");

                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date startDate = df.parse(start);
                    Date endDate = df.parse(end);

                    DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
                    Date startTimeD = df2.parse(startTime);
                    Date endTimeD = df2.parse(endTime);

                    startDate.setHours(startTimeD.getHours());
                    startDate.setMinutes(startTimeD.getMinutes());
                    startDate.setSeconds(startTimeD.getSeconds());

                    endDate.setHours(endTimeD.getHours());
                    endDate.setMinutes(endTimeD.getMinutes());
                    endDate.setSeconds(endTimeD.getSeconds());

                    SDConnected.sdevents.add(new SDEvent(id, title, subtitle, desc, loc, type, startDate, endDate, host, url, 0, 0, address, 0, 0));
                    //Log.d(SDConnected.APP_NAME, SDConnected.sdevents.get(i).getStart().toString());
                }
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
        if (aBoolean)
            sdConnected.onEventGetFinish();
    }
}
