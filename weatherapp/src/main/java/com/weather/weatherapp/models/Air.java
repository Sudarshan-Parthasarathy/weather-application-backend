package com.weather.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Air {

    public String city, state, on, min_pollution, max_pollution, avg_pollution, station, pollutant_id;

    public Air(String city, String state, String on, String min_pollution, String max_pollution, String station,
            String avg_pollution, String pollutant_id) {

        this.city = city;
        this.state = state;
        this.on = on;
        this.min_pollution = min_pollution;
        this.max_pollution = max_pollution;
        this.station = station;
        this.avg_pollution = avg_pollution;
        this.pollutant_id = pollutant_id;
    }

    Air(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @JsonProperty
    public String getCity() {
        return city;
    }

    @JsonProperty
    public String getState() {
        return state;
    }

    @JsonProperty
    public String getOn() {
        return on;
    }

    @JsonProperty
    public String getStation() {
        return station;
    }

    @JsonProperty
    public String getPollutant_id() {
        return pollutant_id;
    }

    /*
     * @JsonProperty
     * public String getMinpollution() {
     * return min_pollution;
     * }
     * 
     * @JsonProperty
     * public String getMaxpollution() {
     * return max_pollution;
     * }
     * 
     * @JsonProperty
     * public String getAveragepollution() {
     * return avg_pollution;
     * }
     * 
     * @JsonProperty
     * public void setRecord(String records) {
     * this.records = records;
     * }
     */
    @JsonProperty
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty
    public void setPollutant_id(String pollutant_id) {
        this.pollutant_id = pollutant_id;
    }

    @JsonProperty
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty
    public void setOn(String on) {
        this.on = on;
    }

    @JsonProperty
    public void setStation(String station) {
        this.station = station;
    }

    @JsonProperty
    public void setMinpollution(String min_pollution) {
        this.min_pollution = min_pollution;
    }

    @JsonProperty
    public void setMaxpollution(String max_pollution) {
        this.max_pollution = max_pollution;
    }

    @JsonProperty
    public void setAveragepollution(String avg_pollution) {
        this.avg_pollution = avg_pollution;
    }

}