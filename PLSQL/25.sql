--*** ����� ���� ���� �Լ� : raise_application_error(-20001~20999m '�޼���'-1024����Ʈ�̳� �ۼ�)
--rollback ��� ����, ���α׷� ����(Ʈ���� ������ ����)

create or replace trigger t_dept_del
	after delete on dept
	for each row
begin
	raise_application_error(-20001,'�μ������� ������ �� �����ϴ�!!');
end;
/



