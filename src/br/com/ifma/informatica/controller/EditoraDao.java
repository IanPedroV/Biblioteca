package br.com.ifma.informatica.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifma.informatica.model.Editora;

public class EditoraDao {

	public static void criaEditora(String nome, String endereco, String telefone) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			Editora editora = new Editora();
			editora.setNome(nome);
			editora.setEndereco(endereco);
			editora.setTelefone(telefone);
			String sql = ("INSERT INTO `editora` (`NOME`, `ENDERECO`, `TELEFONE`) VALUES ('" + editora.getNome()
					+ "', '" + editora.getEndereco() + "', '" + editora.getTelefone() + "');");
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
			String sql = ("SELECT * FROM `editora` ORDER BY NOME");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Editora editora;
			while (rs.next()) {
				editora = new Editora();
				editora.setId(rs.getInt("ID"));
				editora.setNome(rs.getString("NOME"));
				editora.setEndereco(rs.getString("ENDERECO"));
				editora.setTelefone(rs.getString("TELEFONE"));
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
			String sql = ("DELETE FROM `editora` WHERE NOME = '" + nomeDaEditora + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
