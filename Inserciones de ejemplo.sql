USE bancoBD;

-- PARA FINES PRACTICOS TODAS LAS CONTRASEÑAS INSERTADAS AQUI SERAN LA MISMA CON LA MISMA SAL
-- LA PALABRA "contraseña" ES LA CONTRASEÑA

-- Inserciones de ejemplo para la tabla Clientes
INSERT INTO Clientes (contrasenia, sal, nombre_usuario, fecha_nacimiento, edad, nombres, apellido_paterno, apellido_materno)
VALUES
    ('dZh7BJoKq0vhsah5MJXqhtEBYgVbzwwe/p4ZVGPTrb4=', 'WQM2HzMZDV54FeWhPnXVig==', 'usuario1', '1990-01-01', 30, 'Jorge Alan', 'Zamora', 'Mejia'),
    ('dZh7BJoKq0vhsah5MJXqhtEBYgVbzwwe/p4ZVGPTrb4=', 'WQM2HzMZDV54FeWhPnXVig==', 'usuario2', '1985-05-15', 36, 'Victoria', 'Vega', 'Bernal'),
    ('dZh7BJoKq0vhsah5MJXqhtEBYgVbzwwe/p4ZVGPTrb4=', 'WQM2HzMZDV54FeWhPnXVig==', 'usuario3', '1995-10-20', 26, 'Vicente Alberto', 'Zamudio', 'Valencia');

-- Inserciones de ejemplo para la tabla Domicilios
INSERT INTO Domicilios (calle, colonia, num_exterior, codigo_postal, ciudad, estado, id_cliente)
VALUES
    ('Quintana Roo', 'Carbo', 811, 8082, 'Obregon', 'Sonora', 1),
    ('Ley', 'Villacalifornia', 322, 5432, 'Hermosillo', 'Sonora', 2),
    ('5 marzo', 'Leal', 789, 4023, 'Bacum', 'Chihuahua', 3);

-- Inserciones de ejemplo para la tabla Cuentas
INSERT INTO Cuentas (num_cuenta, saldo, estado, id_cliente)
VALUES
    (1001, 1500.00, 'abierta', 1),
    (1002, 2000.00, 'abierta', 2),
    (1003, 1000.00, 'abierta', 3);

-- Inserciones de ejemplo para la tabla Operaciones
INSERT INTO Operaciones (tipo, motivo, monto, codigo_cuenta)
VALUES
    ('Retiro sin cuenta', 'Deuda', 500.00, 1),
    ('Transferencia', 'Ayuda cumpleaños', 200.00, 2),
    ('Retiro sin cuenta', 'Apuesta', 300.00, 3);

-- Inserciones de ejemplo para la tabla Transferencias
INSERT INTO Transferencias (codigo, numero_cuenta_destino)
VALUES
    (1, 1002);

-- Inserciones de ejemplo para la tabla Retiros_sin_cuenta
INSERT INTO Retiros_sin_cuenta (num_folio, contrasenia, sal, estado, fecha_hora_caducidad, codigo)
VALUES
    (7393857204849384, 'dZh7BJoKq0vhsah5MJXqhtEBYgVbzwwe/p4ZVGPTrb4=', 'WQM2HzMZDV54FeWhPnXVig==', 'vencida', '2023-01-15 12:00:00', 1),
    (7898937483920192, 'dZh7BJoKq0vhsah5MJXqhtEBYgVbzwwe/p4ZVGPTrb4=', 'WQM2HzMZDV54FeWhPnXVig==', 'cobrada', '2023-02-01 14:30:00', 3);

-- Inserciones de ejemplo para la tabla Cuenta_Operacion
INSERT INTO Cuenta_Operacion (codigo_cuenta, codigo_operacion)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);