package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeatherArduinoDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	WeatherArduinoVO vo = null;
	int cnt = 0;
	boolean check = false;

	private void connection() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1521:xe";
			String dbid = "campus_a_3_1025";
			String dbpw = "smhrd3";

			// 2.�����ͺ��̽� ���� ��ü(Connection) ����
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������");
		}

	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();

		}
	}
	
	public WeatherArduinoVO getWeatherInfo() {
		vo = null;
		connection();
		String sql = "select * from ARDUINO";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int mysensor = rs.getInt(1);
				vo = new WeatherArduinoVO(mysensor);
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