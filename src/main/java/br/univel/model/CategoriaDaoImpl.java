package br.univel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDaoImpl implements CategoriaDao {

	public void inserir(Categoria c) {
		String sql = "INSERT INTO....";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizar(Categoria c) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Categoria c) {
		// TODO Auto-generated method stub
		
	}

	public Cliente buscar(int c) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Categoria> lista() {
		// TODO Auto-generated method stub
		return null;
	}
		
}
