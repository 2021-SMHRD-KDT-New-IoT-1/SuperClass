package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class TimeDAO {
   Connection conn = null;
   PreparedStatement psmt = null;
   ResultSet rs = null;
   TimeVO vo = new TimeVO();

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


   public int inWakeUp(String p_serialnum, String wake_time, String dayofs,String fade_in, String sound, String weather_sound, String schedule, String sleep_pattern ) {
	   if(wake_time==null) {
		   wake_time = "x";
	   }
	   if(dayofs==null) {
		   dayofs = "x";
	   }
	   if(fade_in==null) {
		   fade_in = "x";
	   }
	   if(sound==null) {
		   sound = "x";
	   }
	   if(weather_sound==null) {
		   weather_sound = "x";
	   }
	   if(schedule==null) {
		   schedule = "x";
	   }
	   if(sleep_pattern==null) {
		   sleep_pattern = "x";
	   }
	   
      try {
         connection();
         
         String sql = "UPDATE Wakeup SET wake_time=?, dayofs=?, fade_in=?, sound=?, weather_sound=?, schedule=?, sleep_pattern=? WHERE p_serialnum =?";
        
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, wake_time);
         psmt.setString(2, dayofs);
         psmt.setString(3, fade_in);
         psmt.setString(4, sound);
         psmt.setString(5, weather_sound);
         psmt.setString(6, schedule);
         psmt.setString(7, sleep_pattern);
         psmt.setString(8, p_serialnum);

         // 5. SQL문 명령 후 처리
         cnt = psmt.executeUpdate();

      } catch (Exception e) {
         System.out.println("WakeUp테이블 실패");
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt;
   }//
   
   public TimeVO getTime(String p_serialnum) {
	   
	   try {
	         connection();
	         
	         String sql = "select wake_time, dayofs, fade_in, sound, weather_sound, schedule, sleep_pattern from Wakeup WHERE p_serialnum =?";
	         
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, p_serialnum);
	         
	        // 5. SQL문 명령 후 처리
	          rs = psmt.executeQuery();
	         if(rs.next()) {
	        	 String wake_time = rs.getString(1);
	        	 String dayofs = rs.getString(2);
	        	 String fade_in = rs.getString(3);
	        	 String sound = rs.getString(4);
	        	 String weather_sound = rs.getString(5);
	        	 String schedule = rs.getString(6);
	        	 String sleep_pattern = rs.getString(7);
	        	 
	        	vo = new TimeVO(wake_time,dayofs,fade_in,sound,weather_sound,schedule,sleep_pattern);
	        	System.out.println("출력" + vo.getDayofs());
	         }
	         
	      } catch (Exception e) {
	         System.out.println("WakeUp 실패");
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return vo;
   }
   
   public String onOffLED(String p_serialnum) {
	   String onOff ="";
	   
	   try {
			connection();
			
			String sql = "select led_onoff from wakeup where p_serialnum = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				onOff = rs.getString(1);
			}
						
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
			
	}return onOff;
   }
   
   public String changeLED(String p_serialnum, String onOff) {
	   
	   System.out.println("업데이트 진입");
	   System.out.println("넘어온값" + onOff);
	   try {
			connection();
			if(onOff.equals("off")) {
				System.out.println("이프실행");
				String sql2 = "update wakeup set led_onoff=? where p_serialnum = ?";
				psmt= conn.prepareStatement(sql2);
				psmt.setString(1, "on");
				psmt.setString(2, p_serialnum);
				psmt.executeUpdate();	
				System.out.println("업데이트 on 변경");
				onOff="on";
			}else {
				System.out.println("엘스실행");
				String sql2 = "update wakeup set led_onoff=? where p_serialnum = ?";
				System.out.println("엘스1");
				psmt= conn.prepareStatement(sql2);
				System.out.println("엘스2");
				psmt.setString(1, "off");
				System.out.println("엘스3");
				psmt.setString(2, p_serialnum);
				System.out.println("엘스4");
				psmt.executeUpdate();
				System.out.println("엘스5");
				System.out.println("업데이트 off 변경");
				onOff="off";
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
			
	}return onOff;
   }
   
      
   
}