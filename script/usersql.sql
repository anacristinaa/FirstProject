DROP DATABASE usersql;
CREATE DATABASE IF NOT EXISTS usersql;
use usersql;


CREATE  TABLE if not exists  users (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(80) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  lastaction timestamp NOT NULL default '2000-01-01 00:00:00', 
  PRIMARY KEY (user_id));


  CREATE TABLE if not exists user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) NOT NULL ,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  FOREIGN KEY (user_id)  REFERENCES users (user_id)    );


CREATE TABLE IF NOT EXISTS products (
product_id int(11) NOT NULL AUTO_INCREMENT,
name  VARCHAR(45) NOT NULL ,
description  VARCHAR(45) NOT NULL,
price int(11) NOT NULL,
user_id int(11) not null,
PRIMARY KEY (product_id),
FOREIGN KEY (user_id)  REFERENCES users (user_id)   );


INSERT INTO users( user_id,username,password,enabled)
VALUES (1,'anny','$2a$04$KNTAgYb31vahkarZDAPHlulkPLU0Tf/hg7eu1hoYZDM7COxNFPonC', true);
INSERT INTO users( user_id,username,password,enabled)
VALUES (2,'ana','$2a$04$KNTAgYb31vahkarZDAPHlulkPLU0Tf/hg7eu1hoYZDM7COxNFPonC', true);
INSERT INTO users( user_id,username,password,enabled)
VALUES (3,'sorina','$2a$04$KNTAgYb31vahkarZDAPHlulkPLU0Tf/hg7eu1hoYZDM7COxNFPonC', true);
INSERT INTO users( user_id,username,password,enabled) 
VALUES	(4, 'adri','$2a$10$xWLIUPRzTV9DIjm8I.oJ9.g.Hr5.VWS0ZCruBofSdMV.1Q22F1hB.',true);


INSERT INTO user_roles (user_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO user_roles (user_id, role)
VALUES (2, 'ROLE_USER');
INSERT INTO user_roles (user_id, role)
VALUES (3, 'ROLE_USER');
INSERT INTO user_roles (user_id, role)
VALUES (4, 'ROLE_USER');


INSERT INTO products(product_id,name,description,price,user_id)
VALUES (1,'HTC M8','smartphone',1800,2);
INSERT INTO products(product_id,name,description,price,user_id)
VALUES (2,'HTC M8','smartphone',1600,3);
INSERT INTO products(product_id,name,description,price,user_id)
VALUES (3,'HTC M9','smartphone',2100,4);
INSERT INTO products(product_id,name,description,price,user_id)
VALUES (4,'HTC A9','smartphone',2400,2);
INSERT INTO products(product_id,name,description,price,user_id)
VALUES (5,'Iphone 6s','smartphone',3600,1);

