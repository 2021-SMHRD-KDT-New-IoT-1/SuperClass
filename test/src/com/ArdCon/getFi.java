package com.ArdCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ArdModel.WeatherArduinoDAO;
import com.ArdModel.WeatherArduinoVO;
import com.ArdModel.fiVO;
import com.google.gson.Gson;

@WebServlet("/getFi")
public class getFi extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//�Ƶ��̳밡 ���� �޾ƿ����� �� ������ �;���. (�ٵ� �Ƶ��̳밡 ���� �ø���ѹ��� ���� ������ �;����� ���� ������ �� �� �ִ�.)
		
		WeatherArduinoDAO dao = new WeatherArduinoDAO(); 
		String p = request.getParameter("p_serialnum");
		fiVO avo = dao.getFi(p); 
		String result = new Gson().toJson(avo); 
		PrintWriter out = response.getWriter(); 
		out.print(result);
	
	}

}
