package br.univel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDaoImpl implements ClienteDao {
	

	@Override
	public void inserir(Cliente c) {
		String sql = "INSERT INTO \"Cliente\" (nome, telefone, endereco, cidade, email, estado, genero) VALUES ('"+c.getNome()+"', '"+c.getTelefone()+"', "
				+ "'"+c.getEndereco() +"', '"+c.getCidade()+"', '"+c.getEmail()+"', '"+c.getEstado()+"', '"+c.getGenero()+"');";
		
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
		}

		
	}


	@Override
	public void atualizar(Cliente c) {
		String sql = "UPDATE \"Cliente\" SET nome='"+c.getNome()+"', telefone='"+c.getTelefone()+"', endereco='"+c.getEndereco()+"', cidade='"+c.getCidade()+"', email='"+c.getEmail()+"', estado='"+c.getEstado()+"',genero='"+c.getGenero()+"' WHERE id="+c.getId()+";";
		System.out.println(sql);
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso");
			} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void excluir(Cliente c) {
		
		String sql = "DELETE FROM \"Cliente\" WHERE id = "+c.getId()+" ";
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
		
			
		}
		
	}

	@Override
	public Cliente buscar(int id) {
		String sql = "select * from \"Cliente\" where id = "+id+" ";
		Cliente c = new Cliente();
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome")); 
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCidade(rs.getString("cidade"));
				c.setEndereco(rs.getString("endereco"));
				c.setEstado(rs.getString("estado"));
				c.setGenero(rs.getString("genero"));
			}else{
				return null;
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
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
