package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberVO;
import com.model.ProductDAO;
import com.model.ProductVO;

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		String p_location = request.getParameter("p_location");
		ProductVO detail = (ProductVO)session.getAttribute("PVO");
		String detail_location = request.getParameter("p_locationdetail");
		String p_serialnum = detail.getP_serialnum();
		System.out.println(p_location);
		System.out.println(p_serialnum);
		ProductDAO dao = new ProductDAO();
		int cnt = dao.UpdateProduct(p_location, detail_location, p_serialnum);
		
		
			if(cnt > 0) {
				System.out.println("추가성공");
				response.sendRedirect("Anzzi/SelectAnzzi.jsp");
				
			}else {
				System.out.println("추가실패");
				response.sendRedirect("Anzzi/SelectAnzzi.jsp");
				
			}
			
		
	}

}