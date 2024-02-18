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
	tipo VARCHAR(30) CHECK (tipo IN ('Retiro sin cuenta', 'Transferencia')) NOT NULL,
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
    contrasenia VARCHAR(256) NOT NULL,
    sal VARCHAR(64) NOT NULL,
    estado VARCHAR(30) CHECK (estado IN ('cobrada', 'vencida',"disponible")) NOT NULL,
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
 -- Procedimiento almacenado para caducar los retiros sin cuenta (se revisan antes de cobrarse)
DELIMITER //
CREATE PROCEDURE RevisarCaducidadRetirosSinCuenta()
BEGIN
    DECLARE ahora TIMESTAMP;
    
    -- Obtener la fecha y hora actuales
    SET ahora = CURRENT_TIMESTAMP;
    
    -- Actualizar los retiros sin cuenta vencidos
    UPDATE Retiros_sin_cuenta
    SET estado = 'vencida'
    WHERE estado = 'disponible' AND fecha_hora_caducidad < ahora;

END //
DELIMITER ;

 -- Procedimiento almacenado para calcular la edad de un cliente e insertarselo
DELIMITER //
CREATE PROCEDURE CalcularEdadCliente(IN codigoCliente INT)
BEGIN
    DECLARE fechaNacimientoCliente DATE;
    DECLARE edadCliente INT;

    -- Obtener la fecha de nacimiento del cliente
    SELECT fecha_nacimiento INTO fechaNacimientoCliente
    FROM Clientes
    WHERE id = codigoCliente;

    -- Calcular la edad del cliente
    SET edadCliente = YEAR(CURDATE()) - YEAR(fechaNacimientoCliente) -
        (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(fechaNacimientoCliente, '%m%d'));

    -- Actualizar la edad del cliente en la tabla
    UPDATE Clientes
    SET edad = edadCliente
    WHERE id = codigoCliente;
END //
DELIMITER ;

 -- Trigger para realizar una transferencia
DELIMITER //
CREATE TRIGGER trg_transferencia
AFTER INSERT ON Transferencias
FOR EACH ROW
BEGIN
    -- Variables para almacenar información
    DECLARE monto_transferencia DECIMAL;
    DECLARE cuenta_origen BIGINT;
    DECLARE cuenta_destino BIGINT;

    -- Obtener información de la transferencia
    SELECT monto, codigo_cuenta INTO monto_transferencia, cuenta_origen
    FROM Operaciones
    WHERE codigo = NEW.codigo;

    SELECT numero_cuenta_destino INTO cuenta_destino
    FROM Transferencias
    WHERE codigo = NEW.codigo;

    -- Actualizar el saldo de la cuenta origen
    UPDATE Cuentas
    SET saldo = saldo - monto_transferencia
    WHERE codigo = cuenta_origen;

    -- Actualizar el saldo de la cuenta destino
    UPDATE Cuentas
    SET saldo = saldo + monto_transferencia
    WHERE num_cuenta = cuenta_destino;
END;
//
DELIMITER ;