package com.engfabiorogerio.projetojsp3.controller;

import java.io.IOException;

import com.engfabiorogerio.projetojsp3.model.DAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();

	/**
	 * Default constructor.
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String action = request.getServletPath();
			System.out.println(action);
			if(action.equals("/main")) {
				contatos(request, response);
			}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.sendRedirect("agenda.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
