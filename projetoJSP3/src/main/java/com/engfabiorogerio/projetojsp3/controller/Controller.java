package com.engfabiorogerio.projetojsp3.controller;


import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
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
			}else if(action.equals("/select")) {
				listarContato(request, response);
			}else if(action.equals("/update")) {
				editarContato(request, response);
			}else if(action.equals("/delete")) {
				removerContato(request, response);
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
	
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String idcon = request.getParameter("idcon");
		contato.setIdcon(idcon);
		dao.selecionarContato(contato);
		
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());	
		request.setAttribute("fone", contato.getFone());	
		request.setAttribute("email", contato.getEmail());	
		
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		
	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.alterarContato(contato);
		response.sendRedirect("main");
		
	}
	
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String idcon = request.getParameter("idcon");
		contato.setIdcon(idcon);
		
		dao.deletarContato(contato);
		
		response.sendRedirect("main");
		
	}
	
	
}
