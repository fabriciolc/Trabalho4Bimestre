package br.univel.model;

import java.util.List;

public interface PedidoDao {
	
	public void inserir(Pedido c);
	public void atualizar(Pedido c);
	public void excluir(Pedido c);
	public Cliente buscar(int c);
	public List<Pedido> lista();
	

}
