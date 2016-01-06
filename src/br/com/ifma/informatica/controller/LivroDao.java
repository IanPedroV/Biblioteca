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
	
	/*
	 * 
	 * Sintaxe SQL de criação da tabela:
   CREATE TABLE `livro` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `ideditora` int(11) DEFAULT NULL,
  `idautor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ideditora_idx` (`ideditora`),
  KEY `idautor_idx` (`idautor`),
  CONSTRAINT `ideditora` FOREIGN KEY (`ideditora`) REFERENCES `editora` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idautor` FOREIGN KEY (`idautor`) REFERENCES `livro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	 */
	
	public static void criarLivro(Livro livro) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("INSERT INTO livro (ID, NOME, IDEDITORA) VALUES ('" + livro.getId() + "', '" + livro.getNome()
					 + "', '" + livro.getEditora().getId() + "');");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Autor autor : livro.getAutores()) {
			AutorDao.updateAutor(autor.getID(), "idlivro", String.valueOf(livro.getId()));
		}
		System.out.println("Registro Realizado.");
	}

	public static List<Livro> readLivro() throws SQLException {
		List<Livro> lista1 = new ArrayList<Livro>();
		try {
			Connection con = Dao.getConnection();
			String sql = ("SELECT * from livro order by id");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Livro livro;
			while (rs.next()) {
				livro = new Livro();
				livro.setId(Long.parseLong(rs.getString("id")));
				livro.setNome(rs.getString("nome"));
				String idEditora = rs.getString("ideditora");
				livro.setEditora(EditoraDao.readEditora(Integer.valueOf(idEditora)));
				lista1.add(livro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista1;
	}
	

	public static Livro readLivro(int id) throws SQLException {
		for (Livro livro : readLivro()) {
			if (livro.getId() == id) {
				return livro;

			}
		}
		return null;
	}

//	public static void updateLivro(String valorAtual, String valorNovo, String atributo) throws SQLException {
//		try {
//			Connection con = Dao.getConnection();
//			String sql = ("UPDATE livro SET " + atributo + " = '" + valorNovo + "' WHERE " + atributo + " = '"
//					+ valorAtual + "';");
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	// Comentado por que não foi testado.
	public static void updateLivro(Long idLivro, String parametro, String novoValor) {
		try {
				Connection con = Dao.getConnection();
				String sql = ("UPDATE livro SET " + parametro+ " = '" + novoValor + "' WHERE ID ='" + idLivro +"';");
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

//	public static void deleteLivro(String nomeDoLivro) throws SQLException {
//		try {
//			Connection con = Dao.getConnection();
//			String sql = ("DELETE FROM livro WHERE NOME = '" + nomeDoLivro + "';");
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}