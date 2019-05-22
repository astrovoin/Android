package com.example.weather;

import java.io.Serializable;

public class Parcel implements Serializable {
    public String text_rain;
    public String text_city;
    public String text_fog;
    public String text_wind;
    public String text_suncloud;

    public String getText_rain() {
        return text_rain;
    }

    public void setText_rain(String text_rain) {
        this.text_rain = text_rain;
    }

    public String getText_city() {
        return text_city;
    }

    public void setText_city(String text_city) {
        this.text_city = text_city;
    }

    public String getText_fog() {
        return text_fog;
    }

    public void setText_fog(String text_fog) {
        this.text_fog = text_fog;
    }

    public String getText_wind() {
        return text_wind;
    }

    public void setText_wind(String text_wind) {
        this.text_wind = text_wind;
    }

    public String getText_suncloud() {
        return text_suncloud;
    }

    public void setText_suncloud(String text_suncloud) {
        this.text_suncloud = text_suncloud;
    }
}
