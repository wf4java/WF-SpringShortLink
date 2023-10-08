CREATE TABLE Person (
    id bigserial not null primary key,
    created_at timestamp(6) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    username varchar(255) not null unique);
