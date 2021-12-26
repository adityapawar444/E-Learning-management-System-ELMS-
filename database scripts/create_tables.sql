use student_registry;

drop table if exists `mentor`;
drop table if exists `mentor_details`;

create table `mentor_details` (
`id` int(11) not null auto_increment,
`skills` varchar(128) default null,
`prelims` varchar(45) default null,
`mains` varchar(45) default null,
`interview` varchar(45) default null,
`rating` float(11) default 0,
 primary key(`id`)
);

create table mentor (
id int(11) not null auto_increment,
first_name varchar(45) default null,
last_name varchar(45) default null,
is_Available boolean,
mentor_detail_id int(11) default null,
primary key(id),
key fk_idx (mentor_detail_id),
constraint mentor_detail_mapping foreign key (mentor_detail_id) references mentor_details (id) on delete no action on update no action 
);
SET FOREIGN_KEY_CHECKS = 1;





