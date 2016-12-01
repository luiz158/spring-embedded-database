--DROP TABLE users IF EXISTS;

CREATE TABLE products (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  category VARCHAR(15),
  price  DOUBLE
);
