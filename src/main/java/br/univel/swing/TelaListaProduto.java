package br.univel.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.model.ModelTableProduto;
import br.univel.model.Produto;
import br.univel.model.ProdutoDaoImpl;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaProduto extends JDialog {
	private JTable tabelaProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaListaProduto dialog = new TelaListaProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregarTabela(){
		ModelTableProduto mtp = new ModelTableProduto();
		tabelaProduto.setModel(mtp);
	}
	public TelaListaProduto() {
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{434, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 228, 0, 33, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			JLabel lblListaProduto = new JLabel("Lista Produto");
			lblListaProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
			GridBagConstraints gbc_lblListaProduto = new GridBagConstraints();
			gbc_lblListaProduto.insets = new Insets(0, 0, 5, 0);
			gbc_lblListaProduto.gridx = 0;
			gbc_lblListaProduto.gridy = 1;
			getContentPane().add(lblListaProduto, gbc_lblListaProduto);
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
				tabelaProduto = new JTable();
				scrollPane.setViewportView(tabelaProduto);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 4;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton btnExcluir = new JButton("Excluir");
				btnExcluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						excluir();
					}
				});
				buttonPane.add(btnExcluir);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
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

	protected void excluir() {
		ProdutoDaoImpl pdi = new ProdutoDaoImpl();
		Produto p = new Produto();
		int id = (int) tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 0);
		p.setId(id);
		pdi.excluir(p);
		carregarTabela();
		
	}

	protected void sair() {
		this.dispose();
	}

}
