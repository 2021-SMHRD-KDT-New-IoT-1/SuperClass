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
			System.out.println("SensorDAO inMoveSensor("+moveSensor+","+p+") ����");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	//ledonoff DB�� ���� (�Ƶ��̳뿡��)
	public int inLed(String ledonoff, String p) {
	try {
			connection();
			String sql1 = "UPDATE wakeup SET ledonoff = ? WHERE p_serialnum =?";
		
			psmt = conn.prepareStatement(sql1);			
			psmt.setString(1, ledonoff);
			psmt.setString(2, p);
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SensorDAO inMoveSensor("+ledonoff+","+p+") ����");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	//sleep_time (�Ƶ��̳뿡�� ��ħ��ư ������ �� db�� ����) 
	public int inSt(String st, String p) {
	try {
			connection();
			String sql1 = "UPDATE wakeup SET sleep_time = ? WHERE p_serialnum =?";
		
			psmt = conn.prepareStatement(sql1);			
			psmt.setString(1, st);
			psmt.setString(2, p);
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SensorDAO inMoveSensor("+st+","+p+") ����");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	
	
	
	
	
///////////////////////////////DB����.�ݱ�޼���///////////
	private void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����fail");}}

	private void close() {
		try {if(rs != null) {
				rs.close();}if(psmt != null) {psmt.close();}if(conn != null) {conn.close();}}
		catch (Exception e2) {e2.printStackTrace();}}

	
	
	
}
