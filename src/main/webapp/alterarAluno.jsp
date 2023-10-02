<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Aluno</title>
</head>
<body>
<%Aluno aluno = (Aluno) request.getAttribute("aluno"); %>
<h1>Alterar Aluno </h1>

<form action="ConfirmarAlteracaoServlet" method="post">
	<input type="hidden" name="id" value="<%=aluno.getId() %>">
	<input type="hidden" name="matricula" value="<%=aluno.getMatricula()%>" > <br>
	Matricula: <p><%=aluno.getMatricula() %></p>
	
	Nome: 
	<input type="text" name="nome" value="<%=aluno.getNome() %>">
	<br><br>
	Idade: 
	<input type="number" name="idade" value="<%=aluno.getIdade() %>">
	Semestre
	<select name="semestre">
		<option value="primeiro" <%=aluno.getSemestre().equals("primeiro") ? "selected" : "" %>>Primeiro</option> 
		<option value="segundo" <%=aluno.getSemestre().equals("segundo")? "selected" : "" %>>Segundo</option>
		<option value="terceiro" <%=aluno.getSemestre().equals("terceiro") ? "selected" : "" %>>Terceiro</option> 
		<option value="quarto" <%=aluno.getSemestre().equals("quarto")? "selected" : "" %>>Quarto</option>
	</select>
	<br><br>

	<!--Genero: realizar a operação de selecionar corretamente o genero do aluno
		Dica: ternario com a opção checked -->
	
	<label for="genero">Genero: </label><br>
	<input type="radio" name="genero" value="Masculino" <%=aluno.getGenero().equals("Masculino") ? "checked" : "" %>>
	<label for="genero">Masculino </label>
	
	<br>
	<input type="radio" name="genero" value="Feminino" <%=aluno.getGenero().equals("Feminino") ? "checked" : "" %>>
	<label for="genero">Feminino</label>
	<br><br>
	
	<input type="submit" value="Confirmar Cadastro">
	<a href="listarAlunos.jsp">Voltar</a>
	
</form>
</body>
</html>