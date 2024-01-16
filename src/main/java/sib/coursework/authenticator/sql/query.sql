create table users(
    id serial8 primary key,
    name varchar(20) not null default 'User',
    surname varchar(20) not null default 'User',
    email varchar(30) not null,
    password varchar(200) not null
);