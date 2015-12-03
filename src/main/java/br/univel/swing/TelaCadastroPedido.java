package br.univel.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JComboBox;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;






import br.univel.model.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TelaCadastroPedido extends JDialog {
	private static TelaCadastroPedido instancia; 

	private final JPanel contentPanel = new JPanel();
	private static ArrayList<Produto> listProduto = new ArrayList<Produto>();
	private static ArrayList<Produto> listProdutop = new ArrayList<Produto>();
	private JComboBox cmbCliente;
	private JTextField txt_qnt;
	private JComboBox cmbProduto;
	private JList listPedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroPedido dialog = new TelaCadastroPedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TelaCadastroPedido getInstacia(){
		if(instancia == null)
			instancia = new TelaCadastroPedido();
		return instancia;
		
	}
	private void carregarList(){
		ProdutoDaoImpl pdi = new ProdutoDaoImpl();
		List<Produto> lista = pdi.lista();
		for (int i = 0; i < lista.size(); i++) {
			Produto c = lista.get(i);
			listProduto.add(c);
		}
	}
	public void carregarCmb(){
		ClienteDaoImpl cdi = new ClienteDaoImpl();
		List<Cliente> lista = cdi.lista();
		for (int i = 0; i < lista.size(); i++) {
			Cliente c = lista.get(i);
			cmbCliente.addItem(c);
		}
		
		ProdutoDaoImpl pdi = new ProdutoDaoImpl();
		List<Produto> listap = pdi.lista();
		for (int i = 0; i < listap.size(); i++) {
			Produto p = listap.get(i);
			cmbProduto.addItem(p);
			
		}
		

		
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastroPedido() {
		carregarList();
		
		setBounds(100, 100, 457, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 55, 154, 29, 51, 0, 56, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 10, 36, 0, 39, 35, 14, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCliente = new JLabel("Cliente");
			GridBagConstraints gbc_lblCliente = new GridBagConstraints();
			gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblCliente.anchor = GridBagConstraints.WEST;
			gbc_lblCliente.gridx = 1;
			gbc_lblCliente.gridy = 0;
			contentPanel.add(lblCliente, gbc_lblCliente);
		}
		
		{
			cmbCliente = new JComboBox();
			GridBagConstraints gbc_cmbCliente = new GridBagConstraints();
			gbc_cmbCliente.insets = new Insets(0, 0, 5, 5);
			gbc_cmbCliente.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbCliente.gridx = 2;
			gbc_cmbCliente.gridy = 0;
			contentPanel.add(cmbCliente, gbc_cmbCliente);
		}
		{
			JLabel lblProduto = new JLabel("Produto");
			GridBagConstraints gbc_lblProduto = new GridBagConstraints();
			gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
			gbc_lblProduto.anchor = GridBagConstraints.EAST;
			gbc_lblProduto.gridx = 1;
			gbc_lblProduto.gridy = 2;
			contentPanel.add(lblProduto, gbc_lblProduto);
		}
		{
			cmbProduto = new JComboBox();
			GridBagConstraints gbc_cmbProduto = new GridBagConstraints();
			gbc_cmbProduto.insets = new Insets(0, 0, 5, 5);
			gbc_cmbProduto.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbProduto.gridx = 2;
			gbc_cmbProduto.gridy = 2;
			contentPanel.add(cmbProduto, gbc_cmbProduto);
		}
		{
			JLabel lblQnt = new JLabel("Qnt");
			GridBagConstraints gbc_lblQnt = new GridBagConstraints();
			gbc_lblQnt.insets = new Insets(0, 0, 5, 5);
			gbc_lblQnt.gridx = 3;
			gbc_lblQnt.gridy = 2;
			contentPanel.add(lblQnt, gbc_lblQnt);
		}
		{
			txt_qnt = new JTextField();
			GridBagConstraints gbc_txt_qnt = new GridBagConstraints();
			gbc_txt_qnt.insets = new Insets(0, 0, 5, 5);
			gbc_txt_qnt.fill = GridBagConstraints.HORIZONTAL;
			gbc_txt_qnt.gridx = 4;
			gbc_txt_qnt.gridy = 2;
			contentPanel.add(txt_qnt, gbc_txt_qnt);
			txt_qnt.setColumns(10);
		}
		{
			JButton btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					adicionar();
				}
			});
			GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
			gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
			gbc_btnAdicionar.gridx = 6;
			gbc_btnAdicionar.gridy = 2;
			contentPanel.add(btnAdicionar, gbc_btnAdicionar);
		}
		{
			JLabel lblListaDoPedido = new JLabel("Lista do Pedido");
			GridBagConstraints gbc_lblListaDoPedido = new GridBagConstraints();
			gbc_lblListaDoPedido.anchor = GridBagConstraints.WEST;
			gbc_lblListaDoPedido.gridwidth = 2;
			gbc_lblListaDoPedido.insets = new Insets(0, 0, 5, 5);
			gbc_lblListaDoPedido.gridx = 1;
			gbc_lblListaDoPedido.gridy = 3;
			contentPanel.add(lblListaDoPedido, gbc_lblListaDoPedido);
		}
		{
			listPedido = new JList();
			GridBagConstraints gbc_listPedido = new GridBagConstraints();
			gbc_listPedido.gridwidth = 7;
			gbc_listPedido.gridheight = 3;
			gbc_listPedido.insets = new Insets(0, 0, 5, 5);
			gbc_listPedido.fill = GridBagConstraints.BOTH;
			gbc_listPedido.gridx = 1;
			gbc_listPedido.gridy = 4;
			contentPanel.add(listPedido, gbc_listPedido);
		}
		{
			JLabel lblPreoo = new JLabel("Total: ");
			GridBagConstraints gbc_lblPreoo = new GridBagConstraints();
			gbc_lblPreoo.anchor = GridBagConstraints.EAST;
			gbc_lblPreoo.insets = new Insets(0, 0, 0, 5);
			gbc_lblPreoo.gridx = 4;
			gbc_lblPreoo.gridy = 7;
			contentPanel.add(lblPreoo, gbc_lblPreoo);
		}
		{
			JLabel lb_preço = new JLabel("R$ 0,00");
			GridBagConstraints gbc_lb_preço = new GridBagConstraints();
			gbc_lb_preço.insets = new Insets(0, 0, 0, 5);
			gbc_lb_preço.anchor = GridBagConstraints.WEST;
			gbc_lb_preço.gridx = 6;
			gbc_lb_preço.gridy = 7;
			contentPanel.add(lb_preço, gbc_lb_preço);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
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

	protected void adicionar() {
		
		
		
		
		
	}

}
