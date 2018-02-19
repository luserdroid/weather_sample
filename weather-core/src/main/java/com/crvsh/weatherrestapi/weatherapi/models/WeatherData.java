
package com.crvsh.weatherrestapi.weatherapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class WeatherData {

    @SerializedName("city")
    private City city;

    @SerializedName("cnt")
    private long cnt;

    @SerializedName("cod")
    private String cod;

    @SerializedName("list")
    private List<Details> details;

    @SerializedName("message")
    private double message;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

}
