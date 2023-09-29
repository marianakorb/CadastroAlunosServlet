package com.jp.senac.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ConfirmarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperando a sessão
		HttpSession session = request.getSession();
		
		// recuperando os valores informados
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		
		// recuperando a lista da sessão, caso não exista, cria
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos");
		
		if(listaAlunos == null) {
			listaAlunos = new ArrayList<>(); // criando a lista
		}
		
		// guardar no objeto aluno
		Aluno aluno = new Aluno(nome, idade, semestre, genero);
		
		//adicionando aluno na lista (INSERT)
		listaAlunos.add(aluno);
		
		session.setAttribute("listaAlunos", listaAlunos);
		request.setAttribute("aluno", aluno);
		
		//encaminhar  arequisição para o JSP
		request.getRequestDispatcher("detalharAluno.jsp").forward(request, response);
	}

}
