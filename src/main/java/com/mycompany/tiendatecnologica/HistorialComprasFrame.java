/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tiendatecnologica;

import com.mycompany.tiendatecnologica.BBDD.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author alumno
 */
public class HistorialComprasFrame extends javax.swing.JFrame {

    private ModeloTabla model;
    
    public HistorialComprasFrame(JFrame frame) {
        model=new ModeloTabla(new String[]{"ID","usuario_id","producto_id","cantidad","fecha"},cargarDatos());
        initComponents();
        setLocationRelativeTo(frame);
    }
    
    private Object[][] cargarDatos(){
         Object[][] datos=null;
        try(Conexion conn=new Conexion();
            Statement consulta=conn.getConn().createStatement()){
            
                try(ResultSet rs=consulta.executeQuery("SELECT count(id) FROM HistorialCompras")){
                    rs.next();
                    int numeroTuplas=rs.getInt(1);
                    datos=new Object[numeroTuplas][5];
                }
                
                try(ResultSet rs=consulta.executeQuery("SELECT * FROM HistorialCompras")){
                    int cont=0;
                    while (rs.next()) {
                        datos[cont][0] = rs.getInt("id");
                        datos[cont][1] = rs.getInt("usuario_id");
                        datos[cont][2] = rs.getInt("producto_id");
                        datos[cont][3] = rs.getInt("cantidad");
                        datos[cont][4] = rs.getDate("fecha").toString();
                        cont++;
                    }
                }        
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       return datos; 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTableCustom(model);
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/volver.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 30, -1, 45));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(120, 13, 201));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Historial de Compras");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 0, 898, 110));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 128, 870, 270));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        FramePrincipal fp=new FramePrincipal(this);
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
