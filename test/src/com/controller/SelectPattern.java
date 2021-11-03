package com.controller;

import java.io.IOException;
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

@WebServlet("/SelectPattern")
public class SelectPattern extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		String p_date = request.getParameter("p_date");
		HttpSession session = request.getSession();
		ProductVO pvo =(ProductVO)session.getAttribute("PVO");
		String p_serialnum = pvo.getP_serialnum();
		
		
		
		
		
		
		
		
		//select TO_CHAR(movetime, 'YYYY-MM-DD HH24:MI:SS') , movesensor from arduino
		
	}

}
