package br.com.ifma.informatica.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	private String nome;
	private String autor;
	private Editora editora;
	private List <Autor> Autores = new ArrayList<Autor>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List <Autor> getAutores() {
		return Autores;
	}

	public void setAutores(List <Autor> autores) {
		Autores = autores;
	}

}
