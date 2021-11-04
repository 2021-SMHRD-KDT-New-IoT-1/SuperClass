package com.ArdCon;

public class Counting {
	
	public static int count = 0;
	public static int tmp = 0;
	
	public static int Count() {
		return ++count;
		
	}
	
	public static void CountZero() {
		count = 0;
		
	}
	public static int tmpCount() {
		return ++tmp;
	}
	public static void tmpZero() {
		tmp = 0;
		
	}
	public static int gettmp() {
		return tmp;
	}
	
	
}
