drop database if exists mywork;
create database mywork;
use mywork;
drop table if exists mywork.project;
create table mywork.project (
   proj_id bigint AUTO_INCREMENT PRIMARY KEY,
   proj_title varchar(255) NOT NULL,
   area varchar(255) NOT NULL
);

insert into mywork.project (proj_title, area) values
				   ('LT cash', 'database'),
                   ('Internet Shopping page', 'ibank'),
                   ('Replacement offer', 'database');

create table mywork.task (
   task_id bigint AUTO_INCREMENT PRIMARY KEY,
   task_name varchar(255) NOT NULL,
   task_description varchar(255) NOT NULL,
   proj_id bigint NOT NULL,
   FOREIGN KEY (proj_id) REFERENCES project(proj_id)
);

insert into mywork.task (task_name, task_description, proj_id) values
					    ('requirements', 'describe requirements', '1'),
                        ('requirements', 'present requirements to IT', '1'),
                        ('test function', 'test proposed function in db', '3');

create table mywork.status (
   status_id bigint AUTO_INCREMENT PRIMARY KEY,
   status_title text NOT NULL,
   task_id bigint,
   target_fix varchar(30) NOT NULL,
   FOREIGN KEY (task_id) REFERENCES task(task_id)
);

insert into mywork.status (status_title, task_id, target_fix) values
						  ('done', '01', 'December 2020'),
                          ('done', '02', 'January 2021'),
                          ('in progress', '03', 'January 2021');
