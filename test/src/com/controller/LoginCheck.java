package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		MemberVO vo = null;
		MemberDAO dao = null;
		
		
			
			vo = dao.login(m_id, m_pw);
			if(vo != null) {
				
				HttpSession session = request.getSession();
				
				session.setAttribute("member", vo);
				
				response.sendRedirect("Anzzi/Main.jsp");
			}else {
				response.sendRedirect("Anzzi/Main.jsp");
			}
	}
}
		
	

