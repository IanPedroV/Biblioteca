package br.com.ifma.informatica.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifma.informatica.controller.AutorDao;
import br.com.ifma.informatica.controller.EditoraDao;
import br.com.ifma.informatica.controller.LivroDao;
import br.com.ifma.informatica.model.Autor;
import br.com.ifma.informatica.model.Editora;
import br.com.ifma.informatica.model.Livro;
import br.com.ifma.informatica.view.EditoraSwing;
import br.com.ifma.informatica.view.MenuPrincipalSwing;

public class AppBiblioteca {

	static void imprimirEditora() throws SQLException {
		for (Editora editora : EditoraDao.readEditora()) {
			System.out.println("Informacoes da Editora: Nome " + editora.getNome() + "| Endereco "
					+ editora.getEndereco() + "| Telefone " + editora.getTelefone());
		}
	}

//	static void imprimirLivro() throws SQLException {
//		for (Livro livro : LivroDao.readLivro()) {
//			System.out.println("Informacoes do Livro: Nome " + livro.getNome() + "| Autor: " + livro.getAutor()
//					+ "| Editora: " + livro.getEditora().getNome());
//		}
//	}

	public static void main(String[] args) throws SQLException {
		// Editora editora = EditoraDao.readEditora(1);
		List<Autor> autores = AutorDao.readAutor();
		// EditoraDao.criaEditora("Leitura", "Shopping da Ilha", "99 99999999");
		// LivroDao.criarLivro("Nunca desista dos seus sonhos", autores,
		// editora);
		// LivroDao.readLivro();
		// EditoraDao.readEditora();
		// MenuPrincipalSwing.createTela(true);
		Livro livro = new Livro();
		livro.setId(1L);
		livro.setNome("The Magic of Reality");
		livro.setEditora(EditoraDao.readEditora(1));
		livro.setAutores(autores);
		LivroDao.criarLivro(livro);
		
//		Editora editora = new Editora();
//		editora.setId(1);
//		editora.setNome("Editora Abril");
//		editora.setEndereco("Esquina Paquistao com Avenida Ribamar");
//		editora.setTelefone("99 99999999");
//		EditoraDao.criaEditora(editora);
	}

}
