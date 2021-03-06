package com.mvhs.sdconnected;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ayates on 10/29/16.
 */

public class SDEvent {
    private int id;
    private String title;
    private String subtitle;
    private String desc;
    private String loc;
    private String type;
    private Date start;
    private Date end;
    private String host;
    private String url;
    private int attendance;
    private int participants;
    private String address;
    private float latitude;
    private float longitude;

    public SDEvent(int id, String title, String subtitle, String desc, String loc, String type, Date start, Date end, String host, String url, int attendance, int participants, String address, float latitude, float longitude) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.desc = desc;
        this.loc = loc;
        this.type = type;
        this.start = start;
        this.end = end;
        this.host = host;
        this.url = url;
        this.attendance = attendance;
        this.participants = participants;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDesc() {
        return desc;
    }

    public String getLoc() {
        return loc;
    }

    public String getType() {
        return type;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getHost() {
        return host;
    }

    public String getUrl() {
        return url;
    }

    public int getAttendance() {
        return attendance;
    }

    public int getParticipants() {
        return participants;
    }

    public String getAddress() {
        return address;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    static public SDEvent getSDEventByID(int id) {
        SDEvent e = null;

        for (int i = 0; i < SDConnected.sdevents.size(); i++) {
            if (id == SDConnected.sdevents.get(i).getId()) {
                e = SDConnected.sdevents.get(i);
                break;
            }
        }

        return e;
    }

    static public ArrayList<SDEvent> filterBetweenTimes(ArrayList<SDEvent> s, String st) {
        ArrayList<SDEvent> redone = new ArrayList<SDEvent>();
        int min = 0;
        int max = 0;
        if (st.equalsIgnoreCase("morning")) {
            min = 5;
            max = 10;
        } else if (st.equalsIgnoreCase("noon")) {
            min = 10;
            max = 15;
        } else if (st.equalsIgnoreCase("afternoon")) {
            min = 15;
            max = 21;
        } else if (st.equalsIgnoreCase("night")) {
            min = 21;
            max = 5;
        }

        if (st.equalsIgnoreCase("none"))
        {
            redone.addAll(s);
            return redone;
        }

        for (int i = 0; i < s.size(); i++) {
            int t = s.get(i).getStart().getHours();
            if (st.equals("night") && t < 5 || t > 21) {
                redone.add(s.get(i));
            } else if (t > min && t < max) {
                redone.add(s.get(i));
            }
        }
        return redone;
    }

    public static ArrayList<SDEvent> filterByType(ArrayList<SDEvent> s, String ty) {

        List<SDEvent> events = new ArrayList<>();

        for (int i = 0; i < s.size(); i++) {
            if (ty.equalsIgnoreCase("none"))
            {
                events.addAll(s);
                break;
            }
            else if (s.get(i).getType().equalsIgnoreCase(ty))
            {
                events.add(s.get(i));
            }
        }

        return (ArrayList<SDEvent>) events;
    }

    static public ArrayList<SDEvent> addStringIds(ArrayList<SDEvent> s, ArrayList<String> ids) {

        for (int i = 0; i < ids.size(); i++) {

            if (!SDEvent.getSDEventByID(Integer.parseInt(ids.get(i))).equalsOne(s)) {
                s.add(SDEvent.getSDEventByID(Integer.parseInt(ids.get(i))));
            }

        }
        return s;
    }

    public boolean equalsOne(ArrayList<SDEvent> sd) {
        for (SDEvent e : sd) {
            if (this == e)
                return true;
        }
        return false;
    }

    static public ArrayList<SDEvent> setFileArrayList(ArrayList<SDEvent> s) {
        ArrayList<SDEvent> retval = new ArrayList<SDEvent>();
        try {
            File file = new File(SDConnected.file, SDConnected.path);
            FileReader fInput = new FileReader(file);
            BufferedReader br = new BufferedReader(fInput);
            ArrayList<String> d = new ArrayList<String>();
            List<String> blah = new ArrayList<String>();
            blah = Arrays.asList(br.readLine().split(","));
            d.addAll(blah);
            retval = addStringIds(s, d);

            //Log.d(SDConnected.APP_NAME, file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e);
        }
        return retval;
    }
    //static public ArrayList<SDEvent> filterByAttendence(ArrayList<SDEvent> s, )

}
