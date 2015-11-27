package br.com.ifma.informatica.model;

public class Bibliotecario extends Usuario {

	public static final String DISCRIMINATOR = "B";

	public Bibliotecario() {
		this.setDiscriminator(DISCRIMINATOR);
	}

	public void cadastroDeUsuarios(String nome, int cpf) {
		
	}

	@Override
	public void alugarLivros(String nome, String editora, String autor) {
	}

	public void cadastroDeLivros(String nome, String editora, String autor) {

	}
}
