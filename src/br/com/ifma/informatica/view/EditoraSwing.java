package br.com.ifma.informatica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.ifma.informatica.model.*;

public class EditoraSwing {


	public static JFrame createTelaEditora(Boolean setDeVisibilidade) {

		JFrame frameEditora = new JFrame("Cadastro de Editora");

		JPanel panel = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastrar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelId = new JLabel("Identificação: ");
		JLabel labelNome = new JLabel("Nome da Editora: ");

		JTextField textId = new JTextField(10);
		JTextField textNome = new JTextField(25);

		frameEditora.add(panel);

		frameEditora.setSize(800, 600);
		frameEditora.setVisible(setDeVisibilidade);

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
				frameEditora.dispose();
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
		
		return null;
	}

}
