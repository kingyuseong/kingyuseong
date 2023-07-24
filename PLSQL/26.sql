-- ����� �޿��� ����Ǹ�,

--1. ���� �߻�
--2. �����Ϸ��� �޿��� ���� �޿����� ���ų�, ���� �޿��� 20% �ʰ��ϸ� ���� �߻�(������ ����)
--3. ������ ����(�����, ��¥(�ð�����), ������ ���, �������޿�, �����ı޿�)�� black_list ���̺� �Է�(black_list table����)

drop table black_list;
create table black_list
		(session_name varchar2(20) default user,
		 time varchar2(30) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),
		 sabun varchar2(10),
		 before_sapay number(10),
		 after_sapay number(10)
);

create or replace trigger t_gamsi
	after update of sapay on sawon
	for each row
	when (old.sajob != '����')
declare
	PRAGMA AUTONOMOUS_TRANSACTION;
begin
--1. 	raise_application_error(-20001, '�޿��� ������ �Ұ��մϴ�');

--2.
--   	if (:new.sapay < :old.sapay) or (:new.sapay > :old.sapay*1.2)  then
--     		raise_application_error(-20001, '�޿��� �������� ���� �ƴմϴ�!');
--	end if;

--3.   	
	insert into black_list(sabun, before_sapay, after_sapay) values(:new.sabun, :old.sapay, :new.sapay);
	commit;
	raise_application_error(-20001, '�޿��� ������ �Ұ��ϸ�, ������ �õ��� ������ ��ϵǾ����ϴ�.');

end;
/

--Ʈ���� ���� ����
alter table table_name [disable | enable] all triggers;
alter trigger trigger_name [disable | enable];