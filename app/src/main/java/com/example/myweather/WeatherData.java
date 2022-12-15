package com.example.myweather;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherData {

    private String mcity,mtemp,micon,mtype;
    private  int mcondition;

    public static WeatherData fromJson(JSONObject jsonObject)
    {

        try
        {
            WeatherData weatherD= new WeatherData();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mcondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mtype=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon=updateWeatherIcon(weatherD.mcondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mtemp=Integer.toString(roundedValue);

            return weatherD;
        }


        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }


    private static String updateWeatherIcon(int condition)
    {
        if(condition>=0 && condition<=300)
        {
            return "rain";
        }
        else if(condition>=300 && condition<=500)
        {
            return "rain";
        }
        else if(condition>=500 && condition<=600)
        {
            return "rain";
        }
        else  if(condition>=600 && condition<=700)
        {
            return "snow";
        }
        else if(condition>=701 && condition<=771)
        {
            return "sunny";
        }

        else if(condition>=772 && condition<=800)
        {
            return "sunny";
        }
        else if(condition==800)
        {
            return "sunny";
        }
        else if(condition>=801 && condition<=804)
        {
            return "sunny";
        }
        else  if(condition>=900 && condition<=902)
        {
            return "rain";
        }
        if(condition==903)
        {
            return "snow";
        }
        if(condition==904)
        {
            return "sunny";
        }
        if(condition>=905 && condition<=1000)
        {
            return "sunny";
        }

        return "dunno";


    }

    public String getmTemperature() {
        return mtemp+"°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getmWeatherType() {
        return mtype;
    }

}
