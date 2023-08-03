drop database 'shopkaro' if exist;

create database 'shopkaro';
use shopkaro;

create table product_details(
product_id integer not null auto_increment,
name varchar(50) default null,
quantity varchar(10) default null,
price varchar(10) default null
primary key(product_id),
)auto_increment=1;


create table cart_details
(
cart_id integer not null auto_increment,
total_price integer not null,
product_id integer default null,
primary key(cart_id),
foreign key(product_id) references product_details(product_id),
)auto_increment=1;


create table customer_details(
customer_id integer not null,
name varchar(30) default null,
contact varchar(15) default null,
mail varchar(30) default null
password varchar(30) default null,
location varchar(20) default null,
cart_id integer,
foreign key(cart_id) references cart_details(cart_id)
);


create table order_details(
order_id integer not null auto_increment,
payment_mode varchar(30) default null,
dod varchar(10) default null,
cart_id integer not null,
primary key(order_id)
foreign key (cart_id) references cart_details(cart_id)
)auto_increment=1;


create table review_details(
review_id integer not null auto_increment,
comments varchar(100) default null,
primary key(review_id),
foreign key(product_id) references product_details(product_id)
)auto_increment=1;


#for security
create table credentials(
username varchar(50) not null auto_increment,
password varchar(60) not null auto_increment,
enabled tinyint,
primary key(username),
);

create table authorities(
user varchar(30) not null,
authority varchar(30) not null,
unique key (user,authority)
foreign key user references credentials(username)
);

