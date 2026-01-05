create extension if not exists "uuid-ossp";

create table if not exists countries
(
    id          uuid primary key default uuid_generate_v4(),
    country     varchar(255) not null,
    icode       varchar(3)   not null,
    coordinates jsonb        not null,
    constraint uq_countries_icode unique (icode)
);