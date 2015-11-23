package br.univel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {
	
	private static Connection con;

	@Override
	public void inserir(Cliente c) {
		try {
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TrabalhoJava4Bi", "postgres",
			        "univel");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO Cliente (id, nome, telefone, endereco, cidade, email, estado, genero) VALUES (1, '"+c.getNome()+"', '"+c.getTelefone()+"', "
				+ "'"+c.getEndereco() +"', '"+c.getCidade()+"', '"+c.getEmail()+"', '"+c.getEstado()+"', '"+c.getGenero()+"');";
		String sql2 = "INSERT INTO public.Cliente (id, nome) VALUES (40,'teste');";
		try {
			PreparedStatement ps = Conexao.getConnection().prepareStatement(sql2);
			ps.executeQuery();
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
		// TODO Auto-generated method stub
		return null;
	}

}
