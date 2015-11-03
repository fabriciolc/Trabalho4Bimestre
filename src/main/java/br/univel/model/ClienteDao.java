package br.univel.model;

import java.util.List;

public interface ClienteDao {
	
	public void inserir(Cliente c);
	public void atualizar(Cliente c);
	public void excluir(Cliente c);
	public Cliente buscar(int c);
	public List<Cliente> lista();
	
	
	
	

}
