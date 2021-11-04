package com.ArdCon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ArdModel.SensorDAO;
import com.ArdModel.SensorVO;
import com.google.gson.Gson;

@WebServlet("/inSt")
public class inSt extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      PrintWriter out = response.getWriter();
      
      SensorDAO dao = new SensorDAO();
      
      
      String p_serialnum = "";

      
      String sleep_time =request.getParameter("data");
      p_serialnum= request.getParameter("p_serialnum");
      
      if(sleep_time == null) {
         sleep_time = "";
      }
      
      if(sleep_time.equals("on")) {
         //아두이노한테 취침시간 (버튼 눌렸을 때) 받아오는 서블릿.
         LocalTime now = LocalTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
         // 포맷 적용하기
         String formatedNow = now.format(formatter);
         
         System.out.println("값이 들어옴");
         System.out.println("서버로 들어온 값 : " + sleep_time);
         System.out.println("DB에 넣을 시간"  + formatedNow);
         
         ////이부분을 바꿔야함 SensorDAO에서. 아직 안 만듦.
         
         int cnt = dao.inSt(formatedNow, p_serialnum);
         
         if(cnt>0) {
            System.out.println("sleep_time insert 성공!");
         }else {
            System.out.println("sleep_time insert 실패!");
         }
         
      } else {
         System.out.println("inSt값 null");
      
      }
         
      
   }

}