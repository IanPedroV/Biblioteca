package br.com.ifma.informatica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.ifma.informatica.controller.AluguelDao;
import br.com.ifma.informatica.controller.EditoraDao;
import br.com.ifma.informatica.controller.LivroDao;
import br.com.ifma.informatica.controller.UsuarioDao;
import br.com.ifma.informatica.model.AluguelDeLivro;
import br.com.ifma.informatica.model.Bibliotecario;
import br.com.ifma.informatica.model.Editora;
import br.com.ifma.informatica.model.Livro;
import br.com.ifma.informatica.model.Usuario;
import br.com.ifma.informatica.model.UsuarioComum;

public class AluguelSwing {

	public static void createTelaMenuAluguel(Boolean setDeVisibilidade) {
		JFrame frameMenuAluguel = new JFrame("Menu de Aluguel");
		JPanel panelMenuAluguel = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastro");
		JButton botaoConsultar = new JButton("Consulta");
		JButton botaoAlterar = new JButton("Alteração");
		JButton botaoExcluir = new JButton("Exclusão");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		frameMenuAluguel.add(panelMenuAluguel);
		frameMenuAluguel.setSize(800, 600);
		frameMenuAluguel.setVisible(setDeVisibilidade);

		panelMenuAluguel.add(botaoCadastrar);
		panelMenuAluguel.add(botaoConsultar);
		panelMenuAluguel.add(botaoAlterar);
		panelMenuAluguel.add(botaoExcluir);
		panelMenuAluguel.add(botaoVoltar);
		panelMenuAluguel.add(botaoSair);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AluguelSwing.createTelaCadastrarAluguel(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frameMenuAluguel.setVisible(false);

			}
		});

		botaoConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AluguelSwing.createTelaConsultarAluguel(true);
				frameMenuAluguel.setVisible(false);

			}
		});

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AluguelSwing.createTelaAlterarAluguel(true);
				frameMenuAluguel.setVisible(false);

			}
		});

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AluguelSwing.createTelaExcluirAluguel(true);
				frameMenuAluguel.setVisible(false);

			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameMenuAluguel.dispose();
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

	public static void createTelaCadastrarAluguel(Boolean setDeVisibilidade) throws SQLException {
		// List<Editora> editoras = EditoraDao.readEditora();

		// final JList editoraList = new JList(editoras.toArray());

		JFrame frameCadastroAluguel = new JFrame("Cadastro de Aluguel");

		JPanel panel = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastrar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		final DefaultComboBoxModel<Livro> defaultcombo = new DefaultComboBoxModel<Livro>();
		final JComboBox<Livro> comboLivro = new JComboBox<Livro>(defaultcombo);
		
	    final DefaultComboBoxModel<UsuarioComum> defaultcomboUsuarioComum = new DefaultComboBoxModel<UsuarioComum>();
	    final JComboBox<UsuarioComum> comboUsuarioComum = new JComboBox<UsuarioComum>(defaultcomboUsuarioComum);

	    final DefaultComboBoxModel<Bibliotecario> defaultComboBibliotecario = new DefaultComboBoxModel<Bibliotecario>();
	    final JComboBox<Bibliotecario> comboBibliotecario = new JComboBox<Bibliotecario>(defaultComboBibliotecario);
	    
		JLabel labelId = new JLabel("Identificação: ");
		JLabel labelLivro = new JLabel("Livro: ");
		JLabel labelIdUsuario = new JLabel("Usuario: ");
		JLabel labelIdBibliotecario = new JLabel("Biblitecario: ");
		JLabel labeldataaluguel = new JLabel("Data do Aluguel: ");
		JLabel labeldatadevolucao = new JLabel("Data de Devoluçao: ");


		JTextField textId = new JTextField(10);
		JTextField textIdLivro = new JTextField(25);
		JTextField textIdUsuario = new JTextField(25);
		JTextField textIdBiblitecario = new JTextField(25);
		JTextField textdataaluguel = new JTextField(25);
		JTextField textdatadevolucao = new JTextField(25);

		frameCadastroAluguel.add(panel);
		frameCadastroAluguel.setSize(800, 600);
		frameCadastroAluguel.setVisible(setDeVisibilidade);

		for (Livro livro : LivroDao.readLivro()) {
			comboLivro.addItem(livro);
		}
		
		
		for (UsuarioComum usuario : UsuarioDao.readUsuarioComum()) {
			comboUsuarioComum.addItem(usuario);
			
		}
		
		for (Bibliotecario bibliotecario : UsuarioDao.readBibliotecario()) {
			comboBibliotecario.addItem(bibliotecario);
			
		}
		
		panel.add(labelId);
		panel.add(textId);
		panel.add(labelLivro);
		panel.add(comboLivro);
		panel.add(labelIdUsuario);
		panel.add(comboUsuarioComum);
		panel.add(labelIdBibliotecario);
		panel.add(comboBibliotecario);
		panel.add(labeldataaluguel);
		panel.add(textdataaluguel);
		panel.add(labeldatadevolucao);
		panel.add(textdatadevolucao);
		panel.add(botaoCadastrar);
		panel.add(botaoVoltar);
		panel.add(botaoSair);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String id = textId.getText();
				String dataaluguel = textdataaluguel.getText();
				String datadevolucao = textdatadevolucao.getText();
				AluguelDeLivro aluguel = new AluguelDeLivro();
				Livro livro = null;
				try {
					livro = (Livro) comboLivro.getSelectedItem();
					UsuarioComum usuario = (UsuarioComum) comboUsuarioComum.getSelectedItem();
					Bibliotecario bibliotecario = (Bibliotecario) comboBibliotecario.getSelectedItem();
					aluguel.setLivro(livro);
					aluguel.setUsuario(usuario);
					aluguel.setBibliotecario(bibliotecario);
					aluguel.setId(Long.valueOf(id));
					aluguel.setHoraDoAluguel(dataaluguel);
					aluguel.setHoraDeDevolucao(datadevolucao);
					AluguelDao.criarAluguel(aluguel);
				} catch (NumberFormatException | SQLException e2) {
					e2.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Aluguel do livro: "+ livro.getNome() + " cadastrado com sucesso!");
				frameCadastroAluguel.dispose();
				textId.setText("");
				textIdLivro.setText("");
				textIdUsuario.setText("");
				textIdBiblitecario.setText("");
				textdataaluguel.setText("");
				textdatadevolucao.setText("");

			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameCadastroAluguel.dispose();
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

	public static void createTelaConsultarAluguel(Boolean setDeVisibilidade) {
		JFrame frameConsultarAluguel = new JFrame("Consulta de Aluguel");
		JPanel panelConsultarAluguel = new JPanel();

		DefaultTableModel model = new DefaultTableModel(new Object[] { "Id", "Data do Aluguel", "Data de Devolução" },
				0);
		JTable tabela = new JTable(model);
		JScrollPane barraRolagem = new JScrollPane(tabela);

		frameConsultarAluguel.add(panelConsultarAluguel);
		frameConsultarAluguel.setSize(800, 600);
		frameConsultarAluguel.setVisible(setDeVisibilidade);

		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		panelConsultarAluguel.add(barraRolagem);
		panelConsultarAluguel.add(botaoVoltar);
		panelConsultarAluguel.add(botaoSair);

		try {
			for (AluguelDeLivro aluguel : AluguelDao.readAluguel()) {
				String id = String.valueOf(aluguel.getId());
				String dataaluguel = aluguel.getHoraDoAluguel();
				String datadedevolucao = aluguel.getHoraDeDevolucao();

				model.addRow(new Object[] { id, dataaluguel, datadedevolucao });

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameConsultarAluguel.dispose();
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

	public static void createTelaAlterarAluguel(Boolean setDeVisibilidade) {
		JFrame frameAlterarAluguel = new JFrame("Alterar Aluguel");
		JPanel panelAlterarAluguel = new JPanel();

		JButton botaoAlterar = new JButton("Alterar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelIdAluguel = new JLabel("Id do Aluguel: ");
		JLabel labelAtributoAluguel = new JLabel("Parametro a ser alterado: ");
		JLabel labelValorNovoAluguel = new JLabel("Valor novo: ");

		JTextField textIdAluguel = new JTextField(10);
		JTextField textAtributoAluguel = new JTextField(25);
		JTextField textValorNovoAluguel = new JTextField(25);

		frameAlterarAluguel.add(panelAlterarAluguel);
		frameAlterarAluguel.setSize(800, 600);
		frameAlterarAluguel.setVisible(setDeVisibilidade);

		panelAlterarAluguel.add(labelIdAluguel);
		panelAlterarAluguel.add(textIdAluguel);
		panelAlterarAluguel.add(labelAtributoAluguel);
		panelAlterarAluguel.add(textAtributoAluguel);
		panelAlterarAluguel.add(labelValorNovoAluguel);
		panelAlterarAluguel.add(textValorNovoAluguel);
		panelAlterarAluguel.add(botaoAlterar);
		panelAlterarAluguel.add(botaoVoltar);
		panelAlterarAluguel.add(botaoSair);

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textValorAtual = textIdAluguel.getText();
				String textAtributo = textAtributoAluguel.getText();
				String textValorNovo = textValorNovoAluguel.getText();
				try {
					AluguelDao.updateAluguel(textValorAtual, textValorNovo, textAtributo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameAlterarAluguel.dispose();
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

	public static void createTelaExcluirAluguel(Boolean setDeVisibilidade) {
		JFrame frameExcluirAluguel = new JFrame("Consulta de Aluguel");
		JPanel panelExcluirAluguel = new JPanel();

		JButton botaoExcluir = new JButton("Excluir");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JTextField textNomeDoAluguel = new JTextField(10);

		JLabel labelNomeDoAluguel = new JLabel("Nome do Aluguel a ser excluido: ");

		frameExcluirAluguel.add(panelExcluirAluguel);
		frameExcluirAluguel.setSize(800, 600);
		frameExcluirAluguel.setVisible(setDeVisibilidade);

		panelExcluirAluguel.add(labelNomeDoAluguel);
		panelExcluirAluguel.add(textNomeDoAluguel);
		panelExcluirAluguel.add(botaoExcluir);
		panelExcluirAluguel.add(botaoVoltar);
		panelExcluirAluguel.add(botaoSair);

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textNomeAluguel = textNomeDoAluguel.getText();
				try {
					AluguelDao.deleteAluguel(textNomeAluguel);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Este Aluguel foi excluído!");
				textNomeDoAluguel.setText("");
				frameExcluirAluguel.dispose();
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameExcluirAluguel.dispose();
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
