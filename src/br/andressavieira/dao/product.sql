drop database CrudProduct;
create database CrudProduct;

use CrudProduct;

create table product(
	id int NOT NULL AUTO_INCREMENT,
	description varchar(300),
	datePurchase date,
	image varchar(500),
	price double,
	origin varchar(50),
	category varchar(50),
	PRIMARY KEY (id)
);

insert into product(description,dataPurchase,image,price,origin,category) 
values("Samsung Galaxy J5 Prime Preto com Tela 5, 4G, 32 GB",
"2017-12-24", "SGG570MZPTO_PRD_1500_1", "655.17", "Nacional", "Celulares");

