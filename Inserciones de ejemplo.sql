USE bancoBD;
-- Inserciones de ejemplo para la tabla Clientes
INSERT INTO Clientes (contrasenia, sal, nombre_usuario, fecha_nacimiento, edad, nombres, apellido_paterno, apellido_materno)
VALUES
    ('contrasenia1', 'sal1', 'usuario1', '1990-01-01', 30, 'Nombre1', 'ApellidoPaterno1', 'ApellidoMaterno1'),
    ('contrasenia2', 'sal2', 'usuario2', '1985-05-15', 36, 'Nombre2', 'ApellidoPaterno2', 'ApellidoMaterno2'),
    ('contrasenia3', 'sal3', 'usuario3', '1995-10-20', 26, 'Nombre3', 'ApellidoPaterno3', 'ApellidoMaterno3');

-- Inserciones de ejemplo para la tabla Domicilios
INSERT INTO Domicilios (calle, colonia, num_exterior, codigo_postal, ciudad, estado, id_cliente)
VALUES
    ('Calle1', 'Colonia1', 123, 12345, 'Ciudad1', 'Estado1', 1),
    ('Calle2', 'Colonia2', 456, 54321, 'Ciudad2', 'Estado2', 2),
    ('Calle3', 'Colonia3', 789, 67890, 'Ciudad3', 'Estado3', 3);

-- Inserciones de ejemplo para la tabla Cuentas
INSERT INTO Cuentas (num_cuenta, saldo, estado, id_cliente)
VALUES
    (100001, 1500.00, 'abierta', 1),
    (100002, 2000.00, 'abierta', 2),
    (100003, 1000.00, 'abierta', 3);

-- Inserciones de ejemplo para la tabla Operaciones
INSERT INTO Operaciones (tipo, motivo, monto, codigo_cuenta)
VALUES
    ('Retiro sin cuenta', 'MotivoRetiro1', 500.00, 1),
    ('Transferencia', 'MotivoTransferencia1', 200.00, 2),
    ('Retiro sin cuenta', 'MotivoRetiro2', 300.00, 3);

-- Inserciones de ejemplo para la tabla Transferencias
INSERT INTO Transferencias (codigo, numero_cuenta_destino)
VALUES
    (1, 100002);

-- Inserciones de ejemplo para la tabla Retiros_sin_cuenta
INSERT INTO Retiros_sin_cuenta (num_folio, contrasenia, sal, estado, fecha_hora_caducidad, codigo)
VALUES
    (123456, 'contraseniaRetiro1', 'salRetiro1', 'disponible', '2023-01-15 12:00:00', 1),
    (789012, 'contraseniaRetiro2', 'salRetiro2', 'cobrada', '2023-02-01 14:30:00', 3);

-- Inserciones de ejemplo para la tabla Cuenta_Operacion
INSERT INTO Cuenta_Operacion (codigo_cuenta, codigo_operacion)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);