
package com.crvsh.weatherrestapi.weatherapi.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Coord {

    @SerializedName("lat")
    private Double Lat;
    @SerializedName("lon")
    private Double Lon;

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    public Double getLon() {
        return Lon;
    }

    public void setLon(Double lon) {
        Lon = lon;
    }

}
