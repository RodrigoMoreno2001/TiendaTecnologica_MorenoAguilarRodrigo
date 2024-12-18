package com.mycompany.tiendatecnologica;

import com.mycompany.tiendatecnologica.BBDD.Json;
import com.mycompany.tiendatecnologica.BBDD.ProductoDAO;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProductosFrame extends javax.swing.JFrame {

    private JLabel[] imagenesLabel;
    private JLabel[] nombresLabel;
    private JLabel[] preciosLabel;
    private ArrayList<Producto> productos;
    
    
    public ProductosFrame(JFrame frame) {
        initComponents();
        setLocationRelativeTo(frame);
        setResizable(false);
        
        imagenesLabel=new JLabel[]{img1,img2,img3};
        nombresLabel=new JLabel[]{nombre1,nombre2,nombre3};
        preciosLabel=new JLabel[]{precio1,precio2,precio3};
        
        mostrarProductos(new ProductoDAO().obtenerProductos("Ropa"));
        
        Json json=new Json();
        if(!json.hayDatos()){
            json.crearJson();
            json.volcarDatos();  
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        botonBuscar = new BorderRadius("",20);
        img3 = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        precio1 = new javax.swing.JLabel();
        nombre1 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JLabel();
        precio2 = new javax.swing.JLabel();
        nombre3 = new javax.swing.JLabel();
        precio3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/volver.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(120, 13, 201));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 110));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(120, 13, 201));
        jLabel2.setText("Categoría:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        jTextField1.setBackground(new java.awt.Color(200, 200, 200));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 150, 30));

        botonBuscar.setBackground(new java.awt.Color(120, 13, 201));
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonBuscar.setText("ir");
        botonBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBuscarMouseClicked(evt);
            }
        });
        jPanel1.add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 30, 30));

        img3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img3MouseClicked(evt);
            }
        });
        jPanel1.add(img3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 240, 300));

        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img1MouseClicked(evt);
            }
        });
        jPanel1.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 240, 300));

        img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img2MouseClicked(evt);
            }
        });
        jPanel1.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 240, 300));

        precio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 240, -1));

        nombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 240, -1));

        nombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 240, -1));

        precio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(precio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 240, -1));

        nombre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, 240, -1));

        precio3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(precio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarMouseClicked
        String categoria=jTextField1.getText();
        
        if(!(categoria.equalsIgnoreCase("Hogar")||categoria.equalsIgnoreCase("Electrónica")||categoria.equalsIgnoreCase("Ropa")||categoria.equalsIgnoreCase("Electronica"))){
            JOptionPane.showMessageDialog(this,"Las categorías disponibles son: Hogar, Electrónica, Ropa","Categoría incorrecta",JOptionPane.INFORMATION_MESSAGE);
            return;  
        }
        ArrayList<Producto> productos=new ProductoDAO().obtenerProductos(categoria);
        if(productos.isEmpty()) return;
        mostrarProductos(productos);   
    }//GEN-LAST:event_botonBuscarMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        FramePrincipal fp=new FramePrincipal(this);
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void img1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img1MouseClicked
        abrirProducto(0);
    }//GEN-LAST:event_img1MouseClicked

    private void img2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img2MouseClicked
        abrirProducto(1);
    }//GEN-LAST:event_img2MouseClicked

    private void img3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img3MouseClicked
        abrirProducto(2);
    }//GEN-LAST:event_img3MouseClicked

    private void abrirProducto(int indice){
        if(productos==null) return;       
        ProductoFrame pf=new ProductoFrame(productos.get(indice),this);
        pf.setVisible(true);
        this.dispose();
    }
    
    private void mostrarProductos(ArrayList <Producto> productos){  
        this.productos=new ArrayList<>();
        for(int i=0;i<imagenesLabel.length;i++){      
            Producto producto=productos.get(i);
            
            String img=producto.getImagenes().get(0);
            ImageIcon imagen = new ImageIcon(getClass().getResource("/"+img));
            Image imagenAjustada = imagen.getImage().getScaledInstance(img1.getWidth(), img1.getHeight(), Image.SCALE_SMOOTH);
            imagen=new ImageIcon(imagenAjustada);
            imagenesLabel[i].setIcon(imagen);
            nombresLabel[i].setText(producto.getNombre());
            preciosLabel[i].setText(String.valueOf(producto.getPrecio())+"€");
            this.productos.add(producto);
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonBuscar;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel nombre1;
    private javax.swing.JLabel nombre2;
    private javax.swing.JLabel nombre3;
    private javax.swing.JLabel precio1;
    private javax.swing.JLabel precio2;
    private javax.swing.JLabel precio3;
    // End of variables declaration//GEN-END:variables
}
