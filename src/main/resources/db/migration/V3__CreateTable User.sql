create table if not exists tb_user(
    id uuid primary key,
    email varchar(255) not null,
    password varchar(255) not null
);