DROP TABLE IF EXISTS REGISTER;
DROP TABLE IF EXISTS DARKEX;
  
CREATE TABLE IF NOT EXISTS DARKEX (
  id INT AUTO_INCREMENT NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  proveedores VARCHAR(250) NOT NULL,
  PRIMARY KEY(id)
);

  
CREATE TABLE IF NOT EXISTS REGISTER (
  id INT AUTO_INCREMENT NOT NULL,
  description VARCHAR(250) NOT NULL,
  date DATE NOT NULL,
  unit_val INT,
  cant_entrada INT,
  val_entrada INT,
  cant_salida INT,
  val_salida INT,
  cant_saldo INT,
  val_saldo INT,
  operation INT,  
  darkex_id INT,
  PRIMARY KEY(id),
  FOREIGN KEY (darkex_id) REFERENCES DARKEX(id)
);

