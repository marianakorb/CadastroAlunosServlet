package com.jp.senac.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PesquisaServlet
 */
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String valor = request.getParameter("valor");
		String tipoPesquisa = request.getParameter("tipoPesquisa");
		
		AlunoJDBCdao dao = new AlunoJDBCdao();
		ArrayList<Aluno> listaAlunos = dao.pesquisar(valor, tipoPesquisa);
		request.setAttribute(tipoPesquisa, listaAlunos);
		RequestDispatcher dispacher = request.getRequestDispatcher("listarAlunos.jsp");
		dispacher.forward(request, response);
	}

}
