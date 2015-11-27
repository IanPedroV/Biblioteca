package br.com.ifma.informatica.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {

	private Long ID;
	private String Nome;
	private List<Livro> livros = new ArrayList <Livro>();
	
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public Long getID() {
		return ID;
	}
	public void setId(long id) {
		this.ID = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	

}
