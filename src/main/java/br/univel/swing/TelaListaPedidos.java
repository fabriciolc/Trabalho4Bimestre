package br.univel.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.model.ModelTablePedido;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaPedidos extends JDialog {
	private JTable tabelaPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaListaPedidos dialog = new TelaListaPedidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregarTabela(){
		ModelTablePedido mtp = new ModelTablePedido();
		tabelaPedidos.setModel(mtp);
	}

	/**
	 * Create the dialog.
	 */
	public TelaListaPedidos() {
		setBounds(100, 100, 486, 405);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 33, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblListaDePedidos = new JLabel("Lista de Pedidos");
			lblListaDePedidos.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_lblListaDePedidos = new GridBagConstraints();
			gbc_lblListaDePedidos.insets = new Insets(0, 0, 5, 0);
			gbc_lblListaDePedidos.gridx = 0;
			gbc_lblListaDePedidos.gridy = 1;
			getContentPane().add(lblListaDePedidos, gbc_lblListaDePedidos);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 2;
			getContentPane().add(scrollPane, gbc_scrollPane);
			{
				tabelaPedidos = new JTable();
				scrollPane.setViewportView(tabelaPedidos);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 7;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton cancelButton = new JButton("Sair");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						sair();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		carregarTabela();
	}

	protected void sair() {
		this.dispose();
		
	}

}
