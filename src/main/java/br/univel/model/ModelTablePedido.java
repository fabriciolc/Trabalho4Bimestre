package br.univel.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTablePedido extends AbstractTableModel {
	PedidoDaoImpl pdi = new  PedidoDaoImpl();
	List<Pedido> lista = pdi.lista();
	Object[] columnNames = {"id_pedido","id_cliente","id_produto","quantidade","Preço"};

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
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
			return lista.get(row).getCliente().getId();			
		case 2:
			return lista.get(row).getProduto().getId();
		case 3:
			return lista.get(row).getQnt();
		case 4:
			return lista.get(row).getPreco();		
		default:
			break;
		}
		return null;
	}
	public String getColumnName(int column) {
	    return (String) columnNames[column];
	}

}
