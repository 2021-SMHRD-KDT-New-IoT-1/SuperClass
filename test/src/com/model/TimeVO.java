package com.model;

public class TimeVO {
   private String wake_time;
   private String dayofs;
   private String fade_in;
   private String sound;
   private String weather_sound;
   private String schedule;
   private String pattern;
 
   
	public TimeVO(String wake_time, String dayofs, String fade_in, String sound, String weather_sound, String schedule, String pattern) {
		super();
		this.wake_time = wake_time;
		this.dayofs = dayofs;
		this.fade_in = fade_in;
		this.sound = sound;
		this.weather_sound = weather_sound;
		this.schedule = schedule;
		this.pattern = pattern;
	}

	public String getWake_time() {
		return wake_time;
	}

	public void setWake_time(String wake_time) {
		this.wake_time = wake_time;
	}

	public String getDayofs() {
		return dayofs;
	}

	public void setDayofs(String dayofs) {
		this.dayofs = dayofs;
	}

	public String getFade_in() {
		return fade_in;
	}

	public void setFade_in(String fade_in) {
		this.fade_in = fade_in;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public String getWeather_sound() {
		return weather_sound;
	}

	public void setWeather_sound(String weather_sound) {
		this.weather_sound = weather_sound;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}