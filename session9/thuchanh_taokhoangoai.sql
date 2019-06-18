CREATE TABLE customers(
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255)
);
CREATE TABLE orders(
order_id INT AUTO_INCREMENT,
staff VARCHAR(55),
customers_id int,
PRIMARY KEY(order_id),
FOREIGN KEY(customers_id) REFERENCES customers(id)
);