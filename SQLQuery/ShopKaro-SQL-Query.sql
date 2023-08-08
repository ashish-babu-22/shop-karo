drop database  if exists shopkaro;

create database shopkaro;
use shopkaro;

show tables;

create table product_details(
product_id integer not null auto_increment,
name varchar(50) default null,
quantity varchar(10) default null,
price varchar(10) default null,
primary key(product_id)
)auto_increment=1001;

show tables;

create table customer_details(
customer_id integer not null auto_increment,
name varchar(30) default null,
contact varchar(15) default null,
mail varchar(30) default null,
password varchar(30) default null,
location varchar(20) default null,
primary key(customer_id)
)auto_increment=1;

show tables;

create table cart_details
(
cart_id integer not null,
total_price integer not null,
primary key(cart_id),

foreign key(cart_id) references customer_details(customer_id)

);

show tables;

create table cart_item_details(
product_id integer not null auto_increment,
name varchar(20) default null,
price varchar(20) default null,
cart_id int,
primary key(product_id),
foreign key(cart_id) references cart_details(cart_id)
)auto_increment=1;

show tables;

create table order_details(
order_id integer not null auto_increment,
name varchar(40) default null,
location varchar(40) default null,
payment_mode varchar(30) default null,
doo varchar(10) default null,
dod varchar(10) default null,
amount_payable varchar(10) default null,
cart_id integer not null,
primary key(order_id),
foreign key (cart_id) references cart_details(cart_id)
)auto_increment=1;

show tables;

create table review_details(
review_id integer not null auto_increment,
name varchar(40) default null,
comments varchar(100) default null,
product_id integer,
primary key(review_id),
foreign key(product_id) references product_details(product_id)
)auto_increment=1;


#for security
create table credentials(
username varchar(50) not null,
password varchar(60) not null,
enabled tinyint,
primary key(username)
);

create table authorities(
user varchar(30) not null primary key,
authority varchar(30) not null,
unique key (user,authority),
foreign key (user) references credentials(username)
);

