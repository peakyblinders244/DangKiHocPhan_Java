create database chatUser
drop database User
create table chatUser (
username varchar(30),
userpassword varchar(30),
primary key(username)
)

insert into chatUser (username,userpassword) values
('lehongquan','lehongquan'),
('lehongquan1','lehongquan1'),
('lehongquan2','lehongquan2')

select * from chatUser