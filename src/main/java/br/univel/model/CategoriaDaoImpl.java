package br.univel.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDaoImpl implements CategoriaDao {

	public void inserir(Categoria c) {
		String sql = "INSERT INTO \"Categoria\"(categoria) VALUES ('"+c.getCategoria()+"');";
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}

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
		List<Categoria> list = new ArrayList<Categoria>();
		String sql = "select * from \"Categoria\" ";
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setCategoria(rs.getString("categoria"));
			    list.add(c);
			    
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
		
}
