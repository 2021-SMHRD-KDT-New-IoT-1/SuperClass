package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberVO;


@WebServlet("/P_serialnumSession")
public class P_serialnumSession extends HttpServlet {


	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("euc-kr");
		System.out.println("���ۼ���");
		String p_serialnum = request.getParameter("p_serialnum");
		p_serialnum = p_serialnum.substring(1);
		
		System.out.println(p_serialnum);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("p_serialnum",p_serialnum);
		
		//String se = (String)session.getAttribute("p_serialnum");
		
		
	}

}
