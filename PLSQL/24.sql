--update cascade 구현

--dept table의 deptno가 변경되면, 그 부서번호를 참조하는 sawon table의 부서번호도 함께 변경되는 트리거
create or replace trigger c_dept
   	after update of deptno on dept
   	for each row
begin
   	update sawon set deptno=:new.deptno where deptno=:old.deptno;
end;
/