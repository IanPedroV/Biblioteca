package br.com.ifma.informatica.model;

public class AluguelDeLivro {

	private Long id;
	private Livro livro;
	private Bibliotecario bibliotecario;
	private UsuarioComum usuario;
	private String horaDoAluguel;
	private String horaDeDevolucao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}


	public void setUsuario(UsuarioComum usuario) {
		this.usuario = usuario;
	}

	public UsuarioComum getUsuario() {
		return usuario;
	}

	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}

	public String getHoraDoAluguel() {
		return horaDoAluguel;
	}

	public void setHoraDoAluguel(String horaDoAluguel) {
		this.horaDoAluguel = horaDoAluguel;
	}

	public String getHoraDeDevolucao() {
		return horaDeDevolucao;
	}

	public void setHoraDeDevolucao(String horaDeDevolucao) {
		this.horaDeDevolucao = horaDeDevolucao;
	}

}
