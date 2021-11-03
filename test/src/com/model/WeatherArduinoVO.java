package com.model;

public class WeatherArduinoVO {
	
	String st; //sleep_time;
 	String wt; //wake_time;
	String d; //dayofs;
	String fi; // fade_in;
	String s; //sound;
	String ws; //weather_sound;
	String sc; //schedule;
	String sp; //sleep_pattern;
	
	
	
	
	public WeatherArduinoVO(String st, String wt, String d, String fi, String s, String ws, String sc, String sp) {
	
		this.st = st;
		this.wt = wt;
		this.d = d;
		this.fi = fi;
		this.s = s;
		this.ws = ws;
		this.sc = sc;
		this.sp = sp;
	}




	@Override
	public String toString() {
		return "WeatherArduinoVO [st=" + st + ", wt=" + wt + ", d=" + d + ", fi=" + fi + ", s=" + s + ", ws=" + ws
				+ ", sc=" + sc + ", sp=" + sp + "]";
	}









}
