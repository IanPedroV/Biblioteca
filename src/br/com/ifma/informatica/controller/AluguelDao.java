package br.com.ifma.informatica.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifma.informatica.model.AluguelDeLivro;
import br.com.ifma.informatica.model.Bibliotecario;
import br.com.ifma.informatica.model.Editora;

public class AluguelDao {

	/*
	 * 
	 CREATE TABLE `aluguel` (
  `id` int(11) NOT NULL,
  `idlivro` int(11) DEFAULT NULL,
  `idbibliotecario` int(11) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  `dataaluguel` varchar(45) DEFAULT NULL,
  `datadevolucao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idlivro_idx` (`idlivro`),
  KEY `fk_idusuario_idx` (`idusuario`),
  KEY `fk_idbibliotecario` (`idbibliotecario`),
  CONSTRAINT `fk_idlivro` FOREIGN KEY (`idlivro`) REFERENCES `livro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idbibliotecario` FOREIGN KEY (`idbibliotecario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

	 * 
	 */

	public static void criarAluguel(AluguelDeLivro aluguelDeLivro) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("INSERT INTO aluguel (id, idlivro, idusuario, idbibliotecario, dataaluguel, datadevolucao) VALUES ('"
					+ aluguelDeLivro.getId() + "', '" + aluguelDeLivro.getLivro().getId() + "', '"
					+ aluguelDeLivro.getBibliotecario().getId() + "', '" + aluguelDeLivro.getUsuario().getId() + "', '"
					+ aluguelDeLivro.getHoraDoAluguel() + "', '" + aluguelDeLivro.getHoraDeDevolucao() + "');");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Registro Realizado.");
	}

	public static List<AluguelDeLivro> readAluguel() throws SQLException {
		List<AluguelDeLivro> alugueisDeLivros = new ArrayList<AluguelDeLivro>();
		try {
			Connection con = Dao.getConnection();
			String sql = ("SELECT * FROM aluguel order by id");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			AluguelDeLivro aluguelDeLivros = null;
			while (rs.next()) {
				aluguelDeLivros = new AluguelDeLivro();
				String idLivro = rs.getString("idLivro");
				String idBibliotecario = rs.getString("idBibliotecario");
				String idUsuario = rs.getString("idUsuario");
				aluguelDeLivros.setId(Long.valueOf(rs.getString("id")));
				aluguelDeLivros.setLivro(LivroDao.readLivro(Integer.valueOf(idLivro)));
				aluguelDeLivros.setBibliotecario(UsuarioDao.readBibliotecario(Integer.valueOf(idBibliotecario)));
				aluguelDeLivros.setUsuario(UsuarioDao.readUsuarioComum(Integer.valueOf(idUsuario)));
				aluguelDeLivros.setHoraDoAluguel(rs.getString("dataaluguel"));
				aluguelDeLivros.setHoraDeDevolucao(rs.getString("datadevolucao"));
				alugueisDeLivros.add(aluguelDeLivros);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return alugueisDeLivros;
	}

/*	public static Editora readEditora(int id) throws SQLException {
		for (Editora editora : readEditora()) {
			if (editora.getId() == id) {
				return editora;

			}
		}
		return null;
	}*/

	public static void updateAluguel(String valorAtual, String valorNovo, String atributo) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("UPDATE aluguel SET " + atributo + " = '" + valorNovo + "' WHERE " + atributo + " = '"
					+ valorAtual + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAluguel(String nomeDoAluguel) throws SQLException {
		try {
			Connection con = Dao.getConnection();
			String sql = ("DELETE FROM aluguel WHERE NOME = '" + nomeDoAluguel + "';");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
