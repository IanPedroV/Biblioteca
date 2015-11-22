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

	// static void imprimirLivro() throws SQLException {
	// for (Livro livro : LivroDao.readLivro()) {
	// System.out.println("Informacoes do Livro: Nome " + livro.getNome() + "|
	// Autor: " + livro.getAutor()
	// + "| Editora: " + livro.getEditora().getNome());
	// }
	// }

	public static void main(String[] args) throws SQLException {
		MenuPrincipalSwing.createTela(true);

	}

}
