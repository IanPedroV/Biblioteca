package br.com.ifma.informatica.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.ifma.informatica.model.Autor;
import br.com.ifma.informatica.model.Editora;

public class AutorDao {

	public static void criarAutor(String nome) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			Autor autor = new Autor();
			autor.setNome(nome);
			String sql = ("INSERT INTO AUTOR (NOME) VALUES ('" + autor.getNome() + "')");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registro Realizado.");
	}

	public static void deleteAutor(String nomeDoAutor) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("DELETE FROM autor WHERE NOME = '" + nomeDoAutor + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Autor> readAutor() throws SQLException {
		List<Autor> lista = new ArrayList<Autor>();
		try {
			Connection con = Dao.getConnection();
			String sql = ("SELECT * FROM `autor` ORDER BY NOME");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Autor autor;
			while (rs.next()) {
				autor = new Autor();
				autor.setId(rs.getInt("ID"));
				autor.setNome(rs.getString("NOME"));
				lista.add(autor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static Autor readAutor(int id) throws SQLException {
		for (Autor autor : readAutor()) {
			if (autor.getID() == id) {
				return autor;
			}
		}
		return null;
	}

	public static void updateAutor(String valorAtual, String valorNovo, String atributo) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("UPDATE autor SET " + atributo + " = '" + valorNovo + "' WHERE " + atributo + " = '"
					+ valorAtual + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
