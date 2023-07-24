--1. 복제기능 구현
create table dept_bk as select * from dept;

--dept table에 입력이 발생하면, dept_bk table에 입력이 발생하는 트리거
create or replace trigger t_dept_in
	after insert on dept
	for each row
begin
	insert into dept_bk(deptno, dname, loc) values(:new.deptno, :new.dname, :new.loc);
end;
/

--행 단위 트리거에서 사용!!
--[:new.컬럼명] : 입력이 발생한 테이블의 컬럼값
--[:old.컬럼명] : 삭제가 발생한 테이블의 컬럼값

--dept table에 삭제가 발생하면, dept_bk table에 삭제가 발생하는 트리거
create or replace trigger t_dept_out
   after delete on dept
   for each row
begin
   delete from dept_bk where deptno=:old.deptno;
end;
/

--dept table에 변경이 발생하면, dept_bk table에 변경이 발생하는 트리거
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















