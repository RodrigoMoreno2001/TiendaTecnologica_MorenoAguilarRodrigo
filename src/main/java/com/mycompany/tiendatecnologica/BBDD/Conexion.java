package com.mycompany.tiendatecnologica.BBDD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase almacena los datos requeridos para
 * conectarse a una BBDD.<br>Implementa AutoCloseable
 * para aprovechar los cierres automáticos 
 * gestionados por un try-with-resources
 */

public class Conexion implements AutoCloseable {

    private Connection conn;
    private String url;
    private String user;
    private String pass;

    /**
     * Este constructor instancia un objeto tipo Conexion,
     * Este objeto tendrá un atributo Connection listo para ser usado
     * 
     * @throws SQLException si la conexion fallase
     */

    public Conexion() throws SQLException {

        this.url = "jdbc:mysql://localhost:3306/Tienda";
        this.user="root";
        this.pass="";

        conn=DriverManager.getConnection(url,user,pass);	
    }

    /**
     * Getter para interactuar con la conexión
     * @return Un objeto tipo Connection
     */

    public Connection getConn() {
        return conn;
    }

    /**
     * Metodo de la interfaz AutoCloseable
     * este metodo será llamado automáticamente por try-with
     * se encarga de cerrar la conexion
     * @throws SQLException si hay un error en la BBDD
     */

    @Override
    public void close() throws SQLException {
        conn.close();
    }	
		
}

