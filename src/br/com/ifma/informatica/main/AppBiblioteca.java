package br.com.ifma.informatica.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifma.informatica.controller.AluguelDao;
import br.com.ifma.informatica.controller.AutorDao;
import br.com.ifma.informatica.controller.EditoraDao;
import br.com.ifma.informatica.controller.LivroDao;
import br.com.ifma.informatica.controller.UsuarioDao;
import br.com.ifma.informatica.model.AluguelDeLivro;
import br.com.ifma.informatica.model.Autor;
import br.com.ifma.informatica.model.Bibliotecario;
import br.com.ifma.informatica.model.Editora;
import br.com.ifma.informatica.model.Livro;
import br.com.ifma.informatica.model.Usuario;
import br.com.ifma.informatica.model.UsuarioComum;
import br.com.ifma.informatica.view.MenuPrincipalSwing;

public class AppBiblioteca {

	static void imprimirUsuarioComum() throws SQLException {
		for (Usuario usuario : UsuarioDao.readUsuarioComum()) {
			System.out.println("Informações dos usuários comuns: ID: " + usuario.getId() + "| Nome: "
					+ usuario.getNome() + "| Idade: " + usuario.getIdade() + "| Endereço: " + usuario.getEndereco()
					+ "\n| Telefone: " + usuario.getTelefone() + "| Cpf: " + usuario.getCpf());

		}
	}

	static void imprimirBiliotecario() throws SQLException {
		for (Usuario usuario : UsuarioDao.readBibliotecario()) {
			System.out.println("Informações dos Bibliotecários: ID: " + usuario.getId() + "| Nome: " + usuario.getNome()
					+ "| Idade: " + usuario.getIdade() + "| Endereço: " + usuario.getEndereco() + "\n| Telefone: "
					+ usuario.getTelefone() + "| Cpf: " + usuario.getCpf());

		}
	}

	static void imprimirEditora() throws SQLException {
		for (Editora editora : EditoraDao.readEditora()) {
			System.out.println("Informacoes da Editora: Nome " + editora.getNome() + "| Endereco "
					+ editora.getEndereco() + "| Telefone " + editora.getTelefone());
		}
	}

	public static void main(String[] args) throws SQLException {
		MenuPrincipalSwing.createTela(true);
		// UsuarioComum usuario = new UsuarioComum();
		// usuario.setId(5L);
		// usuario.setNome("Wandson");
		// usuario.setIdade(17);
		// usuario.setEndereco("Centro");
		// usuario.setTelefone("99 9999 9999");
		// usuario.setCpf("04357368083");
		// UsuarioDao.criarUsuario(usuario);
		// imprimirUsuarioComum();

		// Editora editora = new Editora();
		// editora.setId(3L);
		// editora.setNome("Independence Editora");
		// editora.setEndereco("Shopping Iguatemi");
		// editora.setTelefone("99 9999 9999");
		// EditoraDao.criarEditora(editora);

		// Autor autor = new Autor();
		// autor.setId(1L);
		// autor.setNome("Augusto Cury");
		// AutorDao.criarAutor(autor);

		// Livro livro = new Livro();
		// Editora editora = EditoraDao.readEditora(1);
		// List<Autor> autores = new ArrayList<Autor>();
		// autores.add(AutorDao.readAutor(1));
		// livro.setId(2L);
		// livro.setNome("O código da Inteligência");
		// livro.setEditora(editora);
		// livro.setAutores(autores);
		// LivroDao.criarLivro(livro);

//		AluguelDeLivro aluguel = new AluguelDeLivro();
//		Livro livro = LivroDao.readLivro(1);
//		System.out.println("Livro: " +livro);
//		UsuarioComum usuario = UsuarioDao.readUsuarioComum(1);
//		System.out.println("Usuario: " +usuario);
//		Bibliotecario bibliotecario = UsuarioDao.readBibliotecario(2);
//		System.out.println("Bibliotecario: " +bibliotecario);
//		aluguel.setId(1L);
//		aluguel.setLivro(livro);
//		aluguel.setUsuario(usuario);
//		aluguel.setBibliotecario(bibliotecario);
//		aluguel.setHoraDoAluguel("10/15/2015");
//		aluguel.setHoraDeDevolucao("10/15/2015");
//		AluguelDao.criarAluguel(aluguel);

	}

}
