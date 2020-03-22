INSERT INTO DARKEX (product_name, proveedores) VALUES ('Camisa', 'NIKE');
INSERT INTO DARKEX (product_name, proveedores) VALUES ('Cuaderno', 'Norma');
INSERT INTO DARKEX (product_name, proveedores) VALUES ('Teclado', 'Genius');

INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Inventario Inicial Camisas', {ts '2012-09-17'},12000,20,24000,0,0,20,240000,1,1);

INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Compra Camisas #1', {ts '2019-10-17'},1300,10,13000,0,0,30,253000,1,1);

INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Inventario Inicial Cuaderno', {ts '2020-09-17'},12000,20,24000,0,0,20,240000,1,2);

INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Compra Cuaderno #1', {ts '2020-10-17'},1300,10,13000,0,0,30,253000,1,3);