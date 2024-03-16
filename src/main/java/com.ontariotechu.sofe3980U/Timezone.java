package com.ontariotechu.sofe3980U;

public class Timezone {
    private String timezoneName;
    private int utcOffset;
    
    public Timezone(String name, int offset){
        this.timezoneName=name;
        this.utcOffset=offset;
    }
    public String getTimezoneName(){
	    return this.timezoneName;
    }
    public void setTimezoneName(String name){
	    this.timezoneName=name;
    }
    public int getUtcOffset(){
	    return this.utcOffset;
    }
}