/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`id` int (11),
	`name` varchar (699),
	`sex` char (3),
	`age` int (11),
	`address` varchar (288),
	`email` varchar (450)
); 
insert into `user` (`id`, `name`, `sex`, `age`, `address`, `email`) values('1','张三','1','11','广东','111111');
insert into `user` (`id`, `name`, `sex`, `age`, `address`, `email`) values('2','赵六','1','11','广东','111111');
insert into `user` (`id`, `name`, `sex`, `age`, `address`, `email`) values('15','王五','1','12','11','111');
insert into `user` (`id`, `name`, `sex`, `age`, `address`, `email`) values('16','小二','1','12','中国','1123');
