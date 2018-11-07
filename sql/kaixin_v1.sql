drop database kaixin;
create database kaixin;


create table com_resource(
       id int(11) not null auto_increment,
       name varchar(128) not null,
       type varchar(16) not null,
       url varchar(512) not null,
       create_time timestamp not null default now(),
       edit_time timestamp,
       primary key(id)
);
create table com_work_compact(
       id int(11) not null auto_increment,
       compact_id int(11) not null,
       work_id int(11) not null,
       primary key(id)
)
create table bean_customer(
       id int(11) not null auto_increment,
       name varchar(64) not null,
       leader varchar(32) not null,
       person_id varchar(32),
       tel varchar(32),
       type varchar(32) default'意向客户',
       status varchar(32),
       detail varchar(256),
       resource_id int(11),
       create_time timestamp not null default now(),
       edit_time timestamp,
       primary key (id)
);
create table bean_machine_type(
       id int(11) not null auto_increment,
       brand varchar(32) not null,
       model varchar(32) not null,
       detail varchar(256),
       resource_id int(11),
       primary key(id)
);

create table bean_machine(
       id int(11) not null auto_increment,
       tid int(11) not null,
       code varchar(32) not null,
       status int(3) default 0,
       worktime int(8),
       xyz varchar(64),
       resource_id int(11),
       detail varchar(256),
       create_time timestamp not null default now(),
       edit_time timestamp,
       birth timestamp,
       primary key (id)
);

create table bean_driver(
       id int(11) not null auto_increment,
       name varchar(16) not null,
       tel varchar(16) not null,
       person_id varchar(32) not null,
       paper_id varchar(32),
       credit_card varchar(32) not null,
       status int(3) default 0,
       type varchar(16) default'临时机手',
       resource_id int(11),
       create_time timestamp not null default now(),
       edit_time timestamp,
       primary key (id)
);
create table bean_support(
       id int(11) not null auto_increment,
       name varchar(16) not null,
       tel varchar(16) not null,
       status int(3) default 0,
       type varchar(16) default'普通后勤',
       resource_id int(11),
       create_time timestamp not null default now(),
       edit_time timestamp,
       primary key (id)
);
create table log_oil(
       id int(11) not null auto_increment,
       support_id int(11) not null,
       machine_id int(11) not null,
       litre int(11) not null,
       money int(11) not null,
       details varchar(256),
       resource_id int(11),
       log_mode int(3),
       create_time timestamp not null default now(),
       edit_time timestamp,
       primary key (id)
);

create table log_transport(
       id int(11)not null auto_increment,
       support_id int(11) not null,
       machine_id int(11) not null,
       departure varchar(256),
       destination varchar(256),
       type varchar(16),
       money double not null,
       details varchar(256),
       resource_id int(11),
       log_mode int(3),
       create_time timestamp not null default now(),
       edit_time timestamp,
       start_time timestamp,
       end_time timestamp,
       primary key (id)
);
create table log_work(
       id int(11)not null auto_increment,
       driver_id int(11) not null,
       machine_id int(11) not null,
       compact_id int(11) not null,
       type varchar(16),
       money double not null,
       details varchar(256),
       resource_id int(11),
       log_mode int(3),
       create_time timestamp not null default now(),
       edit_time timestamp,
       start_time timestamp,
       end_time timestamp,
       primary key (id)
);
create table log_maintain(
       id int(11) not null auto_increment,
       support_id int(11) not null,
       machine_id int(11) not null,
       type varchar(16),
       money double not null,
       details varchar(256),
       resource_id int(11),
       log_mode int(3),
       create_time timestamp not null default now(),
       edit_time timestamp,
       start_time timestamp,
       end_time timestamp,
       primary key (id)
);
create table log_error(
       id int(11) not null auto_increment,
       driver_id int(11),
       support_id int(11),
       type varchar(16),
       title varchar(128),
       details varchar(256),
       resource_id int(11),
       log_mode int(3),
       create_time timestamp not null default now(),
       edit_time timestamp,
       primary key (id)
);
create table service_intention(
       id int(11) not null auto_increment,
       customer_id int (11) not null,
       title varchar(128),
       details varchar(256),
       resource_id int(11),
       service_mode int(3),
       create_time timestamp not null default now(),
       edit_time timestamp,
       start_time timestamp,
       end_time timestamp,
       primary key (id)
);
create table service_compact(
       id int(11) not null auto_increment,
       parent_id int(11),
       customer_id int(11) not null,
       type varchar(16) default '一般合同',
       deposit double not null,
       full_amount double not null,
       limit_time int(11) not null,
       title varchar(128),
       details varchar(256),
       resource_id int(11),
       service_mode int(3),
       create_time timestamp not null default now(),
       edit_time timestamp,
       start_time timestamp,
       end_time timestamp,
       primary key (id)
);




       


       