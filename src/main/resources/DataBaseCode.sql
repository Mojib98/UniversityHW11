--Create type STATUS as enum ('HALFTIME','FULLTIME','ACTIVE');
create table if not exists employee
(
    id       serial,
    ide      int primary key,
    name     varchar(20),
    passcode int,
    status   varchar(10)
);
create table if not exists professor
(
    id       serial,
    ide      int primary key,
    name     varchar(20) unique ,
    passcode int,
    status   varchar(10)
);
create table if not exists course(
    id serial,
    idc int primary key ,
    name varchar(20),
    unit int,
    idprofessor int references professor(ide),
    nameprofessor varchar(20) references professor(name)
);
create table if not exists student(
    id serial,
    ids int primary key ,
    passcode int,
    name varchar(20),
    totalscore int

);


create table if not exists section(
    id serial,
    namestudent varchar(20),
    ids int references student(ids),
    idc int references course(idc),
    unit int,
    semester varchar(4)



);