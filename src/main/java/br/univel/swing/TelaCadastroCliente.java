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

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;

import br.univel.model.Cliente;
import br.univel.model.ClienteDaoImpl;
import br.univel.model.Estado;
import br.univel.model.Genero;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField text_nome;
	private JTextField text_telefone;
	private JTextField text_endereco;
	private JTextField text_cidade;
	private JTextField text_email;
	private static TelaCadastroCliente instacia;
	private JComboBox cmb_estado;
	private JComboBox cmb_Genero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroCliente dialog = new TelaCadastroCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TelaCadastroCliente getInstacia(){
		if(instacia == null)
			instacia = new TelaCadastroCliente();
		return instacia;
	}
	private void carregarCmb(){
	for(Estado es : Estado.values()){
		cmb_estado.addItem(es);
	}
	for(Genero gr : Genero.values()){
		cmb_Genero.addItem(gr);
	}
		
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastroCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{56, 91, 0, 0, -2, 0, 0, 122, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 25, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
			lblCadastroCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_lblCadastroCliente = new GridBagConstraints();
			gbc_lblCadastroCliente.gridwidth = 8;
			gbc_lblCadastroCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblCadastroCliente.gridx = 0;
			gbc_lblCadastroCliente.gridy = 0;
			contentPanel.add(lblCadastroCliente, gbc_lblCadastroCliente);
		}
		{
			JLabel lblNome = new JLabel("Nome");
			GridBagConstraints gbc_lblNome = new GridBagConstraints();
			gbc_lblNome.anchor = GridBagConstraints.EAST;
			gbc_lblNome.insets = new Insets(0, 0, 5, 5);
			gbc_lblNome.gridx = 0;
			gbc_lblNome.gridy = 1;
			contentPanel.add(lblNome, gbc_lblNome);
		}
		{
			text_nome = new JTextField();
			GridBagConstraints gbc_text_nome = new GridBagConstraints();
			gbc_text_nome.gridwidth = 4;
			gbc_text_nome.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_nome.insets = new Insets(0, 0, 5, 5);
			gbc_text_nome.gridx = 1;
			gbc_text_nome.gridy = 1;
			contentPanel.add(text_nome, gbc_text_nome);
			text_nome.setColumns(10);
		}
		{
			JLabel lblGenero = new JLabel("Genero");
			GridBagConstraints gbc_lblGenero = new GridBagConstraints();
			gbc_lblGenero.anchor = GridBagConstraints.EAST;
			gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
			gbc_lblGenero.gridx = 6;
			gbc_lblGenero.gridy = 1;
			contentPanel.add(lblGenero, gbc_lblGenero);
		}
		{
			cmb_Genero = new JComboBox();
			GridBagConstraints gbc_cmb_Genero = new GridBagConstraints();
			gbc_cmb_Genero.insets = new Insets(0, 0, 5, 0);
			gbc_cmb_Genero.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmb_Genero.gridx = 7;
			gbc_cmb_Genero.gridy = 1;
			contentPanel.add(cmb_Genero, gbc_cmb_Genero);
		}
		{
			JLabel lblNewLabel = new JLabel("Telefone");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			text_telefone = new JTextField();
			GridBagConstraints gbc_text_telefone = new GridBagConstraints();
			gbc_text_telefone.gridwidth = 4;
			gbc_text_telefone.insets = new Insets(0, 0, 5, 5);
			gbc_text_telefone.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_telefone.gridx = 1;
			gbc_text_telefone.gridy = 2;
			contentPanel.add(text_telefone, gbc_text_telefone);
			text_telefone.setColumns(10);
		}
		{
			JLabel lblEndereco = new JLabel("Endere\u00E7o");
			GridBagConstraints gbc_lblEndereco = new GridBagConstraints();
			gbc_lblEndereco.anchor = GridBagConstraints.EAST;
			gbc_lblEndereco.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndereco.gridx = 0;
			gbc_lblEndereco.gridy = 3;
			contentPanel.add(lblEndereco, gbc_lblEndereco);
		}
		{
			text_endereco = new JTextField();
			GridBagConstraints gbc_text_endereco = new GridBagConstraints();
			gbc_text_endereco.gridwidth = 4;
			gbc_text_endereco.insets = new Insets(0, 0, 5, 5);
			gbc_text_endereco.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_endereco.gridx = 1;
			gbc_text_endereco.gridy = 3;
			contentPanel.add(text_endereco, gbc_text_endereco);
			text_endereco.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Cidade");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 4;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			text_cidade = new JTextField();
			GridBagConstraints gbc_text_cidade = new GridBagConstraints();
			gbc_text_cidade.gridwidth = 4;
			gbc_text_cidade.insets = new Insets(0, 0, 5, 5);
			gbc_text_cidade.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_cidade.gridx = 1;
			gbc_text_cidade.gridy = 4;
			contentPanel.add(text_cidade, gbc_text_cidade);
			text_cidade.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Estado");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 6;
			gbc_lblEmail.gridy = 4;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			cmb_estado = new JComboBox();
			GridBagConstraints gbc_cmb_estado = new GridBagConstraints();
			gbc_cmb_estado.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmb_estado.insets = new Insets(0, 0, 5, 0);
			gbc_cmb_estado.gridx = 7;
			gbc_cmb_estado.gridy = 4;
			contentPanel.add(cmb_estado, gbc_cmb_estado);
		}
		{
			JLabel lblEmail_1 = new JLabel("Email");
			GridBagConstraints gbc_lblEmail_1 = new GridBagConstraints();
			gbc_lblEmail_1.anchor = GridBagConstraints.EAST;
			gbc_lblEmail_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail_1.gridx = 0;
			gbc_lblEmail_1.gridy = 5;
			contentPanel.add(lblEmail_1, gbc_lblEmail_1);
		}
		{
			text_email = new JTextField();
			GridBagConstraints gbc_text_email = new GridBagConstraints();
			gbc_text_email.gridwidth = 4;
			gbc_text_email.insets = new Insets(0, 0, 5, 5);
			gbc_text_email.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_email.gridx = 1;
			gbc_text_email.gridy = 5;
			contentPanel.add(text_email, gbc_text_email);
			text_email.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
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
		Cliente c = new Cliente();
		c.setNome(text_nome.getText()); 
		c.setEmail(text_email.getText());
		c.setTelefone(text_telefone.getText());
		c.setCidade(text_cidade.getText());
		c.setEndereco(text_cidade.getText());
		c.setEstado(cmb_estado.getSelectedItem().toString());
		c.setGenero(cmb_Genero.getSelectedItem().toString());

		ClienteDaoImpl cdi = new ClienteDaoImpl();
		cdi.inserir(c);
		
	}

}
