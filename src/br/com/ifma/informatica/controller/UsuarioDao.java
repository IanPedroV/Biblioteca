package br.com.ifma.informatica.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifma.informatica.model.Bibliotecario;
import br.com.ifma.informatica.model.Livro;
import br.com.ifma.informatica.model.Usuario;
import br.com.ifma.informatica.model.UsuarioComum;

public class UsuarioDao {

	/*
	 * 
	 * CREATE TABLE `biblioteca`.`usuario` ( `id` INT NOT NULL, `nome`
	 * VARCHAR(45) NULL, `idade` INT NULL, `endereco` VARCHAR(45) NULL,
	 * `telefone` VARCHAR(45) NULL, `cpf` VARCHAR(45) NULL, `discriminator`
	 * VARCHAR(45) NULL, PRIMARY KEY (`id`));
	 * 
	 */

	public static void criarUsuario(Usuario usuario) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("INSERT INTO usuario (id, nome, idade, endereco, telefone, cpf, discriminator) VALUES ('"
					+ usuario.getId() + "', '" + usuario.getNome() + "', '" + usuario.getIdade() + "', '"
					+ usuario.getEndereco() + "', '" + usuario.getTelefone() + "', '" + usuario.getCpf() + "', '"
					+ usuario.getDiscriminator() + "');");
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Registro Realizado.");
	}

	public static List<UsuarioComum> readUsuarioComum() {
		List<UsuarioComum> lista = new ArrayList<UsuarioComum>();
		try {
			Connection con = Dao.getConnection();
			String sql = ("SELECT * FROM usuario WHERE discriminator = 'U';");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			UsuarioComum usuario;
			while (rs.next()) {
				usuario = new UsuarioComum();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setIdade(rs.getInt("idade"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setCpf(rs.getString("cpf"));
				lista.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static List<Bibliotecario> readBibliotecario() {
		List<Bibliotecario> lista1 = new ArrayList<Bibliotecario>();
		try {
			Connection con = Dao.getConnection();
			String sql = ("SELECT * FROM usuario WHERE discriminator = 'B';");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Bibliotecario bibliotecario;
			while (rs.next()) {
				bibliotecario = new Bibliotecario();
				bibliotecario.setId(rs.getLong("id"));
				bibliotecario.setNome(rs.getString("nome"));
				bibliotecario.setIdade(rs.getInt("idade"));
				bibliotecario.setEndereco(rs.getString("endereco"));
				bibliotecario.setTelefone(rs.getString("telefone"));
				bibliotecario.setCpf(rs.getString("cpf"));
				lista1.add(bibliotecario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista1;
	}
	
	public static UsuarioComum readUsuarioComum(int id) throws SQLException {
		for (UsuarioComum usuario : readUsuarioComum()) {
			if (usuario.getId() == id) {
				return usuario;

			}
		}
		return null;
	}
	
	public static Bibliotecario readBibliotecario(int id) throws SQLException {
		for (Bibliotecario bibliotecario : readBibliotecario()) {
			if (bibliotecario.getId() == id) {
				return bibliotecario;

			}
		}
		return null;
	}
	
	


	public static void updateUsuario(String valorAtual, String valorNovo, String atributo) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("UPDATE usuario SET " + atributo + " = '" + valorNovo + "' WHERE " + atributo + " = '"
					+ valorAtual + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteEditora(String nomeDoUsuario) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("DELETE FROM usuario WHERE NOME = '" + nomeDoUsuario + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
