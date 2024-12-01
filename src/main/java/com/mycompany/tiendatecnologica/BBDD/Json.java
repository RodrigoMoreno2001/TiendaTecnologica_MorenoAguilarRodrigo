
package com.mycompany.tiendatecnologica.BBDD;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {
    
    public void volcarDatos() {
        JSONParser jsonparser = new JSONParser();
        try (FileReader reader = new FileReader("tienda.json");
             Conexion conn = new Conexion()) {

            Object obj = jsonparser.parse(reader);
            JSONObject tiendas = (JSONObject) obj;
            JSONObject tienda = (JSONObject) tiendas.get("tienda");

            JSONArray categorias = (JSONArray) tienda.get("categorias");
            for (Object catObj : categorias) {
                JSONObject categoria = (JSONObject) catObj;
                int categoriaId = ((Long) categoria.get("id")).intValue();
                String nombreCategoria = (String) categoria.get("nombre");

                String insertCategoriaSQL = "INSERT INTO Categorias (id, nombre) VALUES (?, ?)";
                try (PreparedStatement ps = conn.getConn().prepareStatement(insertCategoriaSQL)) {
                    ps.setInt(1, categoriaId);
                    ps.setString(2, nombreCategoria);
                    ps.executeUpdate();
                }

                JSONArray productos = (JSONArray) categoria.get("productos");
                for (Object prodObj : productos) {
                    JSONObject producto = (JSONObject) prodObj;
                    int productoId = ((Long) producto.get("id")).intValue();
                    String nombreProducto = (String) producto.get("nombre");
                    double precio = (double) producto.get("precio");
                    String descripcion = (String) producto.get("descripcion");
                    String caracteristicas = producto.get("caracteristicas").toString();
                    
                    int inventario = ((Long) producto.get("inventario")).intValue();
                    String insertProductoSQL = "INSERT INTO Productos (id, categoria_id, nombre, precio, descripcion, caracteristicas, inventario) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement ps = conn.getConn().prepareStatement(insertProductoSQL)) {
                        ps.setInt(1, productoId);
                        ps.setInt(2, categoriaId);
                        ps.setString(3, nombreProducto);
                        ps.setDouble(4, precio);
                        ps.setString(5, descripcion);
                        ps.setString(6, caracteristicas);
                        ps.setInt(7, inventario);
                        ps.executeUpdate();
                    }

                    // Insertar imágenes del producto
                    JSONArray imagenes = (JSONArray) producto.get("imagenes");
                    String insertImagenSQL = "INSERT INTO ProductoImagenes (producto_id, imagen) VALUES (?, ?)";
                    for (Object imgObj : imagenes) {
                        String imagen = (String) imgObj;
                        try (var imgStmt = conn.getConn().prepareStatement(insertImagenSQL)) {
                            imgStmt.setInt(1, productoId);
                            imgStmt.setString(2, imagen);
                            imgStmt.executeUpdate();
                        }
                    }
                }
            }

            // Insertar usuarios
            JSONArray usuarios = (JSONArray) tienda.get("usuarios");
            String insertUsuarioSQL = """
                INSERT INTO Usuarios 
                (id, nombre, email, direccion_calle, direccion_numero, direccion_ciudad, direccion_pais)
                VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
            for (Object userObj : usuarios) {
                JSONObject usuario = (JSONObject) userObj;
                int usuarioId = ((Long) usuario.get("id")).intValue();
                String nombreUsuario = (String) usuario.get("nombre");
                String email = (String) usuario.get("email");
                JSONObject direccion = (JSONObject) usuario.get("direccion");
                String calle = (String) direccion.get("calle");
                int numero = ((Long) direccion.get("numero")).intValue();
                String ciudad = (String) direccion.get("ciudad");
                String pais = (String) direccion.get("pais");

                try (PreparedStatement userStmt = conn.getConn().prepareStatement(insertUsuarioSQL)) {
                    userStmt.setInt(1, usuarioId);
                    userStmt.setString(2, nombreUsuario);
                    userStmt.setString(3, email);
                    userStmt.setString(4, calle);
                    userStmt.setInt(5, numero);
                    userStmt.setString(6, ciudad);
                    userStmt.setString(7, pais);
                    userStmt.executeUpdate();
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException | SQLException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearJson(){
        JSONObject tienda = new JSONObject();
        tienda.put("nombre", "Mi tienda online");
        JSONArray arrCategorias = new JSONArray();

        // Crear categoría 1
        JSONObject categoria1 = new JSONObject();
        categoria1.put("id", 1);
        categoria1.put("nombre", "Electrónica");
        JSONArray arrProductos1 = new JSONArray();

        JSONObject producto1_1 = new JSONObject();
        producto1_1.put("id", 101);
        producto1_1.put("nombre", "Smartphone");
        producto1_1.put("precio", 999.99);
        producto1_1.put("descripcion", "El último smartphone del mercado.");
        producto1_1.put("caracteristicas", "Pantalla: 6.5 pulgadas, Cámara: 48 MP, Batería: 4500 mAh");
        JSONArray arrImg1_1 = new JSONArray();
        arrImg1_1.add("imagen1.png");
        arrImg1_1.add("imagen2.png");
        producto1_1.put("imagenes", arrImg1_1);
        producto1_1.put("inventario", 10);
        arrProductos1.add(producto1_1);

        JSONObject producto1_2 = new JSONObject();
        producto1_2.put("id", 102);
        producto1_2.put("nombre", "Tablet");
        producto1_2.put("precio", 499.99);
        producto1_2.put("descripcion", "Tablet de alto rendimiento.");
        producto1_2.put("caracteristicas", "Pantalla: 10 pulgadas, Almacenamiento: 128 GB, Batería: 6000 mAh");
        JSONArray arrImg1_2 = new JSONArray();
        arrImg1_2.add("tablet1.png");
        arrImg1_2.add("tablet2.png");
        producto1_2.put("imagenes", arrImg1_2);
        producto1_2.put("inventario", 15);
        arrProductos1.add(producto1_2);

        JSONObject producto1_3 = new JSONObject();
        producto1_3.put("id", 103);
        producto1_3.put("nombre", "Laptop");
        producto1_3.put("precio", 1299.99);
        producto1_3.put("descripcion", "Laptop ultraligera con gran potencia.");
        producto1_3.put("caracteristicas", "Procesador: Intel Core i7, RAM: 16 GB, Almacenamiento: 512 GB SSD");
        JSONArray arrImg1_3 = new JSONArray();
        arrImg1_3.add("laptop1.png");
        arrImg1_3.add("laptop2.png");
        producto1_3.put("imagenes", arrImg1_3);
        producto1_3.put("inventario", 5);
        arrProductos1.add(producto1_3);

        categoria1.put("productos", arrProductos1);
        arrCategorias.add(categoria1);

        // Crear categoría 2
        JSONObject categoria2 = new JSONObject();
        categoria2.put("id", 2);
        categoria2.put("nombre", "Ropa");
        JSONArray arrProductos2 = new JSONArray();

        JSONObject producto2_1 = new JSONObject();
        producto2_1.put("id", 201);
        producto2_1.put("nombre", "Camiseta");
        producto2_1.put("precio", 19.99);
        producto2_1.put("descripcion", "Camiseta de algodón de alta calidad.");
        producto2_1.put("caracteristicas", "Material: Algodón, Talla: M, Color: Blanco");
        JSONArray arrImg2_1 = new JSONArray();
        arrImg2_1.add("camiseta1.png");
        arrImg2_1.add("camiseta2.png");
        producto2_1.put("imagenes", arrImg2_1);
        producto2_1.put("inventario", 5);
        arrProductos2.add(producto2_1);

        JSONObject producto2_2 = new JSONObject();
        producto2_2.put("id", 202);
        producto2_2.put("nombre", "Jeans");
        producto2_2.put("precio", 49.99);
        producto2_2.put("descripcion", "Jeans de corte ajustado.");
        producto2_2.put("caracteristicas", "Material: Denim, Talla: 32, Color: Azul");
        JSONArray arrImg2_2 = new JSONArray();
        arrImg2_2.add("jeans1.png");
        arrImg2_2.add("jeans2.png");
        producto2_2.put("imagenes", arrImg2_2);
        producto2_2.put("inventario", 5);
        arrProductos2.add(producto2_2);

        JSONObject producto2_3 = new JSONObject();
        producto2_3.put("id", 203);
        producto2_3.put("nombre", "Chaqueta");
        producto2_3.put("precio", 99.99);
        producto2_3.put("descripcion", "Chaqueta impermeable.");
        producto2_3.put("caracteristicas", "Material: Poliéster, Talla: L, Color: Negro");
        JSONArray arrImg2_3 = new JSONArray();
        arrImg2_3.add("chaqueta1.png");
        arrImg2_3.add("chaqueta2.png");
        producto2_3.put("imagenes", arrImg2_3);
        producto2_3.put("inventario", 5);
        arrProductos2.add(producto2_3);

        categoria2.put("productos", arrProductos2);
        arrCategorias.add(categoria2);

        // Crear categoría 3
        JSONObject categoria3 = new JSONObject();
        categoria3.put("id", 3);
        categoria3.put("nombre", "Hogar");
        JSONArray arrProductos3 = new JSONArray();

        JSONObject producto3_1 = new JSONObject();
        producto3_1.put("id", 301);
        producto3_1.put("nombre", "Lámpara");
        producto3_1.put("precio", 29.99);
        producto3_1.put("descripcion", "Lámpara LED de escritorio.");
        producto3_1.put("caracteristicas", "Tipo: LED, Color: Blanco, Potencia: 10W");
        JSONArray arrImg3_1 = new JSONArray();
        arrImg3_1.add("lampara1.png");
        arrImg3_1.add("lampara2.png");
        producto3_1.put("imagenes", arrImg3_1);
        producto3_1.put("inventario", 5);
        arrProductos3.add(producto3_1);

        JSONObject producto3_2 = new JSONObject();
        producto3_2.put("id", 302);
        producto3_2.put("nombre", "Cafetera");
        producto3_2.put("precio", 89.99);
        producto3_2.put("descripcion", "Cafetera con temporizador programable.");
        producto3_2.put("caracteristicas", "Tipo: Automática, Capacidad: 1.2L, Funciones: Programable");
        JSONArray arrImg3_2 = new JSONArray();
        arrImg3_2.add("cafetera1.png");
        arrImg3_2.add("cafetera2.png");
        producto3_2.put("imagenes", arrImg3_2);
        producto3_2.put("inventario", 5);
        arrProductos3.add(producto3_2);

        JSONObject producto3_3 = new JSONObject();
        producto3_3.put("id", 303);
        producto3_3.put("nombre", "Aspiradora");
        producto3_3.put("precio", 199.99);
        producto3_3.put("descripcion", "Aspiradora inalámbrica con gran potencia.");
        producto3_3.put("caracteristicas", "Tipo: Inalámbrica, Potencia: 1500W, Autonomía: 45 min");
        JSONArray arrImg3_3 = new JSONArray();
        arrImg3_3.add("aspiradora1.png");
        arrImg3_3.add("aspiradora2.png");
        producto3_3.put("imagenes", arrImg3_3);
        producto3_3.put("inventario", 5);
        arrProductos3.add(producto3_3);

        categoria3.put("productos", arrProductos3);
        arrCategorias.add(categoria3);

        tienda.put("categorias", arrCategorias);

        // Crear usuarios
        JSONArray arrUsuarios = new JSONArray();

        JSONObject usuario1 = new JSONObject();
        usuario1.put("id", 1);
        usuario1.put("nombre", "Juan Pérez");
        usuario1.put("email", "juanperez@example.com");
        JSONObject direccion1 = new JSONObject();
        direccion1.put("calle", "Calle Principal");
        direccion1.put("numero", 123);
        direccion1.put("ciudad", "Madrid");
        direccion1.put("pais", "España");
        usuario1.put("direccion", direccion1);
        arrUsuarios.add(usuario1);

        JSONObject usuario2 = new JSONObject();
        usuario2.put("id", 2);
        usuario2.put("nombre", "María López");
        usuario2.put("email", "marialopez@example.com");
        JSONObject direccion2 = new JSONObject();
        direccion2.put("calle", "Avenida Central");
        direccion2.put("numero", 456);
        direccion2.put("ciudad", "Barcelona");
        direccion2.put("pais", "España");
        usuario2.put("direccion", direccion2);
        arrUsuarios.add(usuario2);

        JSONObject usuario3 = new JSONObject();
        usuario3.put("id", 3);
        usuario3.put("nombre", "Carlos Sánchez");
        usuario3.put("email", "carlossanchez@example.com");
        JSONObject direccion3 = new JSONObject();
        direccion3.put("calle", "Calle Secundaria");
        direccion3.put("numero", 789);
        direccion3.put("ciudad", "Valencia");
        direccion3.put("pais", "España");
        usuario3.put("direccion", direccion3);
        arrUsuarios.add(usuario3);

        tienda.put("usuarios", arrUsuarios);
        JSONObject tiendas = new JSONObject();
        tiendas.put("tienda", tienda);
        
        try (FileWriter file = new FileWriter("tienda.json")) {
            file.write(tiendas.toJSONString());
            System.out.println("Archivo JSON creado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean hayDatos() {
        
        try(Conexion conn=new Conexion();
            Statement stmt=conn.getConn().createStatement()){
            try(ResultSet rs=stmt.executeQuery("SELECT * FROM Usuarios")){
                return rs.next();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
