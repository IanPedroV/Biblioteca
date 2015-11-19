package br.com.ifma.informatica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuPrincipalSwing {
		

	public static void createTela(Boolean setDeVisibilidade) {

		JFrame frameMenu = new JFrame("Cadastro de Editora");

		JPanel panel = new JPanel();

		JButton botaoCadastrar1 = new JButton("Cadastro de livros");
		JButton botaoCadastrar2 = new JButton("Cadastro de editoras");
		JButton botaoSair = new JButton("Sair");

		frameMenu.add(panel);

		frameMenu.setSize(800, 600);
		frameMenu.setVisible(setDeVisibilidade);

		panel.add(botaoCadastrar2);
		panel.add(botaoCadastrar1);
		panel.add(botaoSair);

		// Direciona para o cadastro de editora
		botaoCadastrar1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LivroSwing.createTelaLivro(true);
				frameMenu.setVisible(false);

			}
		});

		// Direciona para o cadastro de livro
		botaoCadastrar2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditoraSwing.createTelaEditora(true);
				frameMenu.setVisible(false);
			}
		});

		// Sair
		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Este aplicativo irá encerrar!");
				System.exit(0);
			}
		});
	}

}
