package br.univel.model;

import java.math.BigDecimal;

public class Produto {

	private int id;
	private int barcode;
	private String descricao;
	private String categoria;
	private BigDecimal custo;
	private BigDecimal lucro;
	private BigDecimal precovenda;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public BigDecimal getLucro() {
		return lucro;
	}
	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}
	public BigDecimal getPrecovenda() {
		return precovenda;
	}
	public void setPrecovenda(BigDecimal precovenda) {
		this.precovenda = precovenda;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDescricao();
	}
	
	
	
	
	
}
