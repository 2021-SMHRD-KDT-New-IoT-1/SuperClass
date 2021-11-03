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

         // 5. SQL�� ��� �� ó��
         cnt = psmt.executeUpdate();

      } catch (Exception e) {
         System.out.println("WakeUp���̺� ����");
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
	         
	        // 5. SQL�� ��� �� ó��
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
	        	System.out.println("���" + vo.getDayofs());
	         }
	         
	      } catch (Exception e) {
	         System.out.println("WakeUp ����");
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return vo;
   }
   
      
   
}