--1. ������� ����
create table dept_bk as select * from dept;

--dept table�� �Է��� �߻��ϸ�, dept_bk table�� �Է��� �߻��ϴ� Ʈ����
create or replace trigger t_dept_in
	after insert on dept
	for each row
begin
	insert into dept_bk(deptno, dname, loc) values(:new.deptno, :new.dname, :new.loc);
end;
/

--�� ���� Ʈ���ſ��� ���!!
--[:new.�÷���] : �Է��� �߻��� ���̺��� �÷���
--[:old.�÷���] : ������ �߻��� ���̺��� �÷���

--dept table�� ������ �߻��ϸ�, dept_bk table�� ������ �߻��ϴ� Ʈ����
create or replace trigger t_dept_out
   after delete on dept
   for each row
begin
   delete from dept_bk where deptno=:old.deptno;
end;
/

--dept table�� ������ �߻��ϸ�, dept_bk table�� ������ �߻��ϴ� Ʈ����
create or replace trigger t_dept_up
   after update on dept
   for each row
begin
   update dept_bk set dname=:new.dname, loc=:new.loc where deptno=:old.deptno;
-- delete from dept_bk where deptno=:old.deptno;
-- insert into dept_bk(deptno, dname, loc) values(:new.deptno, :new.dname, :new.loc);
end;
/
------------------------------
create or replace trigger t_dept
	after insert or delete or update on dept
	for each row
begin
	if inserting then
		insert into dept_bk(deptno, dname, loc) values(:new.deptno, :new.dname, :new.loc);
	elsif deleting then
		delete dept_bk where deptno=:old.deptno;
	elsif updating then
		update dept_bk 
		set dname=:new.dname, loc=:new.loc
		where deptno=:new.deptno;
	end if;
end;
/















