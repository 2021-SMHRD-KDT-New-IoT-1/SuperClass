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

@WebServlet("/InputSensor")
public class InputSensor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//�����Ӱ��������� �Ƶ��̳����� �޾ƿ��� ����
		
		int moveSensor = 999;
		moveSensor = Integer.parseInt(request.getParameter("moveSensor"));
		
		if(moveSensor != 999 ) {
			System.out.println("���� ����");
			System.out.println("������ ���� �� : " + moveSensor);
			SensorDAO dao = new SensorDAO();
			SensorVO vo = dao.insert(moveSensor);
			PrintWriter out = response.getWriter();
			String result = new Gson().toJson(vo);
			out.print(result);
		} else {
			System.out.println("null");
		}
		
		
		
		
	}

}
