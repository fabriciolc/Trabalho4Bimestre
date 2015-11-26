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
import br.univel.model.Usuario;
import br.univel.model.UsuarioDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField txt_senha;
	private JComboBox cmbCliente;
	private static TelaCadastroUsuario instacia;
	private JTextField txt_usuario;

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
		List<Cliente> lista = cdi.lista();
		for (int i = 0; i < lista.size(); i++) {
			Cliente c = lista.get(i);
			cmbCliente.addItem(c);
		}

		
	}
	/**
	 * Create the dialog.
	 */
	public TelaCadastroUsuario() {
		setBounds(100, 100, 454, 227);
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
			JLabel lblCliente = new JLabel("Cliente");
			GridBagConstraints gbc_lblCliente = new GridBagConstraints();
			gbc_lblCliente.anchor = GridBagConstraints.WEST;
			gbc_lblCliente.insets = new Insets(0, 0, 5, 0);
			gbc_lblCliente.gridx = 4;
			gbc_lblCliente.gridy = 1;
			contentPanel.add(lblCliente, gbc_lblCliente);
		}
		{
			txt_usuario = new JTextField();
			GridBagConstraints gbc_txt_usuario = new GridBagConstraints();
			gbc_txt_usuario.insets = new Insets(0, 0, 5, 5);
			gbc_txt_usuario.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt_usuario.gridx = 1;
			gbc_txt_usuario.gridy = 2;
			contentPanel.add(txt_usuario, gbc_txt_usuario);
			txt_usuario.setColumns(10);
		}
		{
			cmbCliente = new JComboBox();
			GridBagConstraints gbc_cmbCliente = new GridBagConstraints();
			gbc_cmbCliente.gridwidth = 2;
			gbc_cmbCliente.insets = new Insets(0, 0, 5, 0);
			gbc_cmbCliente.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbCliente.gridx = 4;
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
			txt_senha = new JPasswordField();
			GridBagConstraints gbc_txt_senha = new GridBagConstraints();
			gbc_txt_senha.insets = new Insets(0, 0, 0, 5);
			gbc_txt_senha.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt_senha.gridx = 1;
			gbc_txt_senha.gridy = 4;
			contentPanel.add(txt_senha, gbc_txt_senha);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salvar();
					}
				});
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

	protected void salvar() {
		Usuario user = new Usuario();
		Cliente c = (Cliente) cmbCliente.getSelectedItem();
		user.setId_cliente(c.getId());
		user.setSenha(new String(txt_senha.getPassword()));
		
		UsuarioDaoImpl userdi = new UsuarioDaoImpl();
		userdi.inserir(user);

		
	}

}
