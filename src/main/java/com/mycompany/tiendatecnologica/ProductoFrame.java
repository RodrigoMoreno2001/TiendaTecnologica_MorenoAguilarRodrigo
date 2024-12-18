package com.mycompany.tiendatecnologica;

import com.mycompany.tiendatecnologica.BBDD.Conexion;
import com.mycompany.tiendatecnologica.BBDD.ProductoDAO;
import java.awt.Image;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProductoFrame extends javax.swing.JFrame {
    
    private JFrame anteriorFrame; // guarda el estado del frame de Productos
    private int idProducto; // guarda producto, para hacer compras
    
    public ProductoFrame(Producto producto, JFrame frame) {
        initComponents();

        ImageIcon img1=new ImageIcon(getClass().getResource("/"+producto.getImagenes().get(0)));
        Image img1Ajustada = img1.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH);
        img1=new ImageIcon(img1Ajustada);
        imagen.setIcon(img1);
        
        ImageIcon img2=new ImageIcon(getClass().getResource("/"+producto.getImagenes().get(1)));
        Image img2Ajustada = img2.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH);
        img2=new ImageIcon(img2Ajustada);
        imagen2.setIcon(img2);
        
        nombreProducto.setText(producto.getNombre());
        
        precioProducto.setText("Precio: "+String.valueOf(producto.getPrecio())+"€");
        
        descripcionProducto.setText("Descripción:\n\n"+producto.getDescripcion()+"\n\nCaracterísticas: \n\n   - "+producto.getCaracteristicas().replaceAll(",","\n   -"));

        inventarioProducto.setText("Stock: "+String.valueOf(producto.getInventario()));
        
        setLocationRelativeTo(frame);
        anteriorFrame=frame;
        idProducto=producto.getId();
        
        descripcionProducto.setFocusable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        imagen = new javax.swing.JLabel();
        imagen2 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionProducto = new javax.swing.JTextArea();
        precioProducto = new javax.swing.JLabel();
        inventarioProducto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cantidadProducto = new javax.swing.JTextField();
        botonRealizarCompra = new BorderRadius("", 20);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));

        jLabel3.setBackground(new java.awt.Color(120, 13, 201));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(120, 13, 201));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Productos");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/volver.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 110));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        nombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nombreProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreProducto.setText("jLabel2");

        descripcionProducto.setColumns(20);
        descripcionProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descripcionProducto.setRows(5);
        descripcionProducto.setEditable(false);
        descripcionProducto.setBorder(null);
        jScrollPane1.setViewportView(descripcionProducto);
        jScrollPane1.setBorder(null);

        precioProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        precioProducto.setText("jLabel5");

        inventarioProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inventarioProducto.setText("jLabel5");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(120, 13, 201));
        jLabel7.setText("ID_Usuario:");

        idUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUsuarioActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(120, 13, 201));
        jLabel8.setText("Cantidad:");

        botonRealizarCompra.setBackground(new java.awt.Color(137, 56, 199));
        botonRealizarCompra.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        botonRealizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        botonRealizarCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonRealizarCompra.setText("Realizar compra");
        botonRealizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRealizarCompraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nombreProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(precioProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(216, 216, 216))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(322, 322, 322)
                                        .addComponent(inventarioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonRealizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precioProducto)
                            .addComponent(inventarioProducto))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(idUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRealizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1240, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JFrame frame=anteriorFrame;
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void idUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUsuarioActionPerformed

    private void botonRealizarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRealizarCompraMouseClicked
        
        int cantidadProducto;
        int idUsuario; 
        
        ProductoDAO pdao=new ProductoDAO();
        int stock=pdao.getStock(idProducto);
        
        try{
            cantidadProducto=Integer.parseInt(this.cantidadProducto.getText());
            idUsuario=Integer.parseInt(this.idUsuario.getText());  
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"La cantidad y el id deben ser números enteros","Error de formato",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(stock<cantidadProducto){
            JOptionPane.showMessageDialog(this,"La cantidad excede las existencias","Operacion fallida",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int nuevoStock=stock-cantidadProducto;
        
        pdao.bajarStock(idProducto,nuevoStock);
        
        inventarioProducto.setText("Stock: "+String.valueOf(nuevoStock));
        
        try(Conexion conn=new Conexion();
            PreparedStatement ps=conn.getConn().prepareStatement("INSERT INTO HistorialCompras(usuario_id, producto_id, cantidad, fecha) VALUES (?,?,?,?)")){
            ps.setInt(1,idUsuario);
            ps.setInt(2,idProducto);
            ps.setInt(3,cantidadProducto);
            ps.setDate(4,Date.valueOf(LocalDate.now()));
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this,"Compra realizada con éxito...", "Operacion completada",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonRealizarCompraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonRealizarCompra;
    private javax.swing.JTextField cantidadProducto;
    private javax.swing.JTextArea descripcionProducto;
    private javax.swing.JTextField idUsuario;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel imagen2;
    private javax.swing.JLabel inventarioProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreProducto;
    private javax.swing.JLabel precioProducto;
    // End of variables declaration//GEN-END:variables
}
