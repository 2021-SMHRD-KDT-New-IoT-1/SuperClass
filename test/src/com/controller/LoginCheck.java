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
import com.model.ProductDAO;
import com.model.ProductVO;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		
			
			vo = dao.login(m_id, m_pw);
			if(vo != null) {
				
				HttpSession session = request.getSession();
				
				session.setAttribute("member", vo);
				
				ProductDAO Pdao = new ProductDAO();
				
				ProductVO Pvo = Pdao.getLoginSerialnum(vo.getId());
				//회원이 가지고 있는 첫번째 제품의 시리얼번호를 불러와서 세션에 담기
				session.setAttribute("PVO", Pvo);
				
				response.sendRedirect("Anzzi/Main.jsp");
			}else {
				response.sendRedirect("Anzzi/Main.jsp");
			}
	}
}
		
	

