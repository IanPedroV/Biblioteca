package br.com.ifma.informatica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.ifma.informatica.controller.AutorDao;
import br.com.ifma.informatica.controller.LivroDao;
import br.com.ifma.informatica.controller.UsuarioDao;
import br.com.ifma.informatica.model.Usuario;

public class UsuarioSwing {

	public static void createTelaMenuUsuario(Boolean setDeVisibilidade) {
		JFrame frameMenuUsuario = new JFrame("Menu de Usuário");
		JPanel panelMenuUsuario = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastro");
		JButton botaoConsultar = new JButton("Consulta");
		JButton botaoAlterar = new JButton("Alteração");
		JButton botaoExcluir = new JButton("Exclusão");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		frameMenuUsuario.add(panelMenuUsuario);

		frameMenuUsuario.setSize(800, 600);
		frameMenuUsuario.setVisible(setDeVisibilidade);

		panelMenuUsuario.add(botaoCadastrar);
		panelMenuUsuario.add(botaoConsultar);
		panelMenuUsuario.add(botaoAlterar);
		panelMenuUsuario.add(botaoExcluir);
		panelMenuUsuario.add(botaoVoltar);
		panelMenuUsuario.add(botaoSair);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioSwing.createTelaCadastrarUsuario(true);
				frameMenuUsuario.setVisible(false);

			}
		});

		botaoConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioSwing.createTelaConsultarUsuario(true);
				frameMenuUsuario.setVisible(false);

			}
		});

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioSwing.createTelaAlterarUsuario(true);
				frameMenuUsuario.setVisible(false);

			}
		});

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioSwing.createTelaExcluirUsuario(true);
				frameMenuUsuario.setVisible(false);

			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameMenuUsuario.dispose();
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

	public static void createTelaCadastrarUsuario(Boolean setDeVisibilidade) {
		JFrame frameCadastroUsuario = new JFrame("Cadastro de Usuario");

		JPanel panel = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastrar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelId = new JLabel("Identificação: ");
		JLabel labelNome = new JLabel("Nome: ");

		JTextField textId = new JTextField(10);
		JTextField textNome = new JTextField(25);

		frameCadastroUsuario.add(panel);
		frameCadastroUsuario.setSize(800, 600);
		frameCadastroUsuario.setVisible(setDeVisibilidade);

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
				String id = textId.getText();
				String nome = textNome.getText();
				// Usuario usuario = new Usuario();
				// usuario.setId(Long.parseLong(id));
				// usuario.setNome(nome);
				// try {
				// AutorDao.criarAutor(usuario);
				// } catch (SQLException e1) {
				// e1.printStackTrace();
				// }
				JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
				textId.setText("");
				textNome.setText("");

			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameCadastroUsuario.dispose();
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

	public static void createTelaConsultarUsuario(Boolean setDeVisibilidade) {
		JFrame frameConsultarUsuario = new JFrame("Consulta de Usuario");
		JPanel panelConsultarUsuario = new JPanel();

		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "Nome", "Idade", "Endereço", "Telefone", "CPF", "Discriminator" }, 0);
		JTable tabela = new JTable(model);
		JScrollPane barraRolagem = new JScrollPane(tabela);

		frameConsultarUsuario.add(panelConsultarUsuario);
		frameConsultarUsuario.setSize(800, 600);
		frameConsultarUsuario.setVisible(setDeVisibilidade);

		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		panelConsultarUsuario.add(botaoVoltar);
		panelConsultarUsuario.add(botaoSair);
		panelConsultarUsuario.add(barraRolagem);

		try {
			for (Usuario usuario : UsuarioDao.readUsuarioComum()) {
				String nome = usuario.getNome();
				String idade = String.valueOf(usuario.getIdade());
				String endereco = usuario.getEndereco();
				String telefone = usuario.getTelefone();
				String cpf = usuario.getCpf();
				String discriminator = usuario.getDiscriminator();

				model.addRow(new Object[] { nome, idade, endereco, telefone, cpf, discriminator });

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameConsultarUsuario.dispose();
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

	public static void createTelaAlterarUsuario(Boolean setDeVisibilidade) {
		JFrame frameAlterarUsuario = new JFrame("Alterar Usuario");
		JPanel panelAlterarUsuario = new JPanel();

		JButton botaoAlterar = new JButton("Alterar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelIdUsuario = new JLabel("Atributo a ser alterado: ");
		JLabel labelAtributoUsuario = new JLabel("Valor Atual a ser alterado: ");
		JLabel labelValorNovoUsuario = new JLabel("Valor a ser substituído: ");

		JTextField textIdUsuario = new JTextField(10);
		JTextField textAtributoUsuario = new JTextField(25);
		JTextField textValorNovoUsuario = new JTextField(25);

		frameAlterarUsuario.add(panelAlterarUsuario);
		frameAlterarUsuario.setSize(800, 600);
		frameAlterarUsuario.setVisible(setDeVisibilidade);

		panelAlterarUsuario.add(labelIdUsuario);
		panelAlterarUsuario.add(textIdUsuario);
		panelAlterarUsuario.add(labelAtributoUsuario);
		panelAlterarUsuario.add(textAtributoUsuario);
		panelAlterarUsuario.add(labelValorNovoUsuario);
		panelAlterarUsuario.add(textValorNovoUsuario);
		panelAlterarUsuario.add(botaoAlterar);
		panelAlterarUsuario.add(botaoVoltar);
		panelAlterarUsuario.add(botaoSair);

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textAtributo = textAtributoUsuario.getText();
				String textId = textIdUsuario.getText();
				String textValorNovo = textValorNovoUsuario.getText();
				LivroDao.updateLivro(Long.parseLong(textId), textAtributo, textValorNovo);
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameAlterarUsuario.dispose();
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

	public static void createTelaExcluirUsuario(Boolean setDeVisibilidade) {
		JFrame frameExcluirUsuario = new JFrame("Consulta de Usuario");
		JPanel panelExcluirUsuario = new JPanel();

		JButton botaoExcluir = new JButton("Excluir");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JTextField textNomeDoUsuario = new JTextField(10);

		JLabel labelNomeDoUsuario = new JLabel("Nome do Usuario a ser excluido: ");

		frameExcluirUsuario.add(panelExcluirUsuario);
		frameExcluirUsuario.setSize(800, 600);
		frameExcluirUsuario.setVisible(setDeVisibilidade);

		panelExcluirUsuario.add(labelNomeDoUsuario);
		panelExcluirUsuario.add(textNomeDoUsuario);
		panelExcluirUsuario.add(botaoExcluir);
		panelExcluirUsuario.add(botaoVoltar);
		panelExcluirUsuario.add(botaoSair);

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textNomeUsuario = textNomeDoUsuario.getText();
				try {
					AutorDao.deleteAutor(textNomeUsuario);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Este Usuario foi excluído!");
				textNomeDoUsuario.setText("");
				frameExcluirUsuario.dispose();
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameExcluirUsuario.dispose();
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
