package br.univel.model;

import java.math.BigDecimal;

public class Pedido {

	private Cliente cliente;
	private Pedido produto;
	private BigDecimal preco;
	private int qnt;

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pedido getProduto() {
		return produto;
	}
	public void setProduto(Pedido produto) {
		this.produto = produto;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	
}
