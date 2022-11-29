CREATE DATABASE manage_library;

create table user
(
	id nvarchar(16) primary key,
	name nvarchar(30),
	password nvarchar(50),
	isAdmin boolean,
)

create table reader
(
	id nvarchar(16) primary key,
	name nvarchar(100),
	book_id nvarchar(16),
	indentify nvarchar(16),
	start_day date,
	end_day date,
	status nvarchar(50),
)

create table book
(
	id nvarchar(16) primary key,
	name nvarchar(100),
	category nvarchar(100),
	image varchar(100),
	amount int,
	day date,
)

create table category
(
	id nvarchar(16) primary key,
	name nvarchar(16),
)

alter table book
	add constraint FK_BOOK_CATEGORY
	foreign key (category)
	references category(name);

alter table reader
	add constraint FK_READER_BOOK
	foreign key (book_id)
	references book(id);