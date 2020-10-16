use happyhouse;


// Q&A DB
create table qboard(
	qno int not null primary key AUTO_INCREMENT,
    title varchar(30) not null,
    content varchar(200) not null,
    writer varchar(50) not null,
    viewcnt int not null,
    wday date not null
);

insert into qboard(title,content,writer,viewcnt,wday) values("어떻게 사용하면 되나요","어떻게 사용하면 되나요","GUMI",61,"2020-08-25");
insert into qboard(title,content,writer,viewcnt,wday) values("개인 정보 수정은 어떻게 하죠","개인 정보 수정은 어떻게 하죠","SSAFY",81,"2020-07-25");

select * from qboard;


// 공지사항 DB

create table infoboard(
	ino int not null primary key AUTO_INCREMENT,
    title varchar(30) not null,
    content varchar(200) not null,
    writer varchar(50) not null,
    position varchar(50) not null,
    viewcnt int not null,
    wday date not null
);

insert into infoboard(title,content,writer,position,viewcnt,wday) values("제휴 사이트","제휴 사이트","GUMI","admin",81,"2020-08-25");
insert into infoboard(title,content,writer,position,viewcnt,wday) values("개인정보 사용처","개인정보 사용처","SSAFY","admin",77,"2020-07-25");
insert into infoboard(title,content,writer,position,viewcnt,wday) values("개인정보 보관기관","개인정보 보관기관","MINT","admin",73,"2020-09-23");


select * from infoboard;



create table member(
   fname varchar(10),
   lname varchar(10),
   position varchar(30) not null,
   email varchar(20) primary key,
   password varchar(20) not null,
   confirmpassword varchar(20) not null
);
insert into member(fname,lname,email,password,position,confirmpassword)values('11','11','11@11','11','GOLD','11');

select * from member;