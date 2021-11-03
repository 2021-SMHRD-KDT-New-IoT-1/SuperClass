package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.ProductVO;
import com.model.TimeDAO;

/**
 * Servlet implementation class onOffLED
 */
@WebServlet("/onOffLED")
public class onOffLED extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		ProductVO pvo = (ProductVO)session.getAttribute("PVO");
		TimeDAO dao = new TimeDAO();
		String p_serialnum = pvo.getP_serialnum();
		String onOff = dao.onOffLED(p_serialnum);
		System.out.println("셀렉트 완료" + onOff);
		String check = dao.changeLED(p_serialnum,onOff);
		System.out.println("업데이트 완료");
		PrintWriter out = response.getWriter();
		out.write(check);	
		
		
	}

}
