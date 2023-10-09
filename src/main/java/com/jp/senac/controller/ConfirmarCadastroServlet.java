package com.jp.senac.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ConfirmarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// recuperando os valores informados
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		
		Aluno aluno = new Aluno(nome, idade, semestre, genero, criaMatricula(idade));
		AlunoJDBCdao dao = new AlunoJDBCdao();
		Aluno alunoCadastrado = dao.cadastrarAluno(aluno);
		
		request.setAttribute("aluno", alunoCadastrado);
		
		//encaminhar  a requisição para o JSP
		request.getRequestDispatcher("detalharAluno.jsp").forward(request, response);
	}
	
	public String criaMatricula(String idade) {
		int max = 9999;
		int min = 1000;
		//Random rand = new Random();
		int aleatorio = (int) (Math.random() * (max - min + 1) + min);
		
		LocalDate dataAtual = LocalDate.now();
		int ano = dataAtual.getYear();
		int mes = dataAtual.getMonthValue();
		// Assume que o semestre 1 é o janeiro a junho
		int semestreAno = (mes < 7) ? 1 : 2;
		
		String matricula = ano + "" + String.format("%02d", mes) + "" + semestreAno + idade + aleatorio;
		
		return matricula;
		
	}

}
