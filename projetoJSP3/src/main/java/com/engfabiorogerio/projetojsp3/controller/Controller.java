package com.engfabiorogerio.projetojsp3.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.engfabiorogerio.projetojsp3.model.DAO;
import com.engfabiorogerio.projetojsp3.model.JavaBeans;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

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
			}else if(action.equals("/insert")) {
				novoContato(request, response);
			}else {
				response.sendRedirect("index.html");
			}
	}

	//Listar Contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ArrayList<JavaBeans> lista = dao.listarContatos();
			
			request.setAttribute("contatos", lista);
			RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
			rd.forward(request, response);
			
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			
			contato.setNome(request.getParameter("nome"));
			contato.setFone(request.getParameter("fone"));
			contato.setEmail(request.getParameter("email"));
			dao.inserirContato(contato);
			
			response.sendRedirect("main");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
