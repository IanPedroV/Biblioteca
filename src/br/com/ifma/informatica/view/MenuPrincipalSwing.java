package br.com.ifma.informatica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPrincipalSwing {

	public static void createTela(Boolean setDeVisibilidade) {

		JFrame frameMenu = new JFrame("Menu Principal");
		JPanel panel = new JPanel();
		JButton botaoMenuLivro = new JButton("Menu de Livro");
		JButton botaoMenuEditora = new JButton("Menu de Editora");
		JButton botaoMenuAutor = new JButton("Menu de Autor");
		JButton botaoMenuUsuario = new JButton("Menu de Usuario");
		JButton botaoSair = new JButton("Sair");

		frameMenu.add(panel);

		frameMenu.setSize(800, 600);
		frameMenu.setVisible(setDeVisibilidade);
		panel.add(botaoMenuLivro);
		panel.add(botaoMenuEditora);
		panel.add(botaoMenuAutor);
		panel.add(botaoMenuUsuario);
		panel.add(botaoSair);

		// Direciona para o menu de Editora
		botaoMenuEditora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditoraSwing.createTelaMenuEditora(true);
				frameMenu.setVisible(false);
				frameMenu.dispose();
			}
		});

		// Direciona para o menu de Livro
		botaoMenuLivro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LivroSwing.createTelaMenuLivro(true);
				frameMenu.setVisible(false);

			}
		});

		botaoMenuAutor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AutorSwing.createTelaMenuAutor(true);
				frameMenu.setVisible(false);
			}
		});

		// Direciona para o menu de usuarioComum
		botaoMenuEditora.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//EditoraSwing.createTelaEditora(true);
				frameMenu.setVisible(false);
			}
		});

		// Sai do sistema
		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este aplicativo ira encerrar!");
				System.exit(0);
			}
		});
	}

}
