package com.iweather.app.model;

/**
 * Created by leon Xu on 2015/4/5 0005.
 */
public class County {
    private int id;
    private int cityId;
    private String countyName;
    private String countyCode;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getCityId(){
        return cityId;
    }

    public void setCityId(int cityId){
        this.cityId = cityId;
    }

    public String getCountyName(){
        return countyName;
    }

    public void setCountyName(String countyName){
        this.countyName = countyName;
    }

    public String getCountyCode(){
        return countyCode;
    }

    public void setCountyCode(String countyCode){
        this.countyCode = countyCode;
    }
}
