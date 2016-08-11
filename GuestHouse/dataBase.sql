create table memberTable
(
	id				varchar2(15)	primary key not null,
	pwd				varchar2(10)	not null,
	memberName		varchar2(20)	not null,
	phoneNumber		varchar2(20)	not null,
	email			varchar2(20)	not null,
	birthDate		date			not null,
	gender			char(6)			constraint check_gender check(gender IN('남자','여자')) not null,
	address			varchar2(100)	not null,
	registerDate	date			default sysdate not null,
	competence		varchar2(10)	constraint check_competence check(competence IN('호스트', '게스트')) not null,
	approve			varchar2(10)	not null
)
insert into MEMBERTABLE 
values('admin', '1234', '관리자', '010-0000-0000', 'abc@naver.com' ,null, '남자', '서울시', sysdate, '호스트', '승인')
select * from memberTable
drop table memberTable

create table districtTable
(
	hostingTitle	varchar2(20)	not null,
	hostId			varchar2(15)	not null,
	hostName		varchar2(15)	not null,
	hostPhone		varchar2(20)	not null,
	houseAddress	varchar2(100)	primary key not null,
	villageName		varchar2(20)	not null,
	bankAccount		varchar2(20)	not null,
	introduction	varchar2(1000)	not null,
	approve			varchar2(10)	not null
)
insert into districtTable values('좋은집', 'kyh', '영훈쓰', '010-5432-9877', '열두시','등촌3동','00000','굳','승인')
select * from districtTable
drop table districtTable

create table boardTable
(
	boardNumber		number			primary key ,
	id				varchar2(15)	not null,
	title			varchar2(100)	not null,
	content			varchar2(1000)	not null,
	hit				number			default 0,
	writeDate		date			default sysdate,
	fileName		varchar2(50)
)
insert into BOARDTABLE 
values(board_sequenceNumber.nextval, 'test', 'title', 'content', default, sysdate, 'fileName')
create sequence board_sequenceNumber
delete sequence board_sequenceNumber
select * from boardTable
drop table boardTable
