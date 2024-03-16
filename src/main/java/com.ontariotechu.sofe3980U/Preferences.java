package com.ontariotechu.sofe3980U;

public class Preferences {
    private boolean use12HourFormat;

    public Preferences(boolean use12HourFormat){
	    this.use12HourFormat=use12HourFormat;
    }
    public void setPreference(boolean pref){
	    this.use12HourFormat=pref;
    }
    public boolean getPreference(){
	    return this.use12HourFormat;
    }
}