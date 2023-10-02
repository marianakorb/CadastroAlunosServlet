package com.jp.senac.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		
		int max = 0;
		
		for(Aluno aluno : listaAlunos) {
			if(aluno.getId() > max) {
				max = aluno.getId();
			}
		}
		
		
		
		// guardar no objeto aluno
		Aluno aluno = new Aluno(max+1, nome, idade, semestre, genero, criaMatricula(idade));
		
		//adicionando aluno na lista (INSERT)
		listaAlunos.add(aluno);
		
		session.setAttribute("listaAlunos", listaAlunos);
		request.setAttribute("aluno", aluno);
		
		//encaminhar  arequisição para o JSP
		request.getRequestDispatcher("detalharAluno.jsp").forward(request, response);
	}
	
	public String criaMatricula(String idade) {
		int max = 9999;
		int min = 1000;
		//Random rand = new Random();
		int aleatorio = (int) (Math.random() * (max - min + 1) + min);
		
		LocalDate dataAtual = LocalDate.now();
		int ano = dataAtual.getYear();
		System.out.println(ano);
		int mes = dataAtual.getMonthValue();
		// Assume que o semestre 1 é o janeiro a junho
		int semestreAno = (mes < 7) ? 1 : 2;
		
		String matricula = ano + "" + String.format("%02d", mes) + "" + semestreAno + idade + aleatorio;
		
		return matricula;
		
	}

}
