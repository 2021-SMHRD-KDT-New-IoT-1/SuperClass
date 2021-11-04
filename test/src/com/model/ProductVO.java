package com.model;

import java.sql.Date;
import java.sql.Time;

public class ProductVO {

	
	String p_serialnum;
	String detail_location;
	String p_location;
	String movetime;
	String sleep_time;
	String wake_time;
	int movesensor;
	
	public ProductVO() {
		
	}
	
	public ProductVO(String p_serialnum,String p_location,String detail_location) {
		this.p_serialnum = p_serialnum;
		this.p_location = p_location;
		this.detail_location = detail_location;
	}
	public ProductVO(String p_serialnum,String movetime,int movesensor) {
		this.p_serialnum = p_serialnum;
		this.movetime = movetime;
		this.movesensor = movesensor;
	}
	
	
	
	public String getP_serialnum() {
		return p_serialnum;
	}
	public void setP_serialnum(String p_serialnum) {
		this.p_serialnum = p_serialnum;
	}
	public String getDetail_location() {
		return detail_location;
	}
	public void setDetail_location(String detail_location) {
		this.detail_location = detail_location;
	}
	public String getP_location() {
		return p_location;
	}
	public void setP_location(String p_location) {
		this.p_location = p_location;
	}
	
	public String getSleep_time() {
		return sleep_time;
	}
	public void setSleep_time(String sleep_time) {
		this.sleep_time = sleep_time;
	}
	public String getWake_time() {
		return wake_time;
	}
	public void setWake_time(String wake_time) {
		this.wake_time = wake_time;
	}


	public int getMovesensor() {
		return movesensor;
	}

	public void setMovesensor(int movesensor) {
		this.movesensor = movesensor;
	}

	public String getMovetime() {
		return movetime;
	}

	public void setMovetime(String movetime) {
		this.movetime = movetime;
	}

	
	
	
	
	
}
