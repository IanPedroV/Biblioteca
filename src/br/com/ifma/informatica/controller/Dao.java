package br.com.ifma.informatica.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ifma.informatica.model.Editora;

public class Dao {

	private static String SQL_HOST = "jdbc:mysql://localhost:3306/biblioteca";
	private static String SQL_USER = "root";
	private static String SQL_PASS = "wool";

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(SQL_HOST, SQL_USER, SQL_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Conexao aceita.");
		return connection;

	}
}