package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ProductDAO;
import com.model.ProductVO;

@WebServlet("/SelectAnzziDetail")
public class SelectAnzziDetail extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p_serialnum = request.getParameter("p_serialnum");
		ProductDAO dao = new ProductDAO();
		ProductVO vo = dao.SelectAnzziDetail(p_serialnum);
		HttpSession session = request.getSession();
		session.setAttribute("PVO", vo);
		if(vo != null) {
			response.sendRedirect("Anzzi/SelectAnzziDetail.jsp");
		}
		
	}

}
