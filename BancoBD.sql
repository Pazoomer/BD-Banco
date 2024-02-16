DROP DATABASE bancoBD;

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS bancoBD;
USE bancoBD;

-- Crear la tabla Clientes
CREATE TABLE IF NOT EXISTS Clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contrasenia VARCHAR(256) NOT NULL,
    sal VARCHAR(64) NOT NULL,
	nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    fecha_nacimiento DATE,
    edad INT,
    nombres VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NOT NULL,
    nombre_completo VARCHAR(200) AS (CONCAT(nombres, ' ', apellido_paterno, ' ', apellido_materno))
);

-- Crear la tabla Domicilios
CREATE TABLE IF NOT EXISTS Domicilios (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    calle VARCHAR(50),
    colonia VARCHAR(50),
    num_exterior INT,
    codigo_postal INT,
    ciudad VARCHAR(50),
    estado VARCHAR(50),
    id_cliente BIGINT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id)
);

-- Crear la tabla Cuentas
CREATE TABLE IF NOT EXISTS Cuentas (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    num_cuenta BIGINT UNIQUE NOT NULL,
    fecha_apertura TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    saldo DECIMAL,
    estado ENUM('abierta', 'cancelada') NOT NULL,
    id_cliente BIGINT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id)
);

-- Crear la tabla Operaciones
CREATE TABLE IF NOT EXISTS Operaciones (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
	tipo VARCHAR(30) CHECK (tipo IN ('Operacion sin cuenta', 'Transferencia')) NOT NULL,
    motivo VARCHAR(200),
    fecha_hora_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    monto DECIMAL,
    codigo_cuenta BIGINT,
    FOREIGN KEY (codigo_cuenta) REFERENCES Cuentas(codigo)
);

-- Crear la tabla Transferencias
CREATE  TABLE IF NOT EXISTS Transferencias (
    codigo BIGINT PRIMARY KEY,
    numero_cuenta_destino BIGINT NOT NULL,
    FOREIGN KEY (codigo) REFERENCES Operaciones(codigo)
);

-- Crear la tabla Retiros_sin_cuenta
CREATE TABLE IF NOT EXISTS Retiros_sin_cuenta (
    codigo BIGINT PRIMARY KEY,
    num_folio BIGINT UNIQUE NOT NULL,
    contrasenia INT NOT NULL,
    estado VARCHAR(30) CHECK (estado IN ('Cobrada', 'Vencida',"Disponible")) NOT NULL,
    fecha_hora_caducidad TIMESTAMP,
    FOREIGN KEY (codigo) REFERENCES Operaciones(codigo)
);

-- Crear la tabla Cuenta_Operacion
CREATE TABLE IF NOT EXISTS Cuenta_Operacion (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_cuenta BIGINT NOT NULL,
    codigo_operacion BIGINT NOT NULL,
    FOREIGN KEY (codigo_cuenta) REFERENCES Cuentas(codigo),
    FOREIGN KEY (codigo_operacion) REFERENCES Operaciones(codigo)
);