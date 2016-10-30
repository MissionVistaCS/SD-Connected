package com.mvhs.sdconnected;

/**
 * Created by allangarcia-zych on 10/29/16.
 */

public class VotingInfo {
    private String placeName;
    private String line1;
    private String city;
    private String state;
    private String zip;
    private String hours;

    public VotingInfo(String _placeName, String _line1, String _city, String _state, String _zip, String _hours)
    {
        placeName = _placeName;
        line1 = _line1;
        city = _city;
        state = _state;
        zip = _zip;
        hours = _hours;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getLine1() {
        return line1;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getHours() {
        return hours;
    }
}
