--Create type STATUS as enum ('HALFTIME','FULLTIME','ACTIVE');
create table if not exists employee(
    id serial,
    ide int primary key ,
    name varchar(20),
    passcode int,
    status varchar(10)
);