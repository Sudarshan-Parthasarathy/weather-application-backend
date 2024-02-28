package com.weather.weatherapp.services;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.weather.weatherapp.models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService extends MappingJackson2HttpMessageConverter {

    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getInstance() {
        return ourInstance;
    }

    private WeatherService() {
        setPrettyPrint(true);
    }

    /*
     * public List<Example> getWeatherForFive(String city) throws ParseException {
     * 
     * String websiteResponse = "http://api.openweathermap.org/data/2.5/forecast?q="
     * + city +
     * "&mode=json&appid="+"9f88036853a400bc9b7f145c20115729"+"&units=metric";
     * 
     * RestTemplate restTemplate = new RestTemplate();
     * String result = restTemplate.getForObject(websiteResponse, String.class);
     * 
     * String description = null;
     * double temp=0;
     * int pressure=0;
     * int humidity = 0;
     * int temp_min=0;
     * int temp_max=0;
     * int temp_kf=0;
     * int sea_level=0;
     * int grnd_level=0;
     * 
     * java.util.Date date1 = null;
     * 
     * String date = null;
     * 
     * String icon=null;
     * String WeatherCondition=null;
     * int id=0;
     * 
     * List<Example> weatherList = new ArrayList<>();
     * 
     * JSONObject root = new JSONObject(result);
     * 
     * SimpleDateFormat dfoutput2 = new SimpleDateFormat("HH");
     * SimpleDateFormat dfoutput1 = new SimpleDateFormat("dd-MM-yyyy");
     * SimpleDateFormat dfinput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     * 
     * JSONArray weatherObject = root.getJSONArray("list");
     * 
     * for(int i = 0; i < weatherObject.length(); i++) {
     * 
     * JSONObject arrayElement = weatherObject.getJSONObject(i);
     * 
     * JSONObject main = arrayElement.getJSONObject("main");
     * temp = (int) main.getFloat("temp");
     * pressure = main.getInt("pressure");
     * humidity = main.getInt("humidity");
     * temp_min = main.getInt("temp_min");
     * temp_max = main.getInt("temp_max");
     * temp_kf = main.getInt("temp_kf");
     * sea_level = main.getInt("sea_level");
     * grnd_level = main.getInt("grnd_level");
     * 
     * description =
     * arrayElement.getJSONArray("weather").getJSONObject(0).getString("description"
     * );
     * icon =
     * arrayElement.getJSONArray("weather").getJSONObject(0).getString("icon");
     * WeatherCondition =
     * arrayElement.getJSONArray("weather").getJSONObject(0).getString("main");
     * id = arrayElement.getJSONArray("weather").getJSONObject(0).getInt("id");
     * 
     * date = arrayElement.getString("dt_txt");
     * 
     * date1 = dfinput.parse(date);
     * 
     * 
     * ForecastWeather fw=new ForecastWeather();
     * Date dt=new Date();
     * Main mn=new Main();
     * Example e = new Example();
     * 
     * Time t = new Time();
     * Weather w = new Weather();
     * 
     * 
     * mn.setTemp(temp);
     * mn.setPressure((int) pressure/10);
     * mn.setHumidity(humidity);
     * mn.setGrndLevel(grnd_level);
     * mn.setSeaLevel(sea_level);
     * mn.setTempKf(temp_kf);
     * 
     * mn.setTempMax(temp_max);
     * mn.setTempMin(temp_min);
     * 
     * w.setDescription(description);
     * w.setIcon(icon);
     * w.setId(id);
     * w.setMain(WeatherCondition);
     * 
     * t.setTime(dfoutput2.format(date1));
     * t.setMain(mn);
     * t.setWeather(w);
     * 
     * dt.setAdditionalProperty(dfoutput2.format(date1), t);
     * 
     * fw.setAdditionalProperty(dfoutput1.format(date1), dt);
     * 
     * e.setForecastWeather(fw);
     * 
     * weatherList.add(e);
     * }
     * 
     * return weatherList;
     * }
     */
    public List<Example> getWeatherForFive(String city) throws ParseException {

        String websiteResponse = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=json&appid="
                + "9f88036853a400bc9b7f145c20115729" + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);

        String description = null;
        double temp = 0;
        int pressure = 0;
        int humidity = 0;
        int temp_min = 0;
        int temp_max = 0;
        int temp_kf = 0;
        int sea_level = 0;
        int grnd_level = 0;

        java.util.Date date1 = null;

        String date = null;

        String icon = null;
        String WeatherCondition = null;
        int id = 0;

        List<Example> weatherList = new ArrayList<>();

        JSONObject root = new JSONObject(result);

        SimpleDateFormat dfoutput2 = new SimpleDateFormat("HH");
        SimpleDateFormat dfoutput1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dfinput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JSONArray weatherObject = root.getJSONArray("list");

        for (int i = 0; i < weatherObject.length(); i++) {

            JSONObject arrayElement = weatherObject.getJSONObject(i);

            JSONObject main = arrayElement.getJSONObject("main");
            temp = (int) main.getFloat("temp");
            pressure = main.getInt("pressure");
            humidity = main.getInt("humidity");
            temp_min = main.getInt("temp_min");
            temp_max = main.getInt("temp_max");
            temp_kf = main.getInt("temp_kf");
            sea_level = main.getInt("sea_level");
            grnd_level = main.getInt("grnd_level");

            description = arrayElement.getJSONArray("weather").getJSONObject(0).getString("description");
            icon = arrayElement.getJSONArray("weather").getJSONObject(0).getString("icon");
            WeatherCondition = arrayElement.getJSONArray("weather").getJSONObject(0).getString("main");
            id = arrayElement.getJSONArray("weather").getJSONObject(0).getInt("id");

            date = arrayElement.getString("dt_txt");

            date1 = dfinput.parse(date);

            ForecastWeather fw = new ForecastWeather();
            Date dt = new Date();
            Main mn = new Main();
            Example e = new Example();

            Time t = new Time();
            Weather w = new Weather();

            mn.setTemp(temp);
            mn.setPressure((int) pressure / 10);
            mn.setHumidity(humidity);
            mn.setGrndLevel(grnd_level);
            mn.setSeaLevel(sea_level);
            mn.setTempKf(temp_kf);

            mn.setTempMax(temp_max);
            mn.setTempMin(temp_min);

            w.setDescription(description);
            w.setIcon(icon);
            w.setId(id);
            w.setMain(WeatherCondition);

            t.setTime(dfoutput2.format(date1));
            t.setMain(mn);
            t.setWeather(w);

            dt.setAdditionalProperty(dfoutput2.format(date1), t);

            fw.setAdditionalProperty(dfoutput1.format(date1), dt);

            e.setForecastWeather(fw);

            weatherList.add(e);
        }

        return weatherList;
    }

    public List<Example> getWeather(String city) {

        String websiteResponse = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&mode=json&appid="
                + "9f88036853a400bc9b7f145c20115729" + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);

        String description = null;
        String WeatherCondition = null;
        double temp;
        double temp_min;
        double temp_max;
        double pressure;
        int humidity;
        String city1 = city;
        String icon = null;
        List<Example> weatherList = new ArrayList<>();

        JSONObject root = new JSONObject(result);

        JSONArray weatherObject = root.getJSONArray("weather");

        for (int i = 0; i < weatherObject.length(); i++) {
            JSONObject elementInArray = weatherObject.getJSONObject(i);
            description = elementInArray.getString("description");
            icon = elementInArray.getString("icon");
            WeatherCondition = elementInArray.getString("main");
        }

        JSONObject main = root.getJSONObject("main");

        temp = (int) main.getFloat("temp");
        pressure = main.getInt("pressure");
        humidity = main.getInt("humidity");
        temp_min = (int) main.getFloat("temp_min");
        temp_max = (int) main.getFloat("temp_max");
        TodaysWeather tw = new TodaysWeather();
        Example e = new Example();
        Today t = new Today();

        t.setDescription(description);
        t.setIcon(icon);
        t.setHumidity(humidity);
        t.setMain(WeatherCondition);
        t.setPressure(pressure);
        t.setCity(city1);
        t.setTemp(temp);
        t.setTempMax(temp_max);
        t.setTempMin(temp_min);
        tw.setToday(t);
        e.setTodaysWeather(tw);

        weatherList.add(e);
        return weatherList;
    }

    public List<Air> getairpollution(String city) {
        String API_KEY = "579b464db66ec23bdd000001087ea13c4b584a92505f51ef3f7462a5";
        String websiteResponse = "https://api.data.gov.in/resource/3b01bcb8-0b14-4abf-b6f2-c1bfd384ba69?api-key="
                + API_KEY + "&format=json&offset=0" + "&filters[city]=" + city;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);
        ArrayList<Air> array = new ArrayList<>();
        JSONObject root = new JSONObject(result);
        JSONArray weatherObject = root.getJSONArray("records");
        String city1 = null;
        String state = null;
        String on = null;
        String station = null;
        String min_pollution = null;
        String max_pollution = null;
        String avg_pollution = null;
        String pollutant_id = null;

        for (int i = 0; i < weatherObject.length(); i++) {

            JSONObject arrayElement = weatherObject.getJSONObject(i);
            state = arrayElement.getString("state");
            city1 = arrayElement.getString("city");
            on = arrayElement.getString("last_update");
            station = arrayElement.getString("station");
            min_pollution = arrayElement.getString("pollutant_min");
            max_pollution = arrayElement.getString("pollutant_max");
            avg_pollution = arrayElement.getString("pollutant_avg");
            pollutant_id = arrayElement.getString("pollutant_id");
            Air a = new Air(city1, state, on, min_pollution, max_pollution, station, avg_pollution, pollutant_id);
            // a.setCity(city1);
            // a.setState(state);
            // a.setOn(on);
            // a.setMaxpollution(max_pollution);
            // a.setMinpollution(min_pollution);
            // a.setStation(station);
            // a.setAveragepollution(avg_pollution);
            // a.setPollutant_id(pollutant_id);
            array.add(a);
        }
        return array;

    }

    public List<Forecast2> getWeatherForFive2(String city) {

        String websiteResponse = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=json&appid="
                + "9f88036853a400bc9b7f145c20115729" + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(websiteResponse, String.class);
        double temp = 0;
        double pressure = 0;
        double humidity = 0;
        double temp_min = 0;
        double temp_max = 0;
        double temp_kf = 0;
        double sea_level = 0;
        double grnd_level = 0;
        String date = null;
        String WeatherCondition = null;
        String city1 = city;
        String icon = null;
        List<Forecast2> weatherList = new ArrayList<>();
        JSONObject root = new JSONObject(result);
        JSONArray weatherObject = root.getJSONArray("list");
        for (int i = 0; i < weatherObject.length(); i++) {

            JSONObject arrayElement = weatherObject.getJSONObject(i);

            JSONObject main = arrayElement.getJSONObject("main");
            date = arrayElement.getString("dt_txt");
            temp = main.getDouble("temp");
            pressure = main.getDouble("pressure");
            humidity = main.getDouble("humidity");
            temp_min = main.getDouble("temp_min");
            temp_max = main.getDouble("temp_max");
            temp_kf = main.getDouble("temp_kf");
            sea_level = main.getDouble("sea_level");
            grnd_level = main.getDouble("grnd_level");
            WeatherCondition = arrayElement.getJSONArray("weather").getJSONObject(0).getString("description");
            icon = arrayElement.getJSONArray("weather").getJSONObject(0).getString("icon");
            Forecast2 f = new Forecast2(date, temp, temp_min, temp_max, pressure, sea_level, grnd_level, humidity,
                    temp_kf, WeatherCondition, city1, icon);

            weatherList.add(f);
        }

        return weatherList;
    }
}
