/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendatecnologica.BBDD;

import com.mycompany.tiendatecnologica.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class ProductoDAO {
    
    // Obtiene un producto según su categoría
    public ArrayList<Producto> obtenerProductos(String categoria){
        
        ArrayList<Producto> productos=new ArrayList<>();
        try(Conexion conn=new Conexion();
            PreparedStatement ps=conn.getConn().prepareStatement("SELECT * FROM ProductoImagenes INNER JOIN Productos as p ON ProductoImagenes.producto_id=p.id INNER JOIN Categorias ON p.categoria_id=Categorias.id WHERE Categorias.nombre=? ORDER BY imagen")){
            
            ps.setString(1,categoria);
            
            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){ 
                    // se obtiene la primera imagen y se pasa a la siguiente tupla
                    // la sentencia tiene un order by de imagen y todos los productos tienen
                    // dos imagenes, por lo tanto esto es viable
                    String img=rs.getString("imagen"); 
                    rs.next(); 
                    productos.add(new Producto(
                            rs.getInt("p.id"),
                            rs.getInt("categoria_id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getString("descripcion"),
                            rs.getString("caracteristicas"),
                            rs.getInt("inventario"),
                            new ArrayList<>(Arrays.asList(img, rs.getString("imagen"))
                    )));  
                }
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }  
    
    public int getStock(int id){
        
        try(Conexion conn=new Conexion();
            PreparedStatement ps=conn.getConn().prepareStatement("SELECT inventario FROM Productos WHERE id=?")){
            
            ps.setInt(1,id);
            
            try(ResultSet rs=ps.executeQuery()){
                rs.next();
                
                return rs.getInt(1); 
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    } 
    
    public void bajarStock(int id,int nuevoStock){
        
        try(Conexion conn=new Conexion();
            PreparedStatement ps=conn.getConn().prepareStatement("UPDATE Productos SET inventario=? WHERE id=?")){
            
            ps.setInt(1,nuevoStock);
            ps.setInt(2,id);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
