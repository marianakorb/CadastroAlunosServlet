<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Aluno</title>
</head>
<body>

<% Aluno aluno = (Aluno) request.getAttribute("aluno"); %>


<h2>Alterar Aluno:</h2>

<form action="ConfirmarAlteracaoServlet" method="post">

<input type="hidden" name="nomeAntigo" value="<%=aluno.getNome() %>">

Nome:
<input type="text" name="nome" value="<%=aluno.getNome() %>">
<br><br>

Idade:
<input type="number" name="idade" value="<%=aluno.getIdade() %>">
<br><br>

Semestre:
<select name="semestre">
	<option value="Primeiro" <%=aluno.getSemestre().equals("Primeiro")  ? "selected"  :  ""%>>Primeiro</option>   
	<option value="Segundo" <%=aluno.getSemestre().equals("Segundo")  ? "selected"  :  ""%>>Segundo</option>   
</select>
<br><br>


Genero:
<!--  Realizar a operação de selecionar corretamente o genero do Aluno 
	  Dica: ternario com a opção checked
-->

	<label for="genero">Genero: </label><br>
	<input type="radio" name="genero" value="Masculino" <%=aluno.getGenero().equals("Masculino") ? "checked" : "" %>>
	<label for="genero">Masculino </label>
	
	<br>
	<input type="radio" name="genero" value="Feminino" <%=aluno.getGenero().equals("Feminino") ? "checked" : "" %>>
	<label for="genero">Feminino</label>
	<br><br>

<input type="submit" value="Confirmar Alteração">
<a href="listarAlunos.jsp">Voltar</a>
</form>





</body>
</html>