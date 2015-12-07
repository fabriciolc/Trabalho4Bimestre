package br.univel.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelTableProduto extends AbstractTableModel {
	ProdutoDaoImpl pdi = new ProdutoDaoImpl();
	List<Produto> lista = pdi.lista();
	Object[] columnNames = {"Id","Barcode","Descrição","Categoria","Custo","Preço Venda"};

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
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
			return lista.get(row).getBarcode();
		case 2:
			return lista.get(row).getDescricao();
		case 3:
			return lista.get(row).getCategoria();
		case 4:
			return lista.get(row).getCusto();
		case 5:
			return lista.get(row).getPrecovenda();

		default:
			break;
		}
		return null;
	}
	public String getColumnName(int column) {
	    return (String) columnNames[column];
	}

}
