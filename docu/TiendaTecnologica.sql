
DROP DATABASE IF EXISTS Tienda;
CREATE DATABASE Tienda;
USE Tienda;

CREATE TABLE Categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE Productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categoria_id INT,
    nombre VARCHAR(255) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descripcion TEXT,
    caracteristicas VARCHAR(255),
    inventario INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES Categorias(id)
);

CREATE TABLE ProductoImagenes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT,
    imagen VARCHAR(255),
    FOREIGN KEY (producto_id) REFERENCES Productos(id)
);

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    direccion_calle VARCHAR(255),
    direccion_numero INT,
    direccion_ciudad VARCHAR(255),
    direccion_pais VARCHAR(255)
);

CREATE TABLE HistorialCompras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    producto_id INT,
    cantidad INT,
    fecha DATE,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    FOREIGN KEY (producto_id) REFERENCES Productos(id)
);

SELECT * FROM Usuarios;
