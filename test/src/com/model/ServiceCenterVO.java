package com.model;

public class ServiceCenterVO {
	int board_num;
	String board_title;
	String board_contents;
	String board_date;
	String m_id;
	
	public ServiceCenterVO(int board_num,String board_title,String board_date,String m_id) {
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_date = board_date;
		this.m_id = m_id;
	}
	public ServiceCenterVO(int board_num,String board_title,String board_contents,String board_date,String m_id) {
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_contents = board_contents;
		this.board_date = board_date;
		this.m_id = m_id;
	}
	
	
	public int getBoardNum() {
		return board_num;
	}
	public String getBoardTitle() {
		return board_title;
	}
	public String getBoardContents(){
		return board_contents;
	}
	public String getBoardDate() {
		return board_date;
	}
	public String getMid() {
		return m_id;
	}
	
	
	
	
	
}
