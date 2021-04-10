CREATE SCHEMA dataUsers;
USE dataUsers;

CREATE TABLE dataUsers (
  id VARCHAR(6) NOT NULL,
  user VARCHAR(25) NOT NULL,
  password VARCHAR(250) NOT NULL,  
  CONSTRAINT pk_c PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

select * from dataUsers;
drop table dataUsers;

##ingreso datos
insert into dataUsers values (1,'standard_user','secret_sauce');
insert into dataUsers values (2,'locked_out_user','secret_sauce');
insert into dataUsers values (3,'problem_user','secret_sauce');
insert into dataUsers values (4,'performance_glitch_user','secret_sauce');