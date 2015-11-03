package br.univel.model;

import java.util.List;

public interface ProdutoDao {
	
	public void inserir(Produto c);
	public void atualizar(Produto c);
	public void excluir(Produto c);
	public Cliente buscar(int c);
	public List<Produto> lista();
}
