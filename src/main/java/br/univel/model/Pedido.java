package br.univel.model;

import java.math.BigDecimal;

public class Pedido {

	private int id;
	private Cliente cliente;
	private Produto produto;
	private BigDecimal preco;
	private int qnt;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto p) {
		this.produto = p;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cliente: "+getCliente().getId() +" Produto: "+ getProduto().getId() + " Preço: "+getPreco();
	}
	
	
}
