drop database  if exists shopkaro;

create database shopkaro;
use shopkaro;

show tables;

drop table  if exists product_details;

create table product_details(
product_id integer not null auto_increment,
name varchar(50) default null,
quantity varchar(30) default null,
price integer default null,
primary key(product_id)
)auto_increment=1001; customer

show tables;

drop table  if exists cart_details;

create table cart_details
(
cart_id integer not null auto_increment,
total_price integer default null,
primary key(cart_id)
)auto_increment=1;

drop table  if exists cart_product;

create table cart_product(
cart_id integer not null,
product_id integer not null,
primary key(cart_id,product_id),
foreign key (product_id) references product_details(product_id),
foreign key(cart_id) references cart_details(cart_id));

show tables;

drop table  if exists customer_details;

create table customer_details(
customer_id integer not null auto_increment,
name varchar(30) default null,
contact varchar(15) default null unique,
mail varchar(30) default null unique,
password varchar(30) default null,
location varchar(20) default null,
primary key(customer_id),
cart_id integer,
foreign key(cart_id) references cart_details(cart_id)
)auto_increment=1;

show tables;
drop table  if exists order_details;

create table order_details(
order_id integer not null auto_increment,
name varchar(40) default null,
location varchar(40) default null,
payment_mode varchar(30) default null,
doo varchar(10) default null,
dod varchar(10) default null,
amount_payable varchar(10) default null,
cart_id integer,
primary key(order_id),
foreign key (cart_id) references cart_details(cart_id)
)auto_increment=1;

show tables;

drop table  if exists review_details;

create table review_details(
review_id integer not null auto_increment,
name varchar(40) default null,
comments varchar(100) default null,
product_id integer,
primary key(review_id),
foreign key(product_id) references product_details(product_id)
)auto_increment=1;

show tables;

drop table  if exists users;

create table users(
username varchar(30) primary key,
password varchar(30),
status tinyint
);

insert into users values('gokul','{noop}admin123',1);
insert into users values('thilak','{noop}admin123',1);
insert into users values('jeff','{noop}admin123',1);

select * from users;

show tables;

drop table  if exists roles;

create table roles(
username varchar(30) primary key,
role varchar(30),
foreign key (username) references users(username)
);

insert into roles values('gokul','ROLE_ADMIN');
insert into roles values('thilak','ROLE_ADMIN');
insert into roles values('jeff','ROLE_ADMIN');

select * from roles;

show tables;

#END
