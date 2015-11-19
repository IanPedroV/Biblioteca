package br.com.ifma.informatica.model;


abstract public class Usuario {

	private String nome;
	private int idade;
	private String endereco;
	private String cpf;

	abstract public void cadastroDeLivros(String nome, String editora, String autor);

	abstract public void alugarLivros(String nome, String editora, String autor);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
