package com.mycompany.tiendatecnologica;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

    private String[] columnas;
    private Object[][] datos;

    public ModeloTabla(String[] columnas,Object[][] datos){
        this.columnas=columnas;
        this.datos=datos;
    }
    
    @Override
    public int getRowCount() {
        return datos.length;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        datos[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
