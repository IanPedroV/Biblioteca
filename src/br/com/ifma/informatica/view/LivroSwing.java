package br.com.ifma.informatica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import br.com.ifma.informatica.controller.AutorDao;
import br.com.ifma.informatica.controller.EditoraDao;
import br.com.ifma.informatica.controller.LivroDao;
import br.com.ifma.informatica.controller.UsuarioDao;
import br.com.ifma.informatica.model.Autor;
import br.com.ifma.informatica.model.Editora;
import br.com.ifma.informatica.model.Livro;
import br.com.ifma.informatica.model.UsuarioComum;

public class LivroSwing {

	public static void createTelaMenuLivro(Boolean setDeVisibilidade) {
		JFrame frameMenuLivro = new JFrame("Menu de Livro");
		JPanel panelMenuLivro = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastro");
		JButton botaoConsultar = new JButton("Consulta");
		JButton botaoAlterar = new JButton("Alteração");
		JButton botaoExcluir = new JButton("Exclusão");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		frameMenuLivro.add(panelMenuLivro);

		frameMenuLivro.setSize(800, 600);
		frameMenuLivro.setVisible(setDeVisibilidade);

		panelMenuLivro.add(botaoCadastrar);
		panelMenuLivro.add(botaoConsultar);
		panelMenuLivro.add(botaoAlterar);
		panelMenuLivro.add(botaoExcluir);
		panelMenuLivro.add(botaoVoltar);
		panelMenuLivro.add(botaoSair);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					LivroSwing.createTelaCadastrarLivro(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frameMenuLivro.setVisible(false);

			}
		});

		botaoConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LivroSwing.createTelaConsultarLivro(true);
				frameMenuLivro.setVisible(false);

			}
		});

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LivroSwing.createTelaAlterarLivro(true);
				frameMenuLivro.setVisible(false);

			}
		});

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LivroSwing.createTelaExcluirLivro(true);
				frameMenuLivro.setVisible(false);

			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameMenuLivro.dispose();
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

	public static void createTelaCadastrarLivro(Boolean setDeVisibilidade) throws SQLException {
		JFrame frameCadastroLivro = new JFrame("Cadastro de Livro");

		JPanel panel = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastrar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");
		
		final DefaultComboBoxModel<Editora> defaultcombo = new DefaultComboBoxModel<Editora>();
	    final JComboBox<Editora> comboEditora = new JComboBox<Editora>(defaultcombo);
	    


		JLabel labelId = new JLabel("Identificação: ");
		JLabel labelNome = new JLabel("Nome: ");
		JLabel labelEditora = new JLabel("Editora: ");

		JTextField textId = new JTextField(10);
		JTextField textNome = new JTextField(25);

		frameCadastroLivro.add(panel);
		frameCadastroLivro.setSize(800, 600);
		frameCadastroLivro.setVisible(setDeVisibilidade);

		for (Editora editora : EditoraDao.readEditora()) {
			comboEditora.addItem(editora);
		}

		
		panel.add(labelId);
		panel.add(textId);
		panel.add(labelNome);
		panel.add(textNome);
		panel.add(labelEditora);
		panel.add(comboEditora);
		panel.add(botaoCadastrar);
		panel.add(botaoVoltar);
		panel.add(botaoSair);
		
		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
				try {
					Livro livro = new Livro();
					String text = textId.getText();
					String text1 = textNome.getText();
					Editora editora = (Editora) comboEditora.getSelectedItem();
					List<Autor> autores = new ArrayList<Autor>();
					autores.add(AutorDao.readAutor(1));
					livro.setId(Long.parseLong(text));
					livro.setNome(text1);
					livro.setEditora(editora);
					livro.setAutores(autores);
					LivroDao.criarLivro(livro);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				textId.setText("");
				textNome.setText("");

			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameCadastroLivro.dispose();
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

	public static void createTelaConsultarLivro(Boolean setDeVisibilidade) {
		JFrame frameConsultarLivro = new JFrame("Consulta de Livro");
		JPanel panelConsultarLivro = new JPanel();
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome","Editora"},0 );
		JTable tabela = new JTable(model);
		JScrollPane barraRolagem = new JScrollPane(tabela);

		frameConsultarLivro.add(panelConsultarLivro);
		frameConsultarLivro.setSize(800, 600);
		frameConsultarLivro.setVisible(setDeVisibilidade);

		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		panelConsultarLivro.add(barraRolagem);
		panelConsultarLivro.add(botaoVoltar);
		panelConsultarLivro.add(botaoSair);
		
		try {
			   for (Livro livro : LivroDao.readLivro()) {
				   String nome = livro.getNome();
				   Editora editora = livro.getEditora();
				    model.addRow(new Object[]{nome,editora});
				    
				  }
			 }
			catch(Exception e){
				e.printStackTrace();
		    }

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameConsultarLivro.dispose();
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

	public static void createTelaAlterarLivro(Boolean setDeVisibilidade) {
		JFrame frameAlterarLivro = new JFrame("Alterar Livro");
		JPanel panelAlterarLivro = new JPanel();

		JButton botaoAlterar = new JButton("Alterar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelIdLivro = new JLabel("Id do Livro: ");
		JLabel labelAtributoLivro = new JLabel("Parametro a ser alterado: ");
		JLabel labelValorNovoLivro = new JLabel("Valor novo: ");

		JTextField textIdLivro = new JTextField(10);
		JTextField textAtributoLivro = new JTextField(25);
		JTextField textValorNovoLivro = new JTextField(25);

		frameAlterarLivro.add(panelAlterarLivro);
		frameAlterarLivro.setSize(800, 600);
		frameAlterarLivro.setVisible(setDeVisibilidade);

		panelAlterarLivro.add(labelIdLivro);
		panelAlterarLivro.add(textIdLivro);
		panelAlterarLivro.add(labelAtributoLivro);
		panelAlterarLivro.add(textAtributoLivro);
		panelAlterarLivro.add(labelValorNovoLivro);
		panelAlterarLivro.add(textValorNovoLivro);
		panelAlterarLivro.add(botaoAlterar);
		panelAlterarLivro.add(botaoVoltar);
		panelAlterarLivro.add(botaoSair);

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!");
				MenuPrincipalSwing.createTela(true);
				frameAlterarLivro.dispose();
				String textId = textIdLivro.getText();
				String textAtributo = textAtributoLivro.getText();
				String textValorNovo = textValorNovoLivro.getText();
				LivroDao.updateLivro(Long.parseLong(textId), textAtributo, textValorNovo);
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameAlterarLivro.dispose();
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

	public static void createTelaExcluirLivro(Boolean setDeVisibilidade) {
		JFrame frameExcluirLivro = new JFrame("Consulta de Livro");
		JPanel panelExcluirLivro = new JPanel();

		JButton botaoExcluir = new JButton("Excluir");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JTextField textNomeDoLivro = new JTextField(10);

		JLabel labelNomeDoLivro = new JLabel("Nome do livro a ser excluido: ");

		frameExcluirLivro.add(panelExcluirLivro);
		frameExcluirLivro.setSize(800, 600);
		frameExcluirLivro.setVisible(setDeVisibilidade);

		panelExcluirLivro.add(labelNomeDoLivro);
		panelExcluirLivro.add(textNomeDoLivro);
		panelExcluirLivro.add(botaoExcluir);
		panelExcluirLivro.add(botaoVoltar);
		panelExcluirLivro.add(botaoSair);

		botaoExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String textNome = textNomeDoLivro.getText();
				try {
					LivroDao.deleteLivro(textNome);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Este livro foi excluído!");
				textNomeDoLivro.setText("");
				frameExcluirLivro.dispose();
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameExcluirLivro.dispose();
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