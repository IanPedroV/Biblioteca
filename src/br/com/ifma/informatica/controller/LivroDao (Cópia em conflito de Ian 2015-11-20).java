package br.com.ifma.informatica.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifma.informatica.model.Autor;
import br.com.ifma.informatica.model.Editora;
import br.com.ifma.informatica.model.Livro;

public class LivroDao {

	public static void criarLivro(String nome, List <Autor> Autores, Editora editora) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			Livro livro = new Livro();
			livro.setNome(nome);
			livro.setEditora(editora);
			String sql = ("INSERT INTO livro (NOME, IDAUTOR, IDEDITORA) VALUES ('" + livro.getNome() + "', '"
					+ Autores + "', '" + editora.getId() + "');");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registro Realizado.");
	}

	public static List<Livro> readLivro() throws SQLException {
		List<Livro> lista1 = new ArrayList<Livro>();
		try {
			Connection con = Dao.getConnection();
			String sql = ("SELECT * FROM `livro` ORDER BY NOME");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Livro livro;
			while (rs.next()) {
				livro = new Livro();
				livro.setNome(rs.getString("NOME"));
				livro.setAutor(rs.getString("AUTOR"));
				String idEditora = rs.getString("IDEDITORA");
				livro.setEditora(EditoraDao.readEditora(Integer.valueOf(idEditora)));
				lista1.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista1;
	}


	public static void updateLivro(String valorAtual, String valorNovo, String atributo) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("UPDATE livro SET " + atributo + " = '" + valorNovo + "' WHERE " + atributo + " = '"
					+ valorAtual + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteLivro(String nomeDoLivro) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("DELETE FROM livro WHERE NOME = '" + nomeDoLivro + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}