package com.iweather.app.model;

/**
 * Created by leon Xu on 2015/4/5 0005.
 */
public class City {
    private int id;
    private int provinceId;
    private String cityName;
    private String cityCode;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getProvinceId(){
        return provinceId;
    }

    public void setProvinceId(int provinceId){
        this.provinceId = provinceId;
    }

    public String getCityName(){
        return cityName;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public String getCityCode(){
        return cityCode;
    }

    public void setCityCode(String cityCode){
        this.cityCode = cityCode;
    }
}
