package br.univel.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao{

	@Override
	public void inserir(Usuario c) {
		
		try {
			String sql = "INSERT INTO \"Usuario\"(id_cliente, senha) VALUES ("+c.getId_cliente()+", "+c.getSenha()+");";
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ps.executeQuery();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Usuario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Usuario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscar(int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> lista() {
		// TODO Auto-generated method stub
		return null;
	}

}
