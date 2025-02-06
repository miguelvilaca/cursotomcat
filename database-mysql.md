# download
https://ftp.iij.ad.jp/pub/db/mysql/Downloads/Connector-J/

https://sinalbr.dl.sourceforge.net/project/squirrel-sql/1-stable/4.8.0/squirrel-sql-4.8.0-standard.jar?viasf=1

https://ftp.iij.ad.jp/pub/db/mysql/Downloads/Connector-J/mysql-connector-java-5.0.6.zip

# Criando a estrutura de dados para teste.

sudo apt install mysql-server;

sudo systemctl start mysql.service;

sudo mysql;

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';

create database contatos;

use contatos;

create Table contatos (
    id integer primary key ,
    nome varchar(40) not null,
    email varchar(30) not null
);


insert into contatos (id,nome, email) values ('1',
    'James Gosling', 'James.Gosling@sun.com');
