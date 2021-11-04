package com.ArdCon;

public class timeTest {

	public static void main(String[] args) {
		
		// 20:47 부터
		
		// 07:30 까지
		
		String sleepTime = "20:47";
		String wakeTime = "07:30";
		
		int dayM = 60*24; // 하루 총 분
		
		// 잠을 자기시작한 시간 ~ 00 : 00 --> 24:00 == dayM --> dayM - 자기시작한 시간(분)
		String[] sleep = sleepTime.split(":");
		int sleepT = Integer.parseInt(sleep[0]) * 60 + Integer.parseInt(sleep[1]);
		System.out.println(dayM - sleepT);
		
		
		// 00 : 00 ~ 일어날 시간 --> 그냥 분으로 바꿀 수 있다.
		String[] wake = wakeTime.split(":");
		System.out.println(Integer.parseInt(wake[0]) * 60 + Integer.parseInt(wake[1]));
		int wakeT = Integer.parseInt(wake[0]) * 60 + Integer.parseInt(wake[1]);
		
		int result = (sleepT + wakeT)*60;
		
		System.out.println(result);
		
	}
	
	int result = 0;
	public int scound_time(String sleep_time,String wake_time) {
		
		int dayM = 60*24;
		String[] sleep = sleep_time.split(":");
		int sleepT = Integer.parseInt(sleep[0]) * 60 + Integer.parseInt(sleep[1]);
		System.out.println(dayM - sleepT);
		
		String[] wake = wake_time.split(":");
		System.out.println(Integer.parseInt(wake[0]) * 60 + Integer.parseInt(wake[1]));
		int wakeT = Integer.parseInt(wake[0]) * 60 + Integer.parseInt(wake[1]);
		
		return result = (sleepT + wakeT)*60;
	}

}
