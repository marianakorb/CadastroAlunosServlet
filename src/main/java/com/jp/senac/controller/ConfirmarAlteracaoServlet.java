package com.jp.senac.controller;

import java.io.IOException;
import java.util.List;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ConfirmarAlteracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recuperando os valores informados
		int id = Integer.parseInt(request.getParameter("id"));
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String semestre = request.getParameter("semestre");
		String genero = request.getParameter("genero");		
		
		Aluno aluno = new Aluno(id, nome, idade, semestre, genero, matricula);
		AlunoJDBCdao dao = new AlunoJDBCdao();
		Aluno alunoCadastrado = dao.alterarAluno(aluno);
		System.out.println(alunoCadastrado);
		
		//dao.alterarAluno(aluno);
		
		//request.setAttribute("listaAlunos", alunoCadastrado);
		
		request.getRequestDispatcher("ListarServlet").forward(request, response);
		
		
	}

}
