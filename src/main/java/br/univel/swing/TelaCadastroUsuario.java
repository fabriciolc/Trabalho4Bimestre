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
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import br.univel.model.Cliente;
import br.univel.model.ClienteDaoImpl;

public class TelaCadastroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JComboBox cmbCliente;
	private static TelaCadastroUsuario instacia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroUsuario dialog = new TelaCadastroUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TelaCadastroUsuario getInstacia(){
		if(instacia == null)
			instacia = new TelaCadastroUsuario();
		return instacia;
	}
	
	public void carregarCmb(){
		ClienteDaoImpl cdi = new ClienteDaoImpl();
		List<Cliente> lista = new ArrayList<Cliente>();
		lista = cdi.lista();
		System.out.println(lista.get(0).getNome());
		
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastroUsuario() {
		setBounds(100, 100, 450, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 151, 49, 42, 70, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUsuario = new JLabel("Usuario");
			GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
			gbc_lblUsuario.anchor = GridBagConstraints.WEST;
			gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsuario.gridx = 1;
			gbc_lblUsuario.gridy = 1;
			contentPanel.add(lblUsuario, gbc_lblUsuario);
		}
		{
			cmbCliente = new JComboBox();
			GridBagConstraints gbc_cmbCliente = new GridBagConstraints();
			gbc_cmbCliente.insets = new Insets(0, 0, 5, 5);
			gbc_cmbCliente.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbCliente.gridx = 1;
			gbc_cmbCliente.gridy = 2;
			contentPanel.add(cmbCliente, gbc_cmbCliente);
		}
		{
			JLabel lblSenha = new JLabel("Senha");
			GridBagConstraints gbc_lblSenha = new GridBagConstraints();
			gbc_lblSenha.anchor = GridBagConstraints.WEST;
			gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
			gbc_lblSenha.gridx = 1;
			gbc_lblSenha.gridy = 3;
			contentPanel.add(lblSenha, gbc_lblSenha);
		}
		{
			passwordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 0, 5);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 1;
			gbc_passwordField.gridy = 4;
			contentPanel.add(passwordField, gbc_passwordField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		carregarCmb();
	}

}
