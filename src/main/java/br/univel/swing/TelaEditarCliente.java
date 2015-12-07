package br.univel.swing;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.model.*;


import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEditarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private JTextField txt_endereco;
	private JTextField txt_cidade;
	private JTextField txt_email;
	private JTextField txt_id;
	private JComboBox cmb_estado;
	private JComboBox cmb_genero;
	private String mensagem;
	private int id;
	private static TelaEditarCliente instacia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaEditarCliente dialog = new TelaEditarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	private void carregarCmb(){
		cmb_estado.addItem("  ");
		cmb_genero.addItem("  ");
		for(Estado es : Estado.values()){
			cmb_estado.addItem(es);
		}
		for(Genero gr : Genero.values()){
			cmb_genero.addItem(gr);
		}
		
	}
	private void pgtID(){
		try {
			mensagem = JOptionPane.showInputDialog("Digite ID Cliente");
			id = Integer.parseInt(mensagem);
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Digite correta mente o ID");
			pgtID();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * Create the dialog.
	 */
	public TelaEditarCliente() {
		pgtID();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.add(panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{56, 91, 0, 0, -2, 0, 0, 122, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 25, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel label = new JLabel("Cadastro Cliente");
				label.setFont(new Font("Tahoma", Font.BOLD, 16));
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.gridwidth = 8;
				gbc_label.insets = new Insets(0, 0, 5, 0);
				gbc_label.gridx = 0;
				gbc_label.gridy = 0;
				panel.add(label, gbc_label);
			}
			{
				JLabel lblId = new JLabel("Id");
				GridBagConstraints gbc_lblId = new GridBagConstraints();
				gbc_lblId.anchor = GridBagConstraints.EAST;
				gbc_lblId.insets = new Insets(0, 0, 5, 5);
				gbc_lblId.gridx = 0;
				gbc_lblId.gridy = 1;
				panel.add(lblId, gbc_lblId);
			}
			{
				txt_id = new JTextField();
				txt_id.setEditable(false);
				GridBagConstraints gbc_txt_id = new GridBagConstraints();
				gbc_txt_id.insets = new Insets(0, 0, 5, 5);
				gbc_txt_id.fill = GridBagConstraints.HORIZONTAL;
				gbc_txt_id.gridx = 1;
				gbc_txt_id.gridy = 1;
				panel.add(txt_id, gbc_txt_id);
				txt_id.setColumns(10);
			}
			{
				JLabel label = new JLabel("Genero");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 6;
				gbc_label.gridy = 1;
				panel.add(label, gbc_label);
			}
			{
				cmb_genero = new JComboBox();
				GridBagConstraints gbc_cmb_genero = new GridBagConstraints();
				gbc_cmb_genero.fill = GridBagConstraints.HORIZONTAL;
				gbc_cmb_genero.insets = new Insets(0, 0, 5, 0);
				gbc_cmb_genero.gridx = 7;
				gbc_cmb_genero.gridy = 1;
				panel.add(cmb_genero, gbc_cmb_genero);
			}
			{
				JLabel label = new JLabel("Nome");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 2;
				panel.add(label, gbc_label);
			}
			{
				txt_nome = new JTextField();
				txt_nome.setColumns(10);
				GridBagConstraints gbc_txt_nome = new GridBagConstraints();
				gbc_txt_nome.fill = GridBagConstraints.HORIZONTAL;
				gbc_txt_nome.gridwidth = 4;
				gbc_txt_nome.insets = new Insets(0, 0, 5, 5);
				gbc_txt_nome.gridx = 1;
				gbc_txt_nome.gridy = 2;
				panel.add(txt_nome, gbc_txt_nome);
			}
			{
				JLabel label = new JLabel("Telefone");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 3;
				panel.add(label, gbc_label);
			}
			{
				txt_telefone = new JTextField();
				txt_telefone.setColumns(10);
				GridBagConstraints gbc_txt_telefone = new GridBagConstraints();
				gbc_txt_telefone.fill = GridBagConstraints.HORIZONTAL;
				gbc_txt_telefone.gridwidth = 4;
				gbc_txt_telefone.insets = new Insets(0, 0, 5, 5);
				gbc_txt_telefone.gridx = 1;
				gbc_txt_telefone.gridy = 3;
				panel.add(txt_telefone, gbc_txt_telefone);
			}
			{
				JLabel label = new JLabel("Endere\u00E7o");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 4;
				panel.add(label, gbc_label);
			}
			{
				txt_endereco = new JTextField();
				txt_endereco.setColumns(10);
				GridBagConstraints gbc_txt_endereco = new GridBagConstraints();
				gbc_txt_endereco.fill = GridBagConstraints.HORIZONTAL;
				gbc_txt_endereco.gridwidth = 4;
				gbc_txt_endereco.insets = new Insets(0, 0, 5, 5);
				gbc_txt_endereco.gridx = 1;
				gbc_txt_endereco.gridy = 4;
				panel.add(txt_endereco, gbc_txt_endereco);
			}
			{
				JLabel label = new JLabel("Estado");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 6;
				gbc_label.gridy = 4;
				panel.add(label, gbc_label);
			}
			{
				cmb_estado = new JComboBox();
				GridBagConstraints gbc_cmb_estado = new GridBagConstraints();
				gbc_cmb_estado.fill = GridBagConstraints.HORIZONTAL;
				gbc_cmb_estado.insets = new Insets(0, 0, 5, 0);
				gbc_cmb_estado.gridx = 7;
				gbc_cmb_estado.gridy = 4;
				panel.add(cmb_estado, gbc_cmb_estado);
			}
			{
				JLabel label = new JLabel("Cidade");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 5;
				panel.add(label, gbc_label);
			}
			{
				txt_cidade = new JTextField();
				txt_cidade.setColumns(10);
				GridBagConstraints gbc_txt_cidade = new GridBagConstraints();
				gbc_txt_cidade.fill = GridBagConstraints.HORIZONTAL;
				gbc_txt_cidade.gridwidth = 4;
				gbc_txt_cidade.insets = new Insets(0, 0, 5, 5);
				gbc_txt_cidade.gridx = 1;
				gbc_txt_cidade.gridy = 5;
				panel.add(txt_cidade, gbc_txt_cidade);
			}
			{
				JLabel label = new JLabel("Email");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 0, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 6;
				panel.add(label, gbc_label);
			}
			{
				txt_email = new JTextField();
				txt_email.setColumns(10);
				GridBagConstraints gbc_txt_email = new GridBagConstraints();
				gbc_txt_email.fill = GridBagConstraints.HORIZONTAL;
				gbc_txt_email.gridwidth = 4;
				gbc_txt_email.insets = new Insets(0, 0, 0, 5);
				gbc_txt_email.gridx = 1;
				gbc_txt_email.gridy = 6;
				panel.add(txt_email, gbc_txt_email);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Alterar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						alterar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		carregartxt();
	}
	protected void alterar() {
		Cliente c = new Cliente();
		c.setNome(txt_nome.getText()); 
		c.setEmail(txt_email.getText());
		c.setTelefone(txt_telefone.getText());
		c.setCidade(txt_cidade.getText());
		c.setEndereco(txt_endereco.getText());
		c.setEstado(cmb_estado.getSelectedItem().toString());
		c.setGenero(cmb_genero.getSelectedItem().toString());

		ClienteDaoImpl cdi = new ClienteDaoImpl();
		cdi.atualizar(c);

		limpar();
		JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
		TelaListaCliente.atualizarTabela();
		this.dispose();
		
	}

	private void limpar() {
		txt_nome.setText("");
		txt_cidade.setText("");
		txt_email.setText("");
		txt_endereco.setText("");
		txt_telefone.setText("");
		
		
		
	}

	private void carregartxt(){
		ClienteDaoImpl cdi = new ClienteDaoImpl();
		Cliente c = cdi.buscar(id);
		if(c == null){
			JOptionPane.showMessageDialog(null, "Cliente nao Encontrado");
		}else{
			txt_id.setText(String.valueOf(c.getId()));
			txt_nome.setText(c.getNome());
			txt_cidade.setText(c.getCidade());
			txt_email.setText(c.getEmail());
			txt_endereco.setText(c.getEndereco());
			txt_telefone.setText(c.getTelefone());
			
			cmb_estado.addItem(c.getEstado());
			cmb_genero.addItem(c.getGenero());
			carregarCmb();
		
			
		}
	}

}
