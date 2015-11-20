package br.com.ifma.informatica.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	private Long id;
	private String nome;
	private Editora editora;
	private List <Autor> autores = new ArrayList<Autor>();

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


	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List <Autor> getAutores() {
		return autores;
	}

	public void setAutores(List <Autor> autores) {
		this.autores = autores;
	}

}
