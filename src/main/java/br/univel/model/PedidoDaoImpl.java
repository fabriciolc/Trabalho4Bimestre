package br.univel.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDaoImpl implements PedidoDao {

	@Override
	public void inserir(Pedido c) {
		String sql = "INSERT INTO \"Pedido\"(id, id_cliente, preco, quantidade, id_produto) VALUES ("+c.getId()+", "+c.getCliente().getId()+", "+c.getPreco()+", "+c.getQnt()+","+c.getProduto().getId()+");";
		try {
			try {
				PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
				ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void atualizar(Pedido c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Pedido c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscar(int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> lista() {
		List<Pedido> list = new ArrayList<Pedido>();
		String sql = "select * from \"Pedido\" ";
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Pedido p = new Pedido();
				Cliente c = new Cliente();
				Produto pr = new Produto();

				pr.setId(rs.getInt("id_produto"));
				c.setId(rs.getInt("id_cliente"));
				
				p.setId(rs.getInt("id"));
				p.setCliente(c);
				p.setPreco(rs.getBigDecimal("preco"));
				p.setProduto(pr);
				p.setQnt(rs.getInt("quantidade"));
				
				list.add(p);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int ultimoID(){
		String sql = "SELECT id FROM \"Pedido\" order by id desc limit 1";
		int id ;
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = (rs.getInt("id"));
				return id;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;

	}

}
