
INSERT INTO DARKEX (product_name, proveedores) VALUES ('Camisa', 'URBANZOOM');
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Inventario Inicial Camisas', {ts '2019-09-15'},25000,20,500000,0,0,20,500000,1,1);
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Compra Camisas #1', {ts '2019-10-16'},22857,15,300000,0,0,35,800000,1,1);


INSERT INTO DARKEX (product_name, proveedores) VALUES ('Cuaderno', 'DH Comercializadora');
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Inventario Inicial Cuadernos', {ts '2019-09-17'},12000,20,240000,0,0,20,240000,1,2);


INSERT INTO DARKEX (product_name, proveedores) VALUES ('Teclado', 'Tienda Logitech');
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Inventario Inicial Teclado', {ts '2019-10-17'},13000,10,130000,0,0,10,130000,1,3);
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Compra Teclado #1', {ts '2019-10-20'},13000,5,65000,0,0,15,195000,1,3);
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Venta Teclado #1', {ts '2019-10-21'},13000,0,0,8,104000,7,91000,2,3);


INSERT INTO DARKEX (product_name, proveedores) VALUES ('Tablet Android', 'Tienda Logitech');
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Inventario Inicial Tablet Android', {ts '2019-09-15'},250000,20,5000000,0,0,20,5000000,1,4);
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Compra Tablet Android #1', {ts '2019-10-16'},228570,15,3000000,0,0,35,8000000,1,4);


INSERT INTO DARKEX (product_name, proveedores) VALUES ('Mouse Optico', 'Tienda Intel');
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Inventario Inicial Mouse Optico', {ts '2019-09-17'},14000,20,280000,0,0,20,280000,1,5);


INSERT INTO DARKEX (product_name, proveedores) VALUES ('Agenda', 'Tienda DHComercializadora');
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Inventario Inicial Agenda', {ts '2019-10-17'},5000,10,50000,0,0,10,50000,1,6);
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Compra Teclado #2', {ts '2019-10-20'},4833,5,22500,0,0,15,72500,1,6);
INSERT INTO REGISTER (description, date, unit_val, cant_entrada, val_entrada, cant_salida, val_salida, cant_saldo, val_saldo, operation, darkex_id) 
VALUES ('Venta Teclado #1', {ts '2019-10-21'},5000,0,0,5,25000,10,72475,2,6);
