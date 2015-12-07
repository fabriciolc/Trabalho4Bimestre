package br.univel.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.univel.model.Cliente;
import br.univel.model.ClienteDao;
import br.univel.model.ClienteDaoImpl;
import br.univel.model.ModelTableCliente;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable tabelaCliente;
	private static ModelTableCliente mtc = new ModelTableCliente();
	private static TelaListaCliente instacia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaListaCliente dialog = new TelaListaCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static TelaListaCliente getInstancia(){
		if(instacia == null)
			return instacia = new TelaListaCliente();
		return instacia;
	}

	private void carregarTable(){
		
		tabelaCliente.setModel(mtc);
	}
	
	public TelaListaCliente() {
		setBounds(100, 100, 458, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 304, 0, 0, 43, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 2;
			gbc_scrollPane.gridwidth = 5;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 1;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				tabelaCliente = new JTable();
				scrollPane.setViewportView(tabelaCliente);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						buscar();
					}
				});
				{
					JButton btnExcluir = new JButton("Excluir");
					btnExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							excluir();
						}
					});
					{
						JButton btnAtualizar = new JButton("Atualizar");
						btnAtualizar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								atualizarTabela();
							}
						});
						buttonPane.add(btnAtualizar);
					}
					buttonPane.add(btnExcluir);
				}
				{
					JButton btnNewButton = new JButton("Editar");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							TelaEditarCliente tec = new TelaEditarCliente();
							tec.setVisible(true);
							System.out.println("teste");
						}
					});
					buttonPane.add(btnNewButton);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnSair = new JButton("Sair");
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sair();
					}
				});
				btnSair.setActionCommand("Cancel");
				buttonPane.add(btnSair);
			}
		}
		carregarTable();
	}

	protected void sair() {
		this.dispose();
		
	}

	protected static void atualizarTabela() {
		mtc = new ModelTableCliente();
		tabelaCliente.setModel(mtc);
		
		
		
	}

	protected void excluir() {
		Cliente c = new Cliente();
		if(buscar() > 0){
			c.setId(buscar());
			ClienteDaoImpl cdi = new ClienteDaoImpl();
			cdi.excluir(c);
		}
		atualizarTabela();
		
		
		
	}

	protected int buscar() {
		if(tabelaCliente.getSelectedRow() == -1){
			JOptionPane.showMessageDialog(null, "Selecione alguem cliente na tabela");
			return -1;
		}
		return (int)tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 0);
		
	}

}
