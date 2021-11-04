package com.ArdCon;

import java.io.IOException;
import java.io.PrintWriter;

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
		//�Ƶ��̳����� ��ħ�ð� (��ư ������ ��) �޾ƿ��� ����.
		response.setContentType("text/plain;");
		PrintWriter out = response.getWriter();
		
		SensorDAO dao = new SensorDAO();
		
		String sleep_time = "";
		String p_serialnum = "";

		
		sleep_time =request.getParameter("data");
		p_serialnum= request.getParameter("p_serialnum");
		out.println(sleep_time);
		out.println(p_serialnum);
		
		
	
		if(sleep_time.equals("off")) {
			System.out.println("inSt.java���� ���� �� �޾� ���ų� ����");
			System.out.println("���� ����");
			System.out.println("������ ���� �� : " + sleep_time);
			
			////�̺κ��� �ٲ���� SensorDAO����. ���� �� ����.
			int cnt = dao.inSt(sleep_time, p_serialnum);
			
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
