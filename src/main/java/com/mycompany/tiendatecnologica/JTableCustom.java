package com.mycompany.tiendatecnologica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/*
    Esta clase extiende a JTable para modificar su comportamiento interno
*/

public class JTableCustom extends JTable {
    
    public JTableCustom(TableModel model) {
        super(model);
        configurarEstilo();
    }

    private void configurarEstilo() {

        this.setFont(new Font("Verdana", Font.PLAIN, 16));
        this.setRowHeight(40);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(200, 200, 200));
        headerRenderer.setForeground(Color.BLACK);
        headerRenderer.setFont(new Font("Verdana", Font.BOLD, 20));

        // Aplica el renderizador a cada columna
        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        // Configuración del renderizador de celdas
        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                // Muestra el contenido al pasar el raton
                this.setToolTipText((value != null)?value.toString():null);

                // Colores alternados para las filas
                if (row % 2 == 0) {
                    c.setBackground(new Color(117, 0, 207));
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                }
                
                // Letras en verde cuando se selecciona la fila
                if (isSelected) c.setForeground(Color.GREEN);    
                
                return c;
            }
        };

        // Aplica el renderizador a todas las columnas
        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setCellRenderer(renderizador);
        }
    }
}
