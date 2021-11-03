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
import com.ArdModel.ledVO;
import com.google.gson.Gson;


@WebServlet("/inLed")
public class inLed extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ƶ��̳����� led ���� ���� �޾ƿ��� ����
		SensorDAO dao = new SensorDAO();
		
		String ledonoff = "-";
		
		ledonoff =request.getParameter("ledonoff");
		
		if(!ledonoff.equals("-")) {
			System.out.println("���� ����");
			System.out.println("������ ���� �� : " + ledonoff);
			
			////�̺κ��� �ٲ���� SensorDAO����. ���� �� ����.
			int cnt = dao.inLed(ledonoff, "910-1");
			
			if(cnt>0) {
				System.out.println("ledonoff insert ����!");
			}else {
				System.out.println("ledonoff insert ����!");
			}
			
		} else {
			System.out.println("inLed.java���� ���� �� �޾� ���ų� ����");
		}
			
	
	}

}
