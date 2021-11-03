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
	SensorVO vo = null;
	int cnt = 0;
	boolean check = false;	

	private void connection() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";

			// 2.데이터베이스 연결 객체(Connection) 생성
			conn = DriverManager.getConnection(url, dbid, dbpw);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결fail");
		}

	}

	private void close() {
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

	public SensorVO insert(int moveSensor) {		

		connection();		

		String sql1 = "INSERT INTO ARDUINO values(sysdate, ?)";
		try {
			psmt = conn.prepareStatement(sql1);			
			psmt.setInt(1, moveSensor);
			// psmt.execute();
			
			int cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("fail");
			e.printStackTrace();
		} finally {
			close();
		}

		vo = getSensor();
		return vo;
	}

	public SensorVO getSensor() {

		SensorVO vo = null;
		connection();		


		String sql = "select * from ARDUINO";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int moveSensor = rs.getInt(2);
				vo = new SensorVO(moveSensor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

}
