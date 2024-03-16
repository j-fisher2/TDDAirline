package com.ontariotechu.sofe3980U;

public class City {
    String name;
    Timezone timezone;
    Country country;

    public City(String name, Timezone timezone, Country country){
        this.name=name;
        this.timezone=timezone;
        this.country=country;
    }
}
