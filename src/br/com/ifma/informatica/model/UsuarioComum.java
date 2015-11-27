package br.com.ifma.informatica.model;


public class UsuarioComum extends Usuario {
	public final String DISCRIMINATOR = "U";
	
	public UsuarioComum() {
		this.setDiscriminator(DISCRIMINATOR);
	}

	@Override
	public void alugarLivros(String nome, String editora, String autor) {
		// TODO Auto-generated method stub
		
	}

}
