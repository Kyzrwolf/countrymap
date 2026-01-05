--create database "countrymap" with owner postgres;

create schema if not exists countrymap;

create extension if not exists "uuid-ossp";

create table if not exists "countries"
(
    id          UUID unique  not null default uuid_generate_v1() primary key,
    country     varchar(255) not null,
    coordinates varchar(255) not null
);