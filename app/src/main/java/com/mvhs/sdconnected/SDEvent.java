package com.mvhs.sdconnected;

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

    public SDEvent getSDEventByID(int id) {
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
}
