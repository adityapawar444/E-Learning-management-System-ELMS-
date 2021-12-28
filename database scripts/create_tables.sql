use student_registry;

drop table if exists course_reviews;
drop table if exists `courses`;
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

create table courses (
id int(11) not null auto_increment,
title varchar(45) not null,
course_desc varchar(128) default null,
mentor_id int(11) default null,
primary key(id),
key fk_course_mentor_idx (mentor_id),
constraint course_mentor_mapping foreign key (mentor_id) references mentor (id) on delete no action on update no action
);

create table course_reviews (
id int(11) not null auto_increment,
rating int(11) not null default 0,
review_comment varchar(128) default null,
review_date date,
reviewer varchar(45),
course_id int(11) default null,
primary key(id),
key review_course_mapping_idx (course_id),
constraint review_course_mapping foreign key (course_id) references courses (id)
);

create table student_course (
student_id int(11) not null,
course_id int(11) not null,
primary key(student_id,course_id),
key student_course_idx (student_id),
constraint student_to_course foreign key (student_id) references student (id) on delete no action on update no action,
constraint course_to_student foreign key (course_id) references courses (id) on delete no action on update no action
);

SET FOREIGN_KEY_CHECKS = 1;





