
package com.crvsh.weatherrestapi.weatherapi.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Clouds {

    @SerializedName("all")
    private Long All;

    public Long getAll() {
        return All;
    }

    public void setAll(Long all) {
        All = all;
    }

}
