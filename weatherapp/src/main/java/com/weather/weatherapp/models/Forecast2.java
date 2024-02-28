package com.weather.weatherapp.models;

public class Forecast2 {
    public String datetime, main, city, icon;
    public Double temp, temp_min, temp_max, pressure, sea_level, grnd_level, humidity, temp_kf;

    public Forecast2(String datetime, Double temp, Double temp_min, Double temp_max, Double pressure, Double sea_level,
            Double grnd_level,
            Double humidity, Double temp_kf, String main, String city, String icon) {

        this.datetime = datetime;
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
        this.humidity = humidity;
        this.temp_kf = temp_kf;
        this.main = main;
        this.city = city;
        this.icon = icon;
    }

    Forecast2(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

}
