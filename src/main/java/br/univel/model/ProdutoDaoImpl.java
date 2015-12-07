package br.univel.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDaoImpl implements ProdutoDao {

	@Override
	public void inserir(Produto c) {
		String sql = "INSERT INTO \"Produto\" (barcode, descricao, categoria, custo, precovenda)VALUES ("+c.getBarcode()+", '"+c.getDescricao()+"', '"+c.getCategoria()+"', "+c.getCusto()+", "+c.getPrecovenda()+");";
		try {
			try {
				PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void atualizar(Produto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Produto c) {
		String sql = "DELETE FROM \"Produto\" WHERE id = "+c.getId()+";";
		try {
			try {
				PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Cliente buscar(int c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> lista() {
		List<Produto> list = new ArrayList<Produto>();
		String sql = "select * from \"Produto\" ";
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setBarcode(rs.getInt("barcode"));
				p.setDescricao(rs.getString("descricao")); 
				p.setCategoria(rs.getString("categoria"));
				p.setCusto(rs.getBigDecimal("custo"));
				p.setPrecovenda(rs.getBigDecimal("precovenda"));
			    list.add(p);
			    
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
