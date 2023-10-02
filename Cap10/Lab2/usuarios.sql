
drop table grupos;
drop table usuarios;

create table usuarios (
    login varchar(15) not null primary key,
    senha varchar(32) not null );
create table grupos (
    login varchar(15) not null,
    role varchar(15) not null,
    primary key (login, role) );

insert into usuarios values ('sicrano',
    'teste123'); -- teste123
insert into usuarios values ('gerente',
    '123456'); -- 123456

insert into grupos values ('sicrano',
    'usuario');
insert into grupos values ('gerente',
    'administrador');

