package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	MemberVO vo = null;
	ArrayList<MemberVO> al = null;
	int cnt = 0;
	boolean check = false;
	
	public void connection() {
		//1. 드라이버 동적로딩
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String dbid = "campus_a_3_1025";
		String dbpw = "smhrd3";
		
		
		//2.데이터베이스 연결 객체(Connection) 생성
		conn = DriverManager.getConnection(url,dbid,dbpw);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}
	
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			
		}
	}
	
	
	
	
	
	public MemberVO login(String m_id,String m_pw) {
		try {
			connection();
			
			String sql = "Select * from MEMBERS where m_id = ? and m_pw = ?";
			psmt	= conn.prepareStatement(sql);
			psmt.setString(1, m_id);
			psmt.setString(2, m_pw);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String get_id = rs.getString(1);
				String get_pw = rs.getString(2);
				String get_name = rs.getString(3);
				
				vo = new MemberVO(get_id,get_pw,get_name);
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
			
	}return vo;
	}
	

	public boolean idCheck(String m_id) {
		boolean check = false;
		try {
			connection();
			
			String sql = "Select m_id from MEMBERS where m_id = ?";
			psmt	= conn.prepareStatement(sql);
			psmt.setString(1, m_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
			
	}
		return check;
	}
	
	
}
