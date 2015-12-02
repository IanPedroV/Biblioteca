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

	public static void createTelaMenuEditora(Boolean setDeVisibilidade) {
		JFrame frameEditora = new JFrame("Menu da Editora");
		JPanel panelEditora = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastro");
		JButton botaoConsultar = new JButton("Consulta");
		JButton botaoAlterar = new JButton("Alteração");
		JButton botaoExcluir = new JButton("Exclusão");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		frameEditora.add(panelEditora);

		frameEditora.setSize(800, 600);
		frameEditora.setVisible(setDeVisibilidade);

		panelEditora.add(botaoCadastrar);
		panelEditora.add(botaoConsultar);
		panelEditora.add(botaoAlterar);
		panelEditora.add(botaoExcluir);
		panelEditora.add(botaoVoltar);
		panelEditora.add(botaoSair);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditoraSwing.createTelaCadastrarEditora(true);
				frameEditora.setVisible(false);

			}
		});

		botaoConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditoraSwing.createTelaConsultarEditora(true);
				frameEditora.setVisible(false);

			}
		});

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditoraSwing.createTelaAlterarEditora(true);
				frameEditora.setVisible(false);

			}
		});

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditoraSwing.createTelaExcluirEditora(true);
				frameEditora.setVisible(false);

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
				JOptionPane.showMessageDialog(null, "Este aplicativo ira encerrar!");
				System.exit(0);
			}
		});

	}

	public static JFrame createTelaCadastrarEditora(Boolean setDeVisibilidade) {

		JFrame frameCadastroEditora = new JFrame("Cadastro de Editora");
		JPanel panelCadastroEditora = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastrar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelId = new JLabel("Identificação: ");
		JLabel labelNome = new JLabel("Nome da Editora: ");
		JLabel labelEndereco = new JLabel("Endereco: ");
		JLabel labelTelefone = new JLabel("Telefone: ");

		JTextField textId = new JTextField(10);
		JTextField textNome = new JTextField(25);
		JTextField textEndereco = new JTextField(25);
		JTextField textTelefone = new JTextField(10);

		frameCadastroEditora.add(panelCadastroEditora);

		frameCadastroEditora.setSize(800, 600);
		frameCadastroEditora.setVisible(setDeVisibilidade);

		panelCadastroEditora.add(labelId);
		panelCadastroEditora.add(textId);
		panelCadastroEditora.add(labelNome);
		panelCadastroEditora.add(textNome);
		panelCadastroEditora.add(labelEndereco);
		panelCadastroEditora.add(textEndereco);
		panelCadastroEditora.add(labelTelefone);
		panelCadastroEditora.add(textTelefone);
		panelCadastroEditora.add(botaoCadastrar);
		panelCadastroEditora.add(botaoVoltar);
		panelCadastroEditora.add(botaoSair);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Editora cadastrada com sucesso!");
				textId.setText("");
				textNome.setText("");
				textEndereco.setText("");
				textEndereco.setText("");
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameCadastroEditora.dispose();
			}
		});

		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este aplicativo ira encerrar!");
				System.exit(0);
			}
		});

		return null;
	}
	
	public static void createTelaConsultarEditora(Boolean setDeVisibilidade) {
		JFrame frameConsultarEditora = new JFrame("Consulta de Editora");
		JPanel panelConsultarEditora = new JPanel();

		frameConsultarEditora.add(panelConsultarEditora);
		frameConsultarEditora.setSize(800, 600);
		frameConsultarEditora.setVisible(setDeVisibilidade);

		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		panelConsultarEditora.add(botaoVoltar);
		panelConsultarEditora.add(botaoSair);

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameConsultarEditora.dispose();
			}
		});

		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este aplicativo ira encerrar!");
				System.exit(0);
			}
		});

	}
	
	public static void createTelaAlterarEditora(Boolean setDeVisibilidade) {
		JFrame frameAlterarEditora = new JFrame("Alterar Editora");
		JPanel panelAlterarEditora = new JPanel();

		JButton botaoAlterar = new JButton("Alterar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelAtributo = new JLabel("Atributo a ser alterado: ");
		JLabel labelValorAtual = new JLabel("Valor Atual a ser alterado: ");
		JLabel labelValorNovo = new JLabel("Valor a ser substituído: ");

		JTextField textAtributo = new JTextField(10);
		JTextField textValorAtual = new JTextField(25);
		JTextField textValorNovo = new JTextField(25);

		frameAlterarEditora.add(panelAlterarEditora);
		frameAlterarEditora.setSize(800, 600);
		frameAlterarEditora.setVisible(setDeVisibilidade);

		panelAlterarEditora.add(labelAtributo);
		panelAlterarEditora.add(textAtributo);
		panelAlterarEditora.add(labelValorAtual);
		panelAlterarEditora.add(textValorAtual);
		panelAlterarEditora.add(labelValorNovo);
		panelAlterarEditora.add(textValorNovo);
		panelAlterarEditora.add(botaoAlterar);
		panelAlterarEditora.add(botaoVoltar);
		panelAlterarEditora.add(botaoSair);

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameAlterarEditora.dispose();
			}
		});

		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este aplicativo ira encerrar!");
				System.exit(0);
			}
		});

	}
	
	public static void createTelaExcluirEditora(Boolean setDeVisibilidade) {
		JFrame frameExcluirEditora = new JFrame("Consulta de Editora");
		JPanel panelExcluirEditora = new JPanel();

		JButton botaoExcluir = new JButton("Excluir");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JTextField textNomeDaEditora = new JTextField(10);

		JLabel labelNomeDaEditora = new JLabel("Nome da editora a ser excluida: ");

		frameExcluirEditora.add(panelExcluirEditora);
		frameExcluirEditora.setSize(800, 600);
		frameExcluirEditora.setVisible(setDeVisibilidade);

		panelExcluirEditora.add(labelNomeDaEditora);
		panelExcluirEditora.add(textNomeDaEditora);
		panelExcluirEditora.add(botaoExcluir);
		panelExcluirEditora.add(botaoVoltar);
		panelExcluirEditora.add(botaoSair);

		botaoExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Esta editora foi excluído!");
				textNomeDaEditora.setText("");
				frameExcluirEditora.dispose();
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameExcluirEditora.dispose();
			}
		});

		botaoSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este aplicativo ira encerrar!");
				System.exit(0);
			}
		});
	}
}
