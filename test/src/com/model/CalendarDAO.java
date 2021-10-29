package com.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

public class CalendarDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	

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


	public void inSchedule (java.sql.Date start_date, java.sql.Date end_date,String calendar_op,String p_serialnum, String m_id) {
		try {
			connection();

			String sql = "insert INTO schedule (s_sq,start_date,end_date,s_option,p_serialnum,m_id) VALUES (schedule_sq.nextval,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setDate(1, start_date);
			psmt.setDate(2, end_date);
			psmt.setString(3, calendar_op);
			psmt.setString(4, p_serialnum);
			psmt.setString(5, m_id);

			// 5. SQL문 명령 후 처리
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("등록실패");
			e.printStackTrace();
		} finally {
			close();
		}
	}//inSchedule 메서드 끝
		
	
	
	
		
}
	
	
	

