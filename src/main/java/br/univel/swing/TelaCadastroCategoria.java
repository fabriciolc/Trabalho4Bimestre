package br.univel.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.model.Categoria;
import br.univel.model.CategoriaDaoImpl;
import br.univel.model.Pedido;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCadastroCategoria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField text_categoria;
	private static DefaultListModel<Categoria> modelList = new DefaultListModel<Categoria>();
	private List<Categoria> lista = new ArrayList<Categoria>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroCategoria dialog = new TelaCadastroCategoria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void carregarList(){
		CategoriaDaoImpl cdi = new CategoriaDaoImpl();
		for (int i = 0; i < cdi.lista().size(); i++) {
			Categoria c = new Categoria();
			c.setCategoria(cdi.lista().get(i).getCategoria());
			modelList.addElement(c);
		}
	}
	/**
	 * Create the dialog.
	 */
	public TelaCadastroCategoria() {
		carregarList();
		setBounds(100, 100, 450, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 183, 67, 82, 76, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNovaCategoria = new JLabel("Cadastro de Categoria");
			lblNovaCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblNovaCategoria = new GridBagConstraints();
			gbc_lblNovaCategoria.gridwidth = 5;
			gbc_lblNovaCategoria.insets = new Insets(0, 0, 5, 0);
			gbc_lblNovaCategoria.gridx = 0;
			gbc_lblNovaCategoria.gridy = 0;
			contentPanel.add(lblNovaCategoria, gbc_lblNovaCategoria);
		}
		{
			JLabel lblCategoria = new JLabel("Categoria:");
			GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
			gbc_lblCategoria.anchor = GridBagConstraints.WEST;
			gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategoria.gridx = 1;
			gbc_lblCategoria.gridy = 1;
			contentPanel.add(lblCategoria, gbc_lblCategoria);
		}
		{
			text_categoria = new JTextField();
			GridBagConstraints gbc_text_categoria = new GridBagConstraints();
			gbc_text_categoria.insets = new Insets(0, 0, 5, 5);
			gbc_text_categoria.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_categoria.gridx = 1;
			gbc_text_categoria.gridy = 2;
			contentPanel.add(text_categoria, gbc_text_categoria);
			text_categoria.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnInserir = new JButton("Salvar");
				buttonPane.add(btnInserir);
				btnInserir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						salvar();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Sair");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void salvar() {
		CategoriaDaoImpl cdi = new CategoriaDaoImpl();
		Categoria c = new Categoria();
		c.setCategoria(text_categoria.getText());
		
		cdi.inserir(c);
		text_categoria.setText("");
		JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		
		
		
	}

}
