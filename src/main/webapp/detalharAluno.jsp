<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informações do Aluno</title>
</head>
<body>

<%Aluno aluno = (Aluno) request.getAttribute("aluno");%>

<% if (aluno == null ) {
	response.sendRedirect("index.jsp");
} %>
<h1>Aluno Cadastrado</h1>
<p>Nome: <%=aluno.getNome() %></p>
<p>Matricula: <%=aluno.getMatricula() %></p>
<p>Idade: <%=aluno.getIdade() %></p>
<p>Genero: <%=aluno.getGenero() %></p>
<p>Semestre: <%=aluno.getSemestre() %></p>
<br>

<input type="button" onclick="javascript:location.href='ListarServlet'" value="Confirmar">
<a href="AlterarServlet?id=<%=aluno.getId()%>">Alterar</a>
</body>
</html>