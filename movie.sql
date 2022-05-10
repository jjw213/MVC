테이블 이름 movie

code number(4) primary key,
title varchar2(50),
price number(10),
director varchar2(20),
poster varchar2(100),
synopsis varchar2(200)


create sequence movie_seq
start with 1
increment by 1
maxvalue 999999
cycle;

