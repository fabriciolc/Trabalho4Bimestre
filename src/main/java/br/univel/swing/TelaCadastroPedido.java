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
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JList;

public class TelaCadastroPedido extends JDialog {

	private final JPanel contentPanel = new JPanel();

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

	/**
	 * Create the dialog.
	 */
	public TelaCadastroPedido() {
		setBounds(100, 100, 457, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 115, 58, 115, 56, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 10, 36, 0, 0, 35, 14, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCliente = new JLabel("Cliente");
			GridBagConstraints gbc_lblCliente = new GridBagConstraints();
			gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblCliente.anchor = GridBagConstraints.EAST;
			gbc_lblCliente.gridx = 1;
			gbc_lblCliente.gridy = 0;
			contentPanel.add(lblCliente, gbc_lblCliente);
		}
		{
			JComboBox comboBox = new JComboBox();
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 0;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblProdut = new JLabel("Produtos");
			GridBagConstraints gbc_lblProdut = new GridBagConstraints();
			gbc_lblProdut.anchor = GridBagConstraints.NORTH;
			gbc_lblProdut.insets = new Insets(0, 0, 5, 5);
			gbc_lblProdut.gridx = 1;
			gbc_lblProdut.gridy = 2;
			contentPanel.add(lblProdut, gbc_lblProdut);
		}
		{
			JList list_produtos = new JList();
			GridBagConstraints gbc_list_produtos = new GridBagConstraints();
			gbc_list_produtos.gridheight = 4;
			gbc_list_produtos.insets = new Insets(0, 0, 5, 5);
			gbc_list_produtos.fill = GridBagConstraints.BOTH;
			gbc_list_produtos.gridx = 2;
			gbc_list_produtos.gridy = 2;
			contentPanel.add(list_produtos, gbc_list_produtos);
		}
		{
			JButton btn_addall = new JButton(">>");
			GridBagConstraints gbc_btn_addall = new GridBagConstraints();
			gbc_btn_addall.fill = GridBagConstraints.HORIZONTAL;
			gbc_btn_addall.insets = new Insets(0, 0, 5, 5);
			gbc_btn_addall.gridx = 3;
			gbc_btn_addall.gridy = 2;
			contentPanel.add(btn_addall, gbc_btn_addall);
		}
		{
			JList list_produtosp = new JList();
			GridBagConstraints gbc_list_produtosp = new GridBagConstraints();
			gbc_list_produtosp.gridheight = 4;
			gbc_list_produtosp.insets = new Insets(0, 0, 5, 5);
			gbc_list_produtosp.fill = GridBagConstraints.BOTH;
			gbc_list_produtosp.gridx = 4;
			gbc_list_produtosp.gridy = 2;
			contentPanel.add(list_produtosp, gbc_list_produtosp);
		}
		{
			JButton button = new JButton(">");
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.HORIZONTAL;
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 3;
			gbc_button.gridy = 3;
			contentPanel.add(button, gbc_button);
		}
		{
			JButton button = new JButton("<");
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.HORIZONTAL;
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 3;
			gbc_button.gridy = 4;
			contentPanel.add(button, gbc_button);
		}
		{
			JButton button = new JButton("<<");
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.fill = GridBagConstraints.HORIZONTAL;
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 3;
			gbc_button.gridy = 5;
			contentPanel.add(button, gbc_button);
		}
		{
			JLabel lblPreoo = new JLabel("Total: ");
			GridBagConstraints gbc_lblPreoo = new GridBagConstraints();
			gbc_lblPreoo.anchor = GridBagConstraints.EAST;
			gbc_lblPreoo.insets = new Insets(0, 0, 5, 5);
			gbc_lblPreoo.gridx = 4;
			gbc_lblPreoo.gridy = 6;
			contentPanel.add(lblPreoo, gbc_lblPreoo);
		}
		{
			JLabel lb_preço = new JLabel("R$ 0,00");
			GridBagConstraints gbc_lb_preço = new GridBagConstraints();
			gbc_lb_preço.anchor = GridBagConstraints.WEST;
			gbc_lb_preço.insets = new Insets(0, 0, 5, 0);
			gbc_lb_preço.gridx = 5;
			gbc_lb_preço.gridy = 6;
			contentPanel.add(lb_preço, gbc_lb_preço);
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
	}

}
