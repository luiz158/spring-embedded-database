--DROP TABLE users IF EXISTS;

CREATE TABLE product_catalogue (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  category VARCHAR(15),
  price  DOUBLE
);
