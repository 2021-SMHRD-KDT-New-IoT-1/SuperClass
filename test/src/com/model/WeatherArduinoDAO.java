package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeatherArduinoDAO {

	WeatherArduinoVO vo = null;
	MoveSensorVO mvo = null;
	GetSoundVO svo = null;
	FadeInVO fvo = null;

	

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
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
	
////////////////wakeup ���̺��� �÷��� ���� ������ �޼���(m_id�� �ø���ѹ� ����)
	public WeatherArduinoVO getWeatherInfo(String p_serialnum) {
		
		try {
			connection();
			
			String sql = "Select sleep_time, wake_time, dayofs, fade_in, sound, weather_sound, schedule, sleep_pattern from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);

			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				
				String sleep_time = rs.getString(1);
				if(sleep_time == null) {
					sleep_time = "x";
				}
			 	String wake_time = rs.getString(2);
				if(wake_time == null) {
					wake_time = "x";
				}
				String dayofs = rs.getString(3);
				if(dayofs == null) {
					dayofs = "x";
				}
				String fade_in = rs.getString(4);
				if(fade_in == null) {
					 fade_in = "x";
				}
				String sound = rs.getString(5);
				if(sound == null) {
					sound = "x";
				}
				String weather_sound = rs.getString(6);
				if(weather_sound == null) {
					weather_sound = "x";
				}
				String schedule = rs.getString(7);
				if(schedule == null) {
					schedule = "x";
				}
				String sleep_pattern = rs.getString(8);
				if(sleep_pattern == null) {
					sleep_pattern = "x";
				}
				
				vo = new WeatherArduinoVO(sleep_time, wake_time, dayofs,fade_in,sound, weather_sound,schedule,sleep_pattern);
				
			}
			
		} catch (Exception e) {
				System.out.println("WeatherArduinoDAO getWeatherInfo() ����!");
				e.printStackTrace();
				
			}finally {
				close();
			}
		return vo;
	}//�޼��峡
	
	
////////////////�����Ӱ������ sleep_pattern on���� x����
	public MoveSensorVO getMoveSensor(String p_serialnum) {
		try {
			connection();
			
			String sql = "Select sleep_pattern from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);

			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				String sleep_pattern = rs.getString(1);
				if(sleep_pattern == null) {
					sleep_pattern = "x";
				}

				mvo = new MoveSensorVO(sleep_pattern);
				
			}
			
		} catch (Exception e) {
				System.out.println("WeatherArduinoDAO���� getMoveSensor() ����!");
				e.printStackTrace();
				
			}finally {
				close();
			}
		return mvo;
	}
	
////////////////sound, weather_sound, schedule sound �¿����Ұ�����
	public GetSoundVO getSound(String p_serialnum) {
		
		try {
			connection();
			
			String sql = "Select sound, weather_sound, schedule from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);

			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
			
				String sound = rs.getString(1);
				if(sound == null) {
					sound = "x";
				}
				
				String weather_sound = rs.getString(2);
				if(weather_sound == null) {
					weather_sound = "x";
				}
				String schedule = rs.getString(3);
				if(schedule == null) {
					schedule = "x";
				}

				
				svo = new GetSoundVO(sound, weather_sound, schedule);
				
			}
			
		} catch (Exception e) {
				System.out.println("WeatherArduinoDAO getSound() ����!");
				e.printStackTrace();
				
			}finally {
				close();
			}
		return svo;
	}
	
	
	
}
