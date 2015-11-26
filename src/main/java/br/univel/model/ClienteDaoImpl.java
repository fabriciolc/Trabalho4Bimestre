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
		String sql = "INSERT INTO \"Cliente\" (id, nome, telefone, endereco, cidade, email, estado, genero) VALUES ("+c.getId()+", '"+c.getNome()+"', '"+c.getTelefone()+"', "
				+ "'"+c.getEndereco() +"', '"+c.getCidade()+"', '"+c.getEmail()+"', '"+c.getEstado()+"', '"+c.getGenero()+"');";
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
				System.out.println(rs.getInt("id"));
				c.setNome(rs.getString("nome")); 
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCidade(rs.getString("cidade"));
				c.setEndereco(rs.getString("endereco"));
			    list.add(c);
			    
			}
		System.out.println(list.get(0).getId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
