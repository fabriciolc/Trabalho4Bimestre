package br.univel.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTableCliente extends AbstractTableModel{
	ClienteDaoImpl cdi = new ClienteDaoImpl();
	List<Cliente> lista = cdi.lista();
	Object[] columnNames = {"ID","Nome","Email","Endereço","Estado","Cidade","Telefone","Genero"};

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return lista.get(row).getId();
		case 1:
			return lista.get(row).getNome();
		case 2:
			return lista.get(row).getEmail();
		case 3:
			return lista.get(row).getEndereco();
		case 4:
			return lista.get(row).getEstado();
		case 5:
			return lista.get(row).getCidade();
		case 6:
			return lista.get(row).getTelefone();
		case 7:
			return lista.get(row).getGenero();
		default:
			break;
			
		}
		return null;
	}
	public String getColumnName(int column) {
	    return (String) columnNames[column];
	}

}
