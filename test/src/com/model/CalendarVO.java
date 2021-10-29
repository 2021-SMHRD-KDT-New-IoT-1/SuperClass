package com.model;

import java.util.ArrayList;
import java.util.Collections;

public class CalendarVO {

	private String calendar_op; // option의 title // DB들어감
	private String start; // option의 arg.start
	private String end; // option의 arg.end
	private String allday; // option의 arg.allDay
	private String s_date; // DB에 들어갈 필드 //완료..

	private String[] month_num = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	private String[] month_name = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec" };
	private String month;
	private String[] arr = new String[3];

	public CalendarVO(String calendar_op, String start, String end, String allday) {
		this.calendar_op = calendar_op;
		this.start = start;
		this.end = end;
		this.allday = allday;
	}

	public String makeS_date(String start) {
		
		// 2021부분까지 잘라주기
		start = start.substring(4, 15);
		// 띄어쓰기를 -로 바꿔주기
		start = start.replace(" ", "-");
		// 월 영어까지 잘라주기
		month = start.substring(0, 3); // Oct
		// 월 영어를 숫자로 바꿔주기
		for (int i = 0; i < month_name.length; i++) {
			if (month.equals(month_name[i])) {
				s_date = start.replace(month_name[i], month_num[i]);
			}
		}
		// Oct-06-2021 -> 10-06-2021
		arr = s_date.split("-");
		// 10[0],06[1],2021[2]
		String[] arr2 = s_date.split("-");
		
		arr[0] = arr2[2]; // 2021
		arr[1] = arr2[0]; // 10
		arr[2] = arr2[1]; // 06

		String d = "";
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				d += arr[i] + "-";
			} else {
				d += arr[i];
			}
		}
		this.s_date = d;
		return s_date;
	}

	public String[] getarr() {
		return arr;
	}
	
	
	
	
	public String getCalendar_op() {
		return calendar_op;
	}

	public void setCalendar_op(String calendar_op) {
		this.calendar_op = calendar_op;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getAllday() {
		return allday;
	}

	public void setAllday(String allday) {
		this.allday = allday;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

}
