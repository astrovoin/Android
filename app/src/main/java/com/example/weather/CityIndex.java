package com.example.weather;

import java.io.Serializable;

public class CityIndex implements Serializable {
    private int index;
    private String cityName;
    private String condition;


    public CityIndex(int imageIndex, String cityName, String condition) {
        this.index = imageIndex;
        this.cityName = cityName;
        this.condition = condition;

    }

    public int getIndex() {
        return index;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCondition() {
        return condition;
    }
}
