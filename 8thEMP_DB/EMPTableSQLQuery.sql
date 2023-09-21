create database Employee;
use Employee;
create table EMP_Data(EMP_No int,EMP_Name varchar(20),EMP_Exp int,EMP_Department varchar(20),EMP_Salary int);
insert into EMP_Data values(101,'Mike',3,'Cloud-SL',50000);
insert into EMP_Data values(102,'Jack',5,'Cloud-SL',90000);
insert into EMP_Data values(103,'Kim',10,'Delivery',500000);
insert into EMP_Data values(104,'Mike Kim',3,'Delivery',50000);
insert into EMP_Data values(105,'Sam',7,'Delivery',90000);
insert into EMP_Data values(106,'Smith',3,'QA',90000);
insert into EMP_Data values(107,'JackSmith',6,'QA',900000);
select * from EMP_Data;
select * from EMP_Data where EMP_Department = 'Cloud-SL';

