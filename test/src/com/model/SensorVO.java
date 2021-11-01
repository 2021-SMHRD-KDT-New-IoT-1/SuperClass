package com.model;

public class SensorVO {
	
	private int moveSensor;

	public SensorVO() {
	}

	public SensorVO(int moveSensor) {
		this.moveSensor = moveSensor;
	}

	public int getmoveSensor() {
		return moveSensor;
	}

	public void setmoveSensor(int moveSensor) {
		this.moveSensor = moveSensor;
	}

	@Override
	public String toString() {
		return "SensorVO [moveSensor=" + moveSensor + "]";
	}
	
}
