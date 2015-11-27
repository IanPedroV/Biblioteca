package br.com.ifma.informatica.model;

abstract public class Usuario {

	private Long id;
	private String nome;
	private int idade;
	private String endereco;
	private String telefone;
	private String cpf;
	private String discriminator;

	abstract public void alugarLivros(String nome, String editora, String autor);

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDiscriminator() {
		return discriminator;
	}

	protected void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
