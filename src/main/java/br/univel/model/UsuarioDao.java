package br.univel.model;

import java.util.List;

public interface UsuarioDao {
	
	public void inserir(Usuario c);
	public void atualizar(Usuario c);
	public void excluir(Usuario c);
	public Usuario buscar(int c);
	public List<Usuario> lista();
	

}
