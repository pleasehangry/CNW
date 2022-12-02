CREATE DATABASE manage_library;
use manage_library;

CREATE TABLE book
(
	id INT AUTO_INCREMENT PRIMARY KEY ,
    name varchar(250),
    category_id int,
    amount int,
    image varchar(250),
    create_day timestamp
);

CREATE TABLE `user`
(
	id int AUTO_INCREMENT PRIMARY KEY,
    username varchar(250),
    password varchar(250)
);

CREATE TABLE reader
(
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(250),
    book_id int,
    identity_card int,
    start_day timestamp,
    end_day timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    status bit DEFAULT 1
);

CREATE TABLE category
(
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(250)
);

ALTER TABLE book
	add CONSTRAINT FK_BOOK_CATE
    FOREIGN KEY (category_id) REFERENCES category(id);
ALTER TABLE reader
	add CONSTRAINT FK_READER_BOOK
    FOREIGN KEY (book_id) REFERENCES book(id);
    
INSERT INTO `user`(id, username, password) values(1, 'admin', '123');
INSERT INTO `user`(id, username, password) values(2, 'admin2', '123');
INSERT INTO `user`(id, username, password) values(3, 'admin3', '123');

INSERT INTO category(id,name) VALUES (1, 'aaa');
INSERT INTO category(id,name) VALUES (2, 'bbb');
INSERT INTO category(id,name) VALUES (3, 'ccc');