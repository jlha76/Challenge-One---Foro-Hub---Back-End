create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(5000) not null,
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status varchar(100) not null,
    autor_id bigint not null,
    curso varchar(100) not null,

    primary key(id)
);