package com.model;

public class GetSoundVO {

	
	String s; //sound;
	String ws; //weather_sound;
	String sc; //schedule;

	

	public GetSoundVO(String s, String ws, String sc) {

		this.s = s;
		this.ws = ws;
		this.sc = sc;

	}



	@Override
	public String toString() {
		return "GetSoundVO [s=" + s + ", ws=" + ws + ", sc=" + sc + "]";
	}

	

}
