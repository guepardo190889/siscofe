-- drop the existing database
drop database siscofeDBSt;

-- create the test user
create user test password 'test';

-- create the database
create database siscofeDBSt owner test;
