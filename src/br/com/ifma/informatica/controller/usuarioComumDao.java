package br.com.ifma.informatica.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.ifma.informatica.model.UsuarioComum;

public class usuarioComumDao {

	public static void criaUsuario(String nome, int idade, String endereco, String cpf) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			UsuarioComum pessoaComum = new UsuarioComum();
			pessoaComum.setNome(nome);
			pessoaComum.setIdade(idade);
			pessoaComum.setEndereco(endereco);
			pessoaComum.setCpf(cpf);
			String sql = ("INSERT INTO `pessoaComum` (`NOME`, `IDADE`, `ENDERECO`, `CPF`) VALUES ('"
					+ pessoaComum.getNome() + "', '" + pessoaComum.getIdade() + "', '" + pessoaComum.getEndereco()
					+ "', '" + pessoaComum.getCpf() + "');");
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		System.out.println("Registro Realizado.");	}

}
