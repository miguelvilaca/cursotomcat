
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
    'aa1bf4646de67fd9086cf6c79007026c'); -- teste123
insert into usuarios values ('gerente',
    'e10adc3949ba59abbe56e057f20f883e'); -- 123456

insert into grupos values ('sicrano',
    'usuario');
insert into grupos values ('gerente',
    'administrador');

