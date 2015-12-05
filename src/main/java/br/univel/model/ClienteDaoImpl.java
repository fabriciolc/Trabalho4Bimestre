package br.univel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {
	

	@Override
	public void inserir(Cliente c) {
		String sql = "INSERT INTO \"Cliente\" (nome, telefone, endereco, cidade, email, estado, genero) VALUES ("+c.getNome()+"', '"+c.getTelefone()+"', "
				+ "'"+c.getEndereco() +"', '"+c.getCidade()+"', '"+c.getEmail()+"', '"+c.getEstado()+"', '"+c.getGenero()+"');";
		System.out.println(c.getEstado()+" "+c.getGenero());
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	@Override
	public void atualizar(Cliente c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Cliente c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscar(int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> lista() {
		List<Cliente> list = new ArrayList<Cliente>();
		String sql = "select * from \"Cliente\" ";
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome")); 
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCidade(rs.getString("cidade"));
				c.setEndereco(rs.getString("endereco"));
				c.setEstado(rs.getString("estado"));
				c.setGenero(rs.getString("genero"));
			    list.add(c);
			    
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
