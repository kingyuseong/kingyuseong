-- 학생 성적 테이블
create table student(hakbun number(3), name varchar2(10), kor number(3), mat number(3), eng number(3));
insert into student values(101,'홍동우',90,80,60);
insert into student values(102,'차승원',80,75,60);
insert into student values(103,'현빈',90,60,60);
insert into student values(104,'강동원',55,40,60);
insert into student values(105,'주원',70,65,100);

-- 성적 결과 테이블
create table record(hakbun number(3), name varchar2(10), 
		kor number(3), mat number(3), eng number(3),
		total number(3), ave number(5,2), hakjum char(2), 
		grade char(10), s_rank number(3));
