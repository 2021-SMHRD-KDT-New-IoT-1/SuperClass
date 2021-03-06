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
	CalendarVO Cvo = null;
	ArrayList <CalendarVO> Cal;
	

	int cnt = 0;
	boolean check = false;
	
	public CalendarDAO() {
		Cal = new ArrayList<CalendarVO>();
	}
	
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

			String sql = "insert INTO schedule (s_sq,start_date,s_option,p_serialnum,m_id,end_date) VALUES (schedule_sq.nextval,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setDate(1, start_date);
			psmt.setString(2, calendar_op);
			psmt.setString(3, p_serialnum);
			psmt.setString(4, m_id);
			psmt.setDate(5, end_date);

			// 5. SQL문 명령 후 처리
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("등록실패");
			e.printStackTrace();
		} finally {
			close();
		}
	}//inSchedule 메서드 끝
		
	
	public ArrayList<CalendarVO> getSchedule (String p_serialnum) {
		
		try {
			connection();
			
			String sql = "Select TO_CHAR(start_date,'YYYY-MM-DD'),TO_CHAR(end_date,'YYYY-MM-DD'),s_option from schedule where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				String start_date = rs.getString(1);
			 	String end_date = rs.getString(2);
				String s_option = rs.getString(3);
				String allday = "true";
				
				Cvo = new CalendarVO(s_option,start_date,end_date,allday);
				Cal.add(Cvo);
			}
			
		} catch (Exception e) {
				System.out.println("캘린더조회실패!");
				e.printStackTrace();
				
			}finally {
				close();
			}
		return Cal;
	}//메서드끝
	
	public int delectSchedule(String p_serialnum, String start_date) {
		try {
			connection();
			
			String sql = "delete from schedule where p_serialnum = ? and start_date = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);
			psmt.setString(2, start_date);
			cnt = psmt.executeUpdate();
			
			//System.out.println(cnt);
						
		} catch (Exception e) {
			System.out.println("CalendarDAO에서 삭제실패");
			e.printStackTrace();
			
		}finally {
			close();
			}
		return cnt;
	}
		
}
	
	
	

