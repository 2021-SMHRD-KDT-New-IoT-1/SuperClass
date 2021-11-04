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
         //�Ƶ��̳����� ��ħ�ð� (��ư ������ ��) �޾ƿ��� ����.
         LocalTime now = LocalTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH�� mm�� ss��");
         // ���� �����ϱ�
         String formatedNow = now.format(formatter);
         
         System.out.println("���� ����");
         System.out.println("������ ���� �� : " + sleep_time);
         System.out.println("DB�� ���� �ð�"  + formatedNow);
         
         ////�̺κ��� �ٲ���� SensorDAO����. ���� �� ����.
         
         int cnt = dao.inSt(formatedNow, p_serialnum);
         
         if(cnt>0) {
            System.out.println("sleep_time insert ����!");
         }else {
            System.out.println("sleep_time insert ����!");
         }
         
      } else {
         System.out.println("inSt�� null");
      
      }
         
      
   }

}