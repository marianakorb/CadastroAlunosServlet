package com.jp.senac.controller;

import java.io.IOException;
import java.util.List;

import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		//recuperar a minha sessão
		
		HttpSession session = request.getSession();
		
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos");
		
		//recuperando o aluno que tem o nome informado (e que deve ser alterado)
		Aluno aluno = null;
		for (Aluno a : listaAlunos) {
			if(a.getId() == id)  {
				aluno = a;
			}
			
		}
		
		request.setAttribute("aluno", aluno);
		request.getRequestDispatcher("alterarAluno.jsp").forward(request, response);
	}

	

}
