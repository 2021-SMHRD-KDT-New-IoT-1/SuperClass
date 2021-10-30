package com.model;

public class MemberVO {
	
	private String m_id;
	private String m_pw;
	private String m_name;
	
	public MemberVO(String m_id, String m_pw, String m_name) {
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
	}
	public MemberVO() {
		
	}
	 
	public String getId() {
		return m_id;
	}
	public String getPw() {
		return m_pw;
	}
	public String getName() {
		return m_name;
	}

}
