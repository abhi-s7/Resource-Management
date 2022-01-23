create database if not exists abhi_rm;

use abhi_rm;

create table if not exists employees (
	employee_id int auto_increment PRIMARY KEY,
	employee_name varchar(16),
	employee_password varchar(16)
);

create table if not exists candidates (
	candidate_id int auto_increment primary key,
    candidate_name varchar(16),
    domain varchar(16),
    experience double,
    assessment1 boolean,
    assessment2 boolean,
    assessment3 boolean
);

create table if not exists employee_candidate_mapping (
	ec_id int auto_increment primary key,
    e_id int,
    c_id int
);
