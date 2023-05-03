DROP DATABASE IF EXISTS magazine_shop;
CREATE DATABASE magazine_shop CHAR SET utf8;
USE magazine_shop;

CREATE TABLE user (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
email VARCHAR(45) NOT NULL,
password VARCHAR(15) NOT NULL,
access_level VARCHAR(15) NOT NULL
);

CREATE TABLE magazine(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(120) NOT NULL,
publish_date DATE NOT NULL,
subscribe_price DOUBLE NOT NULL
);

CREATE TABLE subscribe (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
user_id INT NOT NULL,
magazine_id INT NOT NULL,
subscribe_status BOOLEAN DEFAULT TRUE,
subscribe_date DATE NOT NULL,
subscribe_period INT NOT NULL
);

ALTER TABLE subscribe ADD FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE subscribe ADD FOREIGN KEY (magazine_id) REFERENCES magazine(id);