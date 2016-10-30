package com.mvhs.sdconnected;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ayates on 10/29/16.
 */

public class SDEvent
{
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

        for(int i = 0; i<SDConnected.sdevents.size();i++)
        {
            if(id == SDConnected.sdevents.get(i).getId())
            {
                e = SDConnected.sdevents.get(i);
                break;
            }
        }

        return e;
    }
    static public ArrayList<SDEvent> filterBetweenTimes(ArrayList<SDEvent> s, String st)
    {
        ArrayList<SDEvent> redone = new ArrayList<SDEvent>();
        int min;
        int max;
        if(st.equals("morning")) {
            min = 5;
            max = 10;
        }
        else if(st.equals("noon")) {
            min = 10;
            max = 15;
        }
        else if(st.equals("afternoon")) {
            min = 15;
            max = 21;
        }
        else {
            min = 21;
            max = 5;
        }

        for(int i = 0; i<s.size();i++)
        {
            int t = s.get(i).getStart().getHours();
            if(st.equals("night") && t<5 || t>21)
            {
                redone.add(s.get(i));
            }
            else if(t>min && t<max)
            {
                redone.add(s.get(i));
            }
        }
        return redone;
    }
    public static ArrayList<SDEvent> filterByType(ArrayList<SDEvent> s, String ty)
    {
        String x="ATHLETIC";
        if(ty.equalsIgnoreCase("athletic")) {
            x="athletic";
        }
        else if(ty.equalsIgnoreCase("concerts")) {
            x="concerts";
        }
        else if(ty.equalsIgnoreCase("exhibits")) {
            x="exhibits";
        }
        else if(ty.equalsIgnoreCase("farmers")) {
            x="farmers";
        }
        else if(ty.equalsIgnoreCase("festival")) {
            x="festival";
        }
        else if(ty.equalsIgnoreCase("parades")) {
            x="parades";
        }
        for(int i=0;i<s.size();i++)
        {
            if(!x.equalsIgnoreCase(s.get(i).getType()))
            {
                s.remove(i);
                i--;
            }
        }
        return s;
    }
    //static public ArrayList<SDEvent> filterByAttendence(ArrayList<SDEvent> s, )

}
