package br.univel.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.Font;

public class TelaCadastroCategoria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

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

	/**
	 * Create the dialog.
	 */
	public TelaCadastroCategoria() {
		setBounds(100, 100, 450, 260);
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
			JLabel lblNewLabel = new JLabel("Lista Categoria");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.gridwidth = 2;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 3;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 2;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JButton btnInserir = new JButton("Inserir");
			GridBagConstraints gbc_btnInserir = new GridBagConstraints();
			gbc_btnInserir.insets = new Insets(0, 0, 5, 5);
			gbc_btnInserir.gridx = 2;
			gbc_btnInserir.gridy = 2;
			contentPanel.add(btnInserir, gbc_btnInserir);
		}
		{
			JList list = new JList();
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.gridheight = 5;
			gbc_list.gridwidth = 2;
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 3;
			gbc_list.gridy = 2;
			contentPanel.add(list, gbc_list);
		}
		{
			JButton btnExcluir = new JButton("Excluir");
			GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
			gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
			gbc_btnExcluir.gridx = 2;
			gbc_btnExcluir.gridy = 3;
			contentPanel.add(btnExcluir, gbc_btnExcluir);
		}
		{
			JButton btnNewButton = new JButton("Editar");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 5;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Salvar");
			btnNewButton_1.setEnabled(false);
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton_1.gridx = 2;
			gbc_btnNewButton_1.gridy = 6;
			contentPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Sair");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
