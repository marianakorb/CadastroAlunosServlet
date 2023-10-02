<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Aluno</title>
</head>
<body>
<h1>Cadastro Aluno</h1>

<form action="ConfirmarCadastroServlet" method="post">
	<label for="nome">Nome: </label>
	<input type="text" name="nome" required>
	<br><br>
	<label for="usuario">Idade: </label>
	<input type="text" name="idade" required>
	<br><br>
	
	<select name="semestre">
		<option value="primeiro">Primeiro</option>
		<option value="segundo">Segundo</option>
		<option value="terceiro">Terceiro</option>
		<option value="quarto">Quarto</option>
	</select>
	<br><br>
	
	<label for="genero">Genero: </label><br>
	<input type="radio" name="genero" value="Masculino">
	<label for="genero">Masculino </label>
	
	<br>
	<input type="radio" name="genero" value="Feminino">
	<label for="genero">Feminino</label>
	
	<br><br>
	<input type="submit" value="Confirmar Cadastro">
	<a href="listarAlunos.jsp">Voltar</a>
</form>

</body>
</html>