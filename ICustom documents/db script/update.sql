
-- Create sequence 
create sequence SYS_USERS_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-- Create sequence 
create sequence SYS_NAVIGATION_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

-- Create table
create table SYS_USERS_T
(
  user_id       VARCHAR2(32) not null,
  user_account  VARCHAR2(30),
  user_name     VARCHAR2(40),
  user_password VARCHAR2(100),
  user_desc     VARCHAR2(100),
  enabled       NUMBER(1),
  issys         NUMBER(1),
  user_dept     VARCHAR2(20),
  user_duty     VARCHAR2(10),
  sub_system    VARCHAR2(30)
);


-- Create table
create table SYS_ROLES_AUTHORITIES_T
(
  id           NUMBER(13) not null,
  role_id      VARCHAR2(32),
  authority_id VARCHAR2(32),
  enabled      NUMBER(1)
);

-- Create table
create table SYS_RESOURCES_T
(
  resource_id     VARCHAR2(32) not null,
  resource_name   VARCHAR2(100),
  resource_desc   VARCHAR2(100),
  resource_type   VARCHAR2(40),
  resource_string VARCHAR2(200),
  priority        NUMBER(1),
  enabled         NUMBER(1),
  issys           NUMBER(1),
  module          VARCHAR2(4)
);


-- Create table
create table SYS_NAVIGATION_T
(
  item_id          NUMBER(30),
  item_name        VARCHAR2(60) not null,
  parent_id        NUMBER(30),
  icon             VARCHAR2(30),
  url              VARCHAR2(200),
  order_code       NUMBER(20),
  resource_type    NUMBER(1),
  created_user     NUMBER(30),
  created_date     DATE,
  update_last_user NUMBER(30),
  update_last_date DATE,
  valid_flag       NUMBER(1)
);

-- Create table
create table SYS_ROLES_T
(
  role_id   VARCHAR2(32) not null,
  role_name VARCHAR2(40),
  role_desc VARCHAR2(100),
  enabled   NUMBER(1),
  issys     NUMBER(1),
  module    VARCHAR2(4)
);

-- Create table
create table SYS_USERS_ROLES_T
(
  id      NUMBER(13) not null,
  user_id VARCHAR2(32),
  role_id VARCHAR2(32),
  enabled NUMBER(1)
);

-- Create table
create table SYS_AUTHORITIES_T
(
  authority_id   VARCHAR2(32) not null,
  authority_name VARCHAR2(40),
  authority_desc VARCHAR2(100),
  enabled        NUMBER(1),
  issys          NUMBER(1),
  module         VARCHAR2(4)
);


-- Create table
create table SYS_AUTHORITIES_RESOURCES_T
(
  id           NUMBER(13) not null,
  authority_id VARCHAR2(32),
  resource_id  VARCHAR2(32),
  enabled      NUMBER(1)
);

-- Create table
create table SC_DISTRICT
(
  id        NUMBER(10) not null,
  parent_id NUMBER(10),
  name      VARCHAR2(255) not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table SC_DISTRICT
  add constraint SC_DISTRICT_PK primary key (ID)
  using index;
alter table SC_DISTRICT
  add constraint SC_DISTRICT_R01 foreign key (PARENT_ID)
  references SC_DISTRICT (ID);

-- Create table
create table PERSISTENT_LOGINS
(
  username  VARCHAR2(40),
  series    VARCHAR2(256),
  token     VARCHAR2(256),
  last_used VARCHAR2(40)
);

