
package com.crvsh.weatherrestapi.weatherapi.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class City {

    @SerializedName("coord")
    private Coord coord;
    @SerializedName("country")
    private String Country;
    @SerializedName("name")
    private String Name;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        coord = coord;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
