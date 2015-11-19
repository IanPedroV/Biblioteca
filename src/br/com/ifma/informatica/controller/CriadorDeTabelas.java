package br.com.ifma.informatica.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriadorDeTabelas {

	public static void checkTabelaEditora() throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("CREATE TABLE `biblioteca`.`editora` (`ID` INT UNSIGNED NOT NULL AUTO_INCREMENT"
					+ " COMMENT '',`NOME` VARCHAR(45) NOT NULL COMMENT '',`ENDERECO` VARCHAR(45)"
					+ " NULL COMMENT '',`TELEFONE` VARCHAR(45) NULL COMMENT '',PRIMARY KEY (`ID`)"
					+ "  COMMENT '')ENGINE=InnoDB DEFAULT"
					+ " CHARSET=UTF8 "+ "AUTO_INCREMENT=1 ;");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void checkTabelaPessoaComum() throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("CREATE TABLE IF NOT EXISTS `PessoaComum` (`ID` int NOT NULL AUTO_INCREMENT, `NOME` "
					+ "varchar(50) NOT NULL, `IDADE` int(3) NOT NULL,`ENDERECO` varchar(200) NOT NULL, `CPF` "
					+ "varchar(15) NOT NULL, PRIMARY KEY (`ID`)) ENGINE=InnoDB DEFAULT CHARSET=UTF8 "
					+ "AUTO_INCREMENT=1 ;");
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		checkTabelaEditora();
	}

}
