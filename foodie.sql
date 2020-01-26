create database if not exists foodie;

use foodie;

drop table if exists food;

create table food (
	ID int(7) not null auto_increment,
	food_name varchar(25) not null,
	type varchar(15) not null,
	ethnicity varchar(15) not null,
	meat varchar(30),
	veggies varchar(35),
	fruits varchar(35),
	sweets varchar(35),
	primary key (ID)
);