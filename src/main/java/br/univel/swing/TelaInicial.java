package br.univel.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
	
public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenu mnPedidos = new JMenu("Pedidos");
		mnMenu.add(mnPedidos);
		
		JMenuItem mntmNovoPedido = new JMenuItem("Novo Pedido");
		mntmNovoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroPedido.getInstacia().setVisible(true);
				
				
			}
		});
		mnPedidos.add(mntmNovoPedido);
		
		JMenuItem mntmListaDePedidos = new JMenuItem("Lista de Pedidos");
		mntmListaDePedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaPedidos tlp = new TelaListaPedidos();
				tlp.setVisible(true);
			}
		});
		mnPedidos.add(mntmListaDePedidos);
		
		JMenu mnNewMenu = new JMenu("Cliente");
		mnMenu.add(mnNewMenu);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroCliente.getInstacia().setVisible(true);
			}
		});
		mnNewMenu.add(mntmCadastrarCliente);
		
		JMenuItem mntmListaDeCliente = new JMenuItem("Lista de Cliente");
		mntmListaDeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaCliente.getInstancia().setVisible(true);
			}
		});
		mnNewMenu.add(mntmListaDeCliente);
		
		JMenu mnProduto = new JMenu("Produto");
		mnMenu.add(mnProduto);
		
		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar Produto");
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto.getInstancia().setVisible(true);
			}
		});
		mnProduto.add(mntmCadastrarProduto);
		
		JMenuItem mntmListaDeProdutos = new JMenuItem("Lista de Produtos");
		mntmListaDeProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaProduto tlp = new TelaListaProduto();
				tlp.setVisible(true);
			}
		});
		mnProduto.add(mntmListaDeProdutos);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmCadastrarUsuario = new JMenuItem("Cadastrar Usuario");
		mntmCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroUsuario.getInstacia().setVisible(true);
			}
		});
		mnUsuario.add(mntmCadastrarUsuario);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
