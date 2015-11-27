package br.com.ifma.informatica.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.ifma.informatica.model.Autor;
import br.com.ifma.informatica.model.Editora;
import br.com.ifma.informatica.model.Livro;

public class AutorDao {
	/*
	 * 
  CREATE TABLE `autor` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `idlivro` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idlivro_idx` (`idlivro`),
  CONSTRAINT `idlivro` FOREIGN KEY (`idlivro`) REFERENCES `livro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	 */
	

	public static void criarAutor(Autor autor) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("INSERT INTO autor (ID, NOME) VALUES ('" + autor.getID() +"', '" +  autor.getNome() + "')");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Livro livro : autor.getLivros()) {
			LivroDao.updateLivro(autor.getID(), "idautor", String.valueOf(livro.getId()));
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
			String sql = ("SELECT * FROM autor ORDER BY NOME");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Autor autor;
			while (rs.next()) {
				autor = new Autor();
				autor.setId(rs.getInt("id"));
				autor.setNome(rs.getString("nome"));
				lista.add(autor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static Autor readAutor(int id) throws SQLException {
		String sql = ("SELECT FROM autor WHERE id = '"+ id +"';" );
		System.out.println(sql);
		for (Autor autor : readAutor()) {
			if (autor.getID() == id) {
				return autor;

			}
		}
		return null;
	}

	// public static void updateAutor(String valorAtual, String valorNovo,
	// String atributo) throws SQLException {
	// try {
	// Connection con = Dao.getConnection();
	// String sql = ("UPDATE autor SET " + atributo + " = '" + valorNovo + "'
	// WHERE " + atributo + " = '"
	// + valorAtual + "';");
	// PreparedStatement ps = con.prepareStatement(sql);
	// ps.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public static void updateAutor(Long idAutor, String parametro, String novoValor) {
		try {
			Connection con = Dao.getConnection();
			String sql = ("UPDATE autor SET " + parametro + " = " + novoValor + " WHERE  ID = " + idAutor);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
