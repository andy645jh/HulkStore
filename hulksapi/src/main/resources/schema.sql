DROP TABLE IF EXISTS DARKEX;
  
CREATE TABLE DARKEX (
  id INT AUTO_INCREMENT NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  proveedores VARCHAR(250) NOT NULL,
  PRIMARY KEY(id)
);

DROP TABLE IF EXISTS REGISTER;
  
CREATE TABLE REGISTER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  date DATE NOT NULL,
  unit_val INT,
  cant_entrada INT,
  val_entrada INT,
  cant_salida INT,
  val_salida INT,
  cant_saldo INT,
  val_saldo INT,
  darkex_id INT NOT NULL  
);