package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ProductVO;
import com.model.TimeDAO;

@WebServlet("/SelectLED")
public class SelectLED extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession();
		ProductVO pvo = (ProductVO)session.getAttribute("PVO");
		TimeDAO dao = new TimeDAO();
		String p_serialnum = pvo.getP_serialnum();
		String onOff = dao.onOffLED(p_serialnum);
		PrintWriter out = response.getWriter();
		out.write(onOff);
	}

}
