--����� �Է��ϸ� �ش� ����� �����ϴ� ���ν���
create or replace procedure p_sawon_ex_del
	(v_bun sawon_ex.sabun%type)
is
begin
	delete sawon_ex where sabun=v_bun;
	commit;
end;
/

--ȣ������
--exec p_sawon_ex_del(11)



