package com.ArdModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	int cnt = 0;
	boolean check = false;	


	public int inMoveSensor(String moveSensor, String p) {		
	try {
			connection();
			String sql1 = "INSERT INTO mpattern values(sysdate, ?) where p_serialnum =?";
			
			psmt = conn.prepareStatement(sql1);			
			psmt.setString(1, moveSensor);
			psmt.setString(2, p);
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SensorDAO inMoveSensor("+moveSensor+","+p+") 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	//ledonoff DB에 저장 (아두이노에서)
	public int inLed(String ledonoff, String p) {
	try {
			connection();
			String sql1 = "UPDATE wakeup SET ledonoff = ? WHERE p_serialnum =?";
		
			psmt = conn.prepareStatement(sql1);			
			psmt.setString(1, ledonoff);
			psmt.setString(2, p);
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SensorDAO inMoveSensor("+ledonoff+","+p+") 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	//sleep_time (아두이노에서 취침버튼 눌렸을 때 db에 저장) 
	public int inSt(String st, String p) {
	try {
			connection();
			String sql1 = "UPDATE wakeup SET sleep_time = ? WHERE p_serialnum =?";
		
			psmt = conn.prepareStatement(sql1);			
			psmt.setString(1, st);
			psmt.setString(2, p);
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SensorDAO inMoveSensor("+st+","+p+") 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	
	
	
	
	
///////////////////////////////DB연결.닫기메서드///////////
	private void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결fail");}}

	private void close() {
		try {if(rs != null) {
				rs.close();}if(psmt != null) {psmt.close();}if(conn != null) {conn.close();}}
		catch (Exception e2) {e2.printStackTrace();}}

	
	
	
}
