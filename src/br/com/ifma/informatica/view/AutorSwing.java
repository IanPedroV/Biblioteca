package br.com.ifma.informatica.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.ifma.informatica.controller.AutorDao;
import br.com.ifma.informatica.controller.EditoraDao;
import br.com.ifma.informatica.model.Autor;
import br.com.ifma.informatica.model.Editora;

public class AutorSwing {

	public static void createTelaMenuAutor(Boolean setDeVisibilidade) {
		JFrame frameMenuAutor = new JFrame("Menu de Autor");
		JPanel panelMenuAutor = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastro");
		JButton botaoConsultar = new JButton("Consulta");
		JButton botaoAlterar = new JButton("Alteração");
		JButton botaoExcluir = new JButton("Exclusão");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		frameMenuAutor.add(panelMenuAutor);

		frameMenuAutor.setSize(800, 600);
		frameMenuAutor.setVisible(setDeVisibilidade);

		panelMenuAutor.add(botaoCadastrar);
		panelMenuAutor.add(botaoConsultar);
		panelMenuAutor.add(botaoAlterar);
		panelMenuAutor.add(botaoExcluir);
		panelMenuAutor.add(botaoVoltar);
		panelMenuAutor.add(botaoSair);

		botaoCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AutorSwing.createTelaCadastrarAutor(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frameMenuAutor.setVisible(false);

			}
		});

		botaoConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AutorSwing.createTelaConsultarAutor(true);
				frameMenuAutor.setVisible(false);

			}
		});

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AutorSwing.createTelaAlterarAutor(true);
				frameMenuAutor.setVisible(false);

			}
		});

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AutorSwing.createTelaExcluirAutor(true);
				frameMenuAutor.setVisible(false);

			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameMenuAutor.dispose();
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

	public static void createTelaCadastrarAutor(Boolean setDeVisibilidade) throws SQLException {
		List<Editora> editoras = EditoraDao.readEditora();
		
		final JList editoraList = new JList(editoras.toArray());
		
		JFrame frameCadastroAutor = new JFrame("Cadastro de Autor");

		JPanel panel = new JPanel();

		JButton botaoCadastrar = new JButton("Cadastrar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelId = new JLabel("Identificação: ");
		JLabel labelNome = new JLabel("Nome: ");

		JTextField textId = new JTextField(10);
		JTextField textNome = new JTextField(25);

		frameCadastroAutor.add(panel);
		frameCadastroAutor.setSize(800, 600);
		frameCadastroAutor.setVisible(setDeVisibilidade);

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
				Autor autor = new Autor();
				autor.setId(Long.parseLong(id));
				autor.setNome(nome);
				try {
					AutorDao.criarAutor(autor);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
				frameCadastroAutor.dispose();
				textId.setText("");
				textNome.setText("");

			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameCadastroAutor.dispose();
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

	public static void createTelaConsultarAutor(Boolean setDeVisibilidade) {
		JFrame frameConsultarAutor = new JFrame("Consulta de Autor");
		JPanel panelConsultarAutor = new JPanel();
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome"},0 );
		JTable tabela = new JTable(model);
		JScrollPane barraRolagem = new JScrollPane(tabela);

		frameConsultarAutor.add(panelConsultarAutor);
		frameConsultarAutor.setSize(800, 600);
		frameConsultarAutor.setVisible(setDeVisibilidade);

		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");
     
		panelConsultarAutor.add(barraRolagem);
		panelConsultarAutor.add(botaoVoltar);
		panelConsultarAutor.add(botaoSair);
		
		try {
			   for (Autor autor : AutorDao.readAutor()) {
				   String nome = autor.getNome();
				    model.addRow(new Object[]{nome});
				    
				  }
			 }
			catch(Exception e){
				e.printStackTrace();
		    }

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameConsultarAutor.dispose();
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

	public static void createTelaAlterarAutor(Boolean setDeVisibilidade) {
		JFrame frameAlterarAutor = new JFrame("Alterar Autor");
		JPanel panelAlterarAutor = new JPanel();

		JButton botaoAlterar = new JButton("Alterar");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JLabel labelIdAutor = new JLabel("Id do Autor: ");
		JLabel labelAtributoAutor = new JLabel("Parametro a ser alterado: ");
		JLabel labelValorNovoAutor = new JLabel("Valor novo: ");

		JTextField textIdAutor = new JTextField(10);
		JTextField textAtributoAutor = new JTextField(25);
		JTextField textValorNovoAutor = new JTextField(25);
		
		frameAlterarAutor.add(panelAlterarAutor);
		frameAlterarAutor.setSize(800, 600);
		frameAlterarAutor.setVisible(setDeVisibilidade);

		panelAlterarAutor.add(labelIdAutor);
		panelAlterarAutor.add(textIdAutor);
		panelAlterarAutor.add(labelAtributoAutor);
		panelAlterarAutor.add(textAtributoAutor);
		panelAlterarAutor.add(labelValorNovoAutor);
		panelAlterarAutor.add(textValorNovoAutor);
		panelAlterarAutor.add(botaoAlterar);
		panelAlterarAutor.add(botaoVoltar);
		panelAlterarAutor.add(botaoSair);

		botaoAlterar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textId = textIdAutor.getText();
				String textAtributo = textAtributoAutor.getText();
				String textValorNovo = textValorNovoAutor.getText();
				AutorDao.updateAutor(Long.parseLong(textId), textAtributo, textValorNovo);
			}
		});
		
		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameAlterarAutor.dispose();
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

	public static void createTelaExcluirAutor(Boolean setDeVisibilidade) {
		JFrame frameExcluirAutor = new JFrame("Consulta de Autor");
		JPanel panelExcluirAutor = new JPanel();

		JButton botaoExcluir = new JButton("Excluir");
		JButton botaoVoltar = new JButton("Voltar");
		JButton botaoSair = new JButton("Sair");

		JTextField textNomeDoAutor = new JTextField(10);

		JLabel labelNomeDoAutor = new JLabel("Nome do Autor a ser excluido: ");

		frameExcluirAutor.add(panelExcluirAutor);
		frameExcluirAutor.setSize(800, 600);
		frameExcluirAutor.setVisible(setDeVisibilidade);

		panelExcluirAutor.add(labelNomeDoAutor);
		panelExcluirAutor.add(textNomeDoAutor);
		panelExcluirAutor.add(botaoExcluir);
		panelExcluirAutor.add(botaoVoltar);
		panelExcluirAutor.add(botaoSair);

		botaoExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textNomeAutor = textNomeDoAutor.getText();
				try {
					AutorDao.deleteAutor(textNomeAutor);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Este Autor foi excluído!");
				textNomeDoAutor.setText("");
				frameExcluirAutor.dispose();
			}
		});

		botaoVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipalSwing.createTela(true);
				frameExcluirAutor.dispose();
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
