package com.ArdModel;

//움직임감지값 mpattern 테이블로 넣어야겠네.

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
