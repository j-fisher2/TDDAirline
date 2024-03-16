package com.ontariotechu.sofe3980U;

public class Country {
    private String countryCode;
    private String countryName;

    public Country(String code, String name){
        this.countryCode=code;
        this.countryName=name;
    }
    public String getCountryName(){
	    return this.countryName;
    }
    public void setCountryName(String name){
	    this.countryName=name;
    }
    public String getCountryCode(){
	    return this.countryCode;
    }
    public void setCountryCode(String code){
	    this.countryCode=code;
    }
}