package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

public class CalendarDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	

	int cnt = 0;
	boolean check = false;
	
	public void connection() {
		//1. ����̹� �����ε�
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String dbid = "campus_a_3_1025";
		String dbpw = "smhrd3";
		
		
		//2.�����ͺ��̽� ���� ��ü(Connection) ����
		conn = DriverManager.getConnection(url,dbid,dbpw);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�������");
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
	

	
	public String getP_serialnum() {
		try {
			connection();

			String sql = "select p_serialnum from phistory where m_id =? and  ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, s_date);
			psmt.setString(2, calendar_op);
			psmt.setString(3, p_serialnum);
			psmt.setString(4, m_id);

			// 5. SQL�� ��� �� ó��
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("��Ͻ���");
			e.printStackTrace();
		} finally {
			close();
		}
	}//getP_serialnum �޼��� ��	
	
	
	

	public void inSchedule (String s_date,String calendar_op, String m_id) {
		try {
			connection();

			String sql = "insert into schedule values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, s_date);
			psmt.setString(2, calendar_op);
			//psmt.setString(3, p_serialnum);
			psmt.setString(4, m_id);

			// 5. SQL�� ��� �� ó��
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("��Ͻ���");
			e.printStackTrace();
		} finally {
			close();
		}
	}//inSchedule �޼��� ��
		
	
	
	
		
}
	
	
	

