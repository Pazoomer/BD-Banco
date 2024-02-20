USE bancoBD;
select * from clientes;
select * from cuentas;
select * from operaciones;
select * from Transferencias;
select * from Retiros_sin_cuenta;
select * from Cuenta_Operacion;

-- Llamar al procedimiento para calcular la edad de todos los clientes
CALL CalcularEdadCliente(0);
-- Calcular el promedio de edad de todos los clientes
SELECT AVG(edad) AS promedio_edad
FROM Clientes;

-- Contar la cantidad de retiros en cada estado
SELECT estado, COUNT(*) AS cantidad
FROM Retiros_sin_cuenta
GROUP BY estado;
-- Llamar al procedimiento para revisar la caducidad de los retiros sin cuenta
CALL RevisarCaducidadRetirosSinCuenta();
-- Contar la cantidad de retiros en cada estado después de la actualización
SELECT estado, COUNT(*) AS cantidad
FROM Retiros_sin_cuenta
GROUP BY estado;