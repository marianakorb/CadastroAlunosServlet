package com.jp.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jp.senac.model.Aluno;
import com.mysql.cj.protocol.Resultset;

public class AlunoJDBCdao {
	
	public Connection getConexao() throws ClassNotFoundException {
		
		// Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// Banco de Dados
		String url = "jdbc:mysql://localhost:3306/cadastroalunos?useTimezone=true&serverTimezone=UTC";
		
		// Usuario
		String user = "root";
		
		// Senha
		String password = "root";
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Conectando ao banco de dados"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return con;
		
	}
	
	public List<Aluno> listarAlunos() throws SQLException {
		
		List<Aluno> alunos = new ArrayList<>();
		String query = "SELECT * FROM alunos";
		
		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String semestre = rs.getString(4);
				String genero = rs.getString(5);
				String matricula = rs.getString(6);
				alunos.add(new Aluno(id,nome,idade,semestre,genero,matricula));
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return alunos;
	}
	
	
	public Aluno pesquisarPorID(Integer id) throws SQLException  {
		
		String query = "SELECT * FROM alunos WHERE id = ?";
		Aluno aluno = null;
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,  id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String semestre = rs.getString(4);
				String genero = rs.getString(5);
				String matricula = rs.getString(6);
				aluno = new Aluno(id,nome,idade,semestre,genero,matricula);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}
		 return aluno;
	}
	
	
	public void excluirAluno(Integer id) throws SQLException {
		
		String delete = "DELETE from alunos WHERE (id = ?)";
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1,  id);
			pst.executeUpdate();
			pst.close(); 
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public Aluno cadastrarAluno (Aluno aluno) {
		
		List<Aluno> alunos = new ArrayList<>();
		String query = "INSERT INTO alunos (nome, idade,semestre,genero,matricula) VALUES(?,?,?,?,?)";

		try {
			
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getIdade());
			pst.setString(3, aluno.getSemestre());
			pst.setString(4, aluno.getGenero());
			pst.setString(5, aluno.getMatricula());
			
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()) {
				int id = rs.getInt(1);
				aluno.setId(id);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return aluno;
	}
	
	
	
	public Aluno alterarAluno(Aluno aluno) {
		 String query = "UPDATE alunos SET nome = ?, idade= ?, semestre = ?, genero = ?, matricula = ? WHERE id = ?";
		
		 try {
				Connection con = getConexao();
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, aluno.getNome());
				pst.setString(2, aluno.getIdade());
				pst.setString(3, aluno.getSemestre());
				pst.setString(4, aluno.getGenero());
				pst.setString(5, aluno.getMatricula());
				pst.setInt(6, aluno.getId());
				
				pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return aluno;
	}
	
	
	public 	ArrayList<Aluno> pesquisar(String valor, String tipo) {
		
		ArrayList<Aluno> alunos = new ArrayList<>();
		
		String query;
		
		if(tipo.equals("matricula")) {
			query = "SELECT * FROM alunos WHERE Matricula = " + valor;
		} else {
			query = "SELECT * FROM alunos WHERE nome LIKE '% " + valor + "%'";
		}
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();	
			
			while(rs.next()) {
				int id = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			
		}
		
		return null;
	}
}



