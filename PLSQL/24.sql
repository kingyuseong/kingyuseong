--update cascade ����

--dept table�� deptno�� ����Ǹ�, �� �μ���ȣ�� �����ϴ� sawon table�� �μ���ȣ�� �Բ� ����Ǵ� Ʈ����
create or replace trigger c_dept
   	after update of deptno on dept
   	for each row
begin
   	update sawon set deptno=:new.deptno where deptno=:old.deptno;
end;
/