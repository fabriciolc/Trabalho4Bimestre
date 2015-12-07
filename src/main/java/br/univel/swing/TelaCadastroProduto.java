package br.univel.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.model.Categoria;
import br.univel.model.CategoriaDaoImpl;
import br.univel.model.Cliente;
import br.univel.model.ClienteDaoImpl;
import br.univel.model.Produto;
import br.univel.model.ProdutoDaoImpl;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCadastroProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static TelaCadastroProduto instancia;
	private JTextField text_barcode;
	private JTextField text_descricao;
	private JTextField text_custo;
	private JTextField text_precovenda;
	private JComboBox cmb_categoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroProduto dialog = new TelaCadastroProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static TelaCadastroProduto getInstancia(){
		if(instancia == null)
			return instancia = new TelaCadastroProduto();
		return instancia;
	}
	public void carregarCmb(){
		CategoriaDaoImpl cdi = new CategoriaDaoImpl();
		List<Categoria> lista = cdi.lista();
		for (int i = 0; i < lista.size(); i++) {
			Categoria c = lista.get(i);
			cmb_categoria.addItem(c);
		}

		
	}
	
	public TelaCadastroProduto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{59, 160, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblBarcode = new JLabel("Barcode");
			GridBagConstraints gbc_lblBarcode = new GridBagConstraints();
			gbc_lblBarcode.anchor = GridBagConstraints.EAST;
			gbc_lblBarcode.insets = new Insets(0, 0, 5, 5);
			gbc_lblBarcode.gridx = 0;
			gbc_lblBarcode.gridy = 1;
			contentPanel.add(lblBarcode, gbc_lblBarcode);
		}
		{
			text_barcode = new JTextField();
			GridBagConstraints gbc_text_barcode = new GridBagConstraints();
			gbc_text_barcode.insets = new Insets(0, 0, 5, 5);
			gbc_text_barcode.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_barcode.gridx = 1;
			gbc_text_barcode.gridy = 1;
			contentPanel.add(text_barcode, gbc_text_barcode);
			text_barcode.setColumns(10);
		}
		{
			JLabel lblCategoria = new JLabel("Categoria");
			GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
			gbc_lblCategoria.anchor = GridBagConstraints.EAST;
			gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategoria.gridx = 3;
			gbc_lblCategoria.gridy = 1;
			contentPanel.add(lblCategoria, gbc_lblCategoria);
		}
		{
			cmb_categoria = new JComboBox();
			GridBagConstraints gbc_cmb_categoria = new GridBagConstraints();
			gbc_cmb_categoria.insets = new Insets(0, 0, 5, 0);
			gbc_cmb_categoria.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmb_categoria.gridx = 4;
			gbc_cmb_categoria.gridy = 1;
			contentPanel.add(cmb_categoria, gbc_cmb_categoria);
		}
		{
			JLabel lblDescrico = new JLabel("Descri\u00E7\u00E3o");
			GridBagConstraints gbc_lblDescrico = new GridBagConstraints();
			gbc_lblDescrico.anchor = GridBagConstraints.EAST;
			gbc_lblDescrico.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescrico.gridx = 0;
			gbc_lblDescrico.gridy = 2;
			contentPanel.add(lblDescrico, gbc_lblDescrico);
		}
		{
			text_descricao = new JTextField();
			GridBagConstraints gbc_text_descricao = new GridBagConstraints();
			gbc_text_descricao.insets = new Insets(0, 0, 5, 5);
			gbc_text_descricao.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_descricao.gridx = 1;
			gbc_text_descricao.gridy = 2;
			contentPanel.add(text_descricao, gbc_text_descricao);
			text_descricao.setColumns(10);
		}
		{
			JLabel lblCusto = new JLabel("Custo");
			GridBagConstraints gbc_lblCusto = new GridBagConstraints();
			gbc_lblCusto.anchor = GridBagConstraints.EAST;
			gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
			gbc_lblCusto.gridx = 0;
			gbc_lblCusto.gridy = 3;
			contentPanel.add(lblCusto, gbc_lblCusto);
		}
		{
			text_custo = new JTextField();
			GridBagConstraints gbc_text_custo = new GridBagConstraints();
			gbc_text_custo.insets = new Insets(0, 0, 5, 5);
			gbc_text_custo.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_custo.gridx = 1;
			gbc_text_custo.gridy = 3;
			contentPanel.add(text_custo, gbc_text_custo);
			text_custo.setColumns(10);
		}
		{
			JLabel lblPreoVenda = new JLabel("Pre\u00E7o Venda");
			GridBagConstraints gbc_lblPreoVenda = new GridBagConstraints();
			gbc_lblPreoVenda.anchor = GridBagConstraints.EAST;
			gbc_lblPreoVenda.insets = new Insets(0, 0, 0, 5);
			gbc_lblPreoVenda.gridx = 0;
			gbc_lblPreoVenda.gridy = 4;
			contentPanel.add(lblPreoVenda, gbc_lblPreoVenda);
		}
		{
			text_precovenda = new JTextField();
			GridBagConstraints gbc_text_precovenda = new GridBagConstraints();
			gbc_text_precovenda.insets = new Insets(0, 0, 0, 5);
			gbc_text_precovenda.fill = GridBagConstraints.HORIZONTAL;
			gbc_text_precovenda.gridx = 1;
			gbc_text_precovenda.gridy = 4;
			contentPanel.add(text_precovenda, gbc_text_precovenda);
			text_precovenda.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
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
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		carregarCmb();
	}
	protected void salvar() {
		try {
			ProdutoDaoImpl pdi = new ProdutoDaoImpl();
			Produto p = new Produto();
			p.setBarcode(Integer.parseInt(text_barcode.getText()));
			p.setDescricao(text_descricao.getText());
			BigDecimal custo = new BigDecimal(text_custo.getText().replaceAll(",", ""));
			p.setCusto(custo);
			BigDecimal precovenda = new BigDecimal(text_precovenda.getText().replaceAll(",", ""));
			p.setPrecovenda(precovenda);
			p.setCategoria(cmb_categoria.getSelectedItem().toString());
			pdi.inserir(p);
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
			limpar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}
	private void limpar() {
		text_barcode.setText("");
		text_custo.setText("");
		text_descricao.setText("");
		text_precovenda.setText("");
		
	}

}
