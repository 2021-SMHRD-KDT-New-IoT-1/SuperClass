package com.ArdCon;

public class timeTest {

	public static void main(String[] args) {
		
		// 20:47 ����
		
		// 07:30 ����
		
		String sleepTime = "20:47";
		String wakeTime = "07:30";
		
		int dayM = 60*24; // �Ϸ� �� ��
		
		// ���� �ڱ������ �ð� ~ 00 : 00 --> 24:00 == dayM --> dayM - �ڱ������ �ð�(��)
		String[] sleep = sleepTime.split(":");
		int sleepT = Integer.parseInt(sleep[0]) * 60 + Integer.parseInt(sleep[1]);
		System.out.println(dayM - sleepT);
		
		
		// 00 : 00 ~ �Ͼ �ð� --> �׳� ������ �ٲ� �� �ִ�.
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
