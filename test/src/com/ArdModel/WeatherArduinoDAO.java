package com.ArdModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//아두이노 DAO 여기서 다함 
public class WeatherArduinoDAO {

	WeatherArduinoVO vo = null;
	

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	int cnt = 0;
	boolean check = false;
	int result = 0;
	
	String sleep_time = null;				
	String wake_time = null;			

	
	//wakeUp테이블 아이디랑 시리얼넘버 빼고 전부 불러오는 메서드
	public WeatherArduinoVO getWakeUp(String p) {
		try {
			connection();
			String sql = "Select sleep_time, wake_time, dayofs, fade_in, sound, weather_sound, schedule, sleep_pattern, led_onoff from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String sleep_time = rs.getString(1);
			 	String wake_time = rs.getString(2);
				String dayofs = rs.getString(3);
				String fade_in = rs.getString(4);
				String sound = rs.getString(5);
				String weather_sound = rs.getString(6);
				String schedule = rs.getString(7);
				String sleep_pattern = rs.getString(8);
				String led_onoff = rs.getString(9);

				vo = new WeatherArduinoVO(sleep_time, wake_time, dayofs,fade_in,sound, weather_sound,schedule,sleep_pattern,led_onoff);
			}
		} catch (Exception e) {
				System.out.println("getWakeUp("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}//getWakeUp()메서드 끝
	

	// dayofs 컬럼 
	public dVO getD(String p) {
		dVO vo = null;
		try {
			connection();
			String sql = "Select dayofs from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String d = rs.getString(1);
				vo = new dVO(d);
			}
		} catch (Exception e) {
				System.out.println("getD("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	// fade_in 컬럼
	public fiVO getFi(String p) {
		fiVO vo = null;
		try {
			connection();
			String sql = "Select fade_in from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String fi = rs.getString(1);
				int fiM = Integer.parseInt(fi)*60;
				vo = new fiVO(fiM);
			}
		} catch (Exception e) {
				System.out.println("getFi("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	// scehdule 컬럼
	public scVO getSc(String p) {
		scVO vo = null;
		try {
			connection();
			String sql = "Select schedule from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String sc = rs.getString(1);
				vo = new scVO(sc);
			}
		} catch (Exception e) {
				System.out.println("getSc("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	// sleep_pattern 컬럼
	public spVO getSp(String p) {
		spVO vo = null;
		try {
			connection();
			String sql = "Select sleep_pattern from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String sp = rs.getString(1);
				vo = new spVO(sp);
			}
		} catch (Exception e) {
				System.out.println("getD("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	// sleep_time 컬럼
	public stVO getSt(String p) {
		stVO vo = null;
		try {
			connection();
			String sql = "Select sleep_time from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String st = rs.getString(1);
				vo = new stVO(st);
			}
		} catch (Exception e) {
				System.out.println("getSt("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	// sound 컬럼
	public sVO getS(String p) {
		sVO vo = null;
		try {
			connection();
			String sql = "Select sound from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String s = rs.getString(1);
				vo = new sVO(s);
			}
		} catch (Exception e) {
				System.out.println("getS("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	//Weather_sound 컬럼
	public wsVO getWs(String p) {
		wsVO vo = null;
		try {
			connection();
			String sql = "Select weather_sound from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String ws = rs.getString(1);
				vo = new wsVO(ws);
			}
		} catch (Exception e) {
				System.out.println("getWs("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	//Wake_time 컬럼
	public wtVO getWt(String p) {
		wtVO vo = null;
		try {
			connection();
			String sql = "Select sleep_time, wake_time from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String sleep_time = rs.getString(1);					
				String wake_time = rs.getString(1);
				int result = scound_time(sleep_time,wake_time);
				vo = new wtVO(result);
			}
			
		} catch (Exception e) {
				System.out.println("getWt("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	// led_ofoff 컬럼
	public ledVO getLed(String p) {
		ledVO vo = null;
		try {
			connection();
			
			String sql = "Select led_onoff from wakeup where p_serialnum = ?";
			
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, p);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String led = rs.getString(1);
				vo = new ledVO(led);
			}
		} catch (Exception e) {
				System.out.println("getLed("+p+") 실패!");
				e.printStackTrace();
			}finally {
				close();
			}
		return vo;
	}
	
	
	
//////////////////////////////////////////////////////////////////DB연결,닫기//////////////////////////	
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
	
	
	public int scound_time(String sleep_time,String wake_time) {
		
		int dayM = 60*24;
		String[] sleep = sleep_time.split(":");
		int sleepT = Integer.parseInt(sleep[0]) * 60 + Integer.parseInt(sleep[1]);
		System.out.println(dayM - sleepT);
		
		String[] wake = wake_time.split(":");
		System.out.println(Integer.parseInt(wake[0]) * 60 + Integer.parseInt(wake[1]));
		int wakeT = Integer.parseInt(wake[0]) * 60 + Integer.parseInt(wake[1]);
		
		return result = (sleepT + wakeT)*60;
	}
	
	
//////////////////움직임감지기능 sleep_pattern on인지 x인지
//	public MoveSensorVO getMoveSensor(String p_serialnum) {
//		try {
//			connection();
//			
//			String sql = "Select sleep_pattern from wakeup where p_serialnum = ?";
//			
//			psmt= conn.prepareStatement(sql);
//			psmt.setString(1, p_serialnum);
//
//			
//			rs = psmt.executeQuery();
//			
//			if(rs.next()) {
//				
//				String sleep_pattern = rs.getString(1);
//				if(sleep_pattern == null) {
//					sleep_pattern = "x";
//				}
//
//				mvo = new MoveSensorVO(sleep_pattern);
//				
//			}
//			
//		} catch (Exception e) {
//				System.out.println("WeatherArduinoDAO에서 getMoveSensor() 실패!");
//				e.printStackTrace();
//				
//			}finally {
//				close();
//			}
//		return mvo;
//	}
//	
//////////////////sound, weather_sound, schedule sound 온오프할것인지
//	public GetSoundVO getSound(String p_serialnum) {
//		
//		try {
//			connection();
//			
//			String sql = "Select sound, weather_sound, schedule from wakeup where p_serialnum = ?";
//			
//			psmt= conn.prepareStatement(sql);
//			psmt.setString(1, p_serialnum);
//
//			
//			rs = psmt.executeQuery();
//			
//			if(rs.next()) {
//				
//			
//				String sound = rs.getString(1);
//				if(sound == null) {
//					sound = "x";
//				}
//				
//				String weather_sound = rs.getString(2);
//				if(weather_sound == null) {
//					weather_sound = "x";
//				}
//				String schedule = rs.getString(3);
//				if(schedule == null) {
//					schedule = "x";
//				}
//
//				
//				svo = new GetSoundVO(sound, weather_sound, schedule);
//				
//			}
//			
//		} catch (Exception e) {
//				System.out.println("WeatherArduinoDAO getSound() 실패!");
//				e.printStackTrace();
//				
//			}finally {
//				close();
//			}
//		return svo;
//	}
//	
//	
//////////////////fade_in 기능 
//	
//	public FadeInVO getFadeIn(String p_serialnum) {
//		try {
//			connection();
//			
//			String sql = "Select wake_time, fade_in from wakeup where p_serialnum = ?";
//			
//			psmt= conn.prepareStatement(sql);
//			psmt.setString(1, p_serialnum);
//
//			
//			rs = psmt.executeQuery();
//			
//			if(rs.next()) {
//				
//				String wake_time = rs.getString(1);
//				if(wake_time == null) {
//					wake_time = "x";
//				}
//				String fade_in = rs.getString(1);
//				if(fade_in == null) {
//					fade_in = "x";
//				}
//
//				fvo = new FadeInVO(fade_in);
//				
//			}
//			
//		} catch (Exception e) {
//				System.out.println("WeatherArduinoDAO에서 getFadeIn() 실패!");
//				e.printStackTrace();
//				
//			}finally {
//				close();
//			}
//		return fvo;
//	}	
	
	
	
	
}
