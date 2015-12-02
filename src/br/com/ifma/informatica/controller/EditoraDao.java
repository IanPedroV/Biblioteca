package br.com.ifma.informatica.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import br.com.ifma.informatica.model.Editora;

public class EditoraDao {
	/*
	 * 
	 * CREATE TABLE `editora` ( `id` int(11) NOT NULL, `nome` varchar(45)
	 * DEFAULT NULL, `endereco` varchar(45) DEFAULT NULL, `telefone` varchar(45)
	 * DEFAULT NULL, PRIMARY KEY (`id`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
	 * 
	 */

	public static void criarEditora(Editora editora) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("INSERT INTO editora (id, nome, endereco, telefone) VALUES ('" + editora.getId() + "', '"
					+ editora.getNome() + "', '" + editora.getEndereco() + "', '" + editora.getTelefone() + "');");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registro Realizado.");
	}

	public static List<Editora> readEditora() throws SQLException {
		List<Editora> lista = new ArrayList<Editora>();
		try {
			Connection con = Dao.getConnection();
			String sql = ("SELECT * FROM editora ORDER BY NOME");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Editora editora;
			while (rs.next()) {
				editora = new Editora();
				editora.setId(rs.getInt("id"));
				editora.setNome(rs.getString("nome"));
				editora.setEndereco(rs.getString("endereco"));
				editora.setTelefone(rs.getString("telefone"));
				lista.add(editora);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static Editora readEditora(int id) throws SQLException {
		for (Editora editora : readEditora()) {
			if (editora.getId() == id) {
				return editora;

			}
		}
		return null;
	}


	public static void updateEditora(String valorAtual, String valorNovo, String atributo) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("UPDATE editora SET " + atributo + " = '" + valorNovo + "' WHERE " + atributo + " = '"
					+ valorAtual + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteEditora(String nomeDaEditora) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("DELETE FROM editora WHERE NOME = '" + nomeDaEditora + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
