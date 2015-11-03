package br.univel.model;

import java.util.List;

public interface CategoriaDao {
	public void inserir(Categoria c);
	public void atualizar(Categoria c);
	public void excluir(Categoria c);
	public Cliente buscar(int c);
	public List<Categoria> lista();
	
}
