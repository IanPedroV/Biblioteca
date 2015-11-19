package br.com.ifma.informatica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.ifma.informatica.model.Editora;
import br.com.ifma.informatica.model.Usuario;
import br.com.ifma.informatica.model.UsuarioComum;

public class LivroSwing {

	
	public static void createTelaLivro(Boolean setDeVisibilidade) {
		JFrame frameLivro = new JFrame("Cadastro de livro");


		JPanel panel = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastrar");
		JButton botaoVoltar = new JButton("voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelId = new JLabel("Identificação: ");
		JLabel labelNome = new JLabel("Nome da Editora: ");

		JTextField textId = new JTextField(10);
		JTextField textNome = new JTextField(25);

		frameLivro.add(panel);

		frameLivro.setSize(800, 600);
		frameLivro.setVisible(setDeVisibilidade);

		panel.add(labelId);
		panel.add(textId);
		panel.add(labelNome);
		panel.add(textNome);
		panel.add(botaoCadastrar);
		panel.add(botaoVoltar);
		panel.add(botaoSair);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario user = new UsuarioComum();
				user.setNome(textNome.getText());
				JOptionPane.showMessageDialog(null,
						"Editora cadastrada com sucesso!");

				textId.setText("");
				textNome.setText("");
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameLivro.dispose();
			}
		});

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