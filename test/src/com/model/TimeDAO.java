package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeDAO {
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


   public int inTime (String p_serialnum, String wake_time, String dayof,String fade_in, String sound, String weather_sound, String schedule, String pattern ) {
      try {
         connection();
         String sql = "UPDATE Time SET wake_time=?, dayof=?, fade_in=?, sound=?, weather_sound=?, schedule=?, pattern=? WHERE p_serialnum =?";
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, wake_time);
         psmt.setString(2, dayof);
         psmt.setString(3, fade_in);
         psmt.setString(4, sound);
         psmt.setString(5, weather_sound);
         psmt.setString(6, schedule);
         psmt.setString(7, pattern);
         psmt.setString(8, p_serialnum);

         // 5. SQL�� ��� �� ó��
         cnt = psmt.executeUpdate();

      } catch (Exception e) {
         System.out.println("��Ͻ���");
         e.printStackTrace();
      } finally {
         close();
      }
      return cnt;
   }//
   
      
   
}