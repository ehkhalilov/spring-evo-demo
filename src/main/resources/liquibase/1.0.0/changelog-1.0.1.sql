create table customers
(
    id   serial
        constraint customers_pk
            primary key,
    name varchar,
    age  integer
);