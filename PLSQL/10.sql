-- �л� ���� ���̺�
create table student(hakbun number(3), name varchar2(10), kor number(3), mat number(3), eng number(3));
insert into student values(101,'ȫ����',90,80,60);
insert into student values(102,'���¿�',80,75,60);
insert into student values(103,'����',90,60,60);
insert into student values(104,'������',55,40,60);
insert into student values(105,'�ֿ�',70,65,100);

-- ���� ��� ���̺�
create table record(hakbun number(3), name varchar2(10), 
		kor number(3), mat number(3), eng number(3),
		total number(3), ave number(5,2), hakjum char(2), 
		grade char(10), s_rank number(3));
