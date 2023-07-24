alter table sawon add comm number(10);

-- ����� ����� �Է¹޾Ƽ� �� ����� �޿��� �������� Ŀ�̼��� ����(update)�ϴ� ���α׷�
-- Ŀ�̼� ���� 
-- �޿��� 1000�̸�   -> �޿��� 10%
--	1000~2000 -> �޿��� 15%
-- 	2000�ʰ�    -> �޿��� 20%
--	null	   -> 0

accept bun prompt '���->'
declare
	v_bun sawon.sabun%type := &bun;
	v_pay sawon.sapay%type;
	v_comm sawon.comm%type;
begin 
	select sapay into v_pay from sawon where sabun = v_bun;

	if  v_pay<1000 then
		v_comm :=  v_pay*0.1;
	elsif v_pay<=2000 then
		v_comm :=  v_pay*0.15;
	elsif v_pay>2000 then 
		v_comm := v_pay*0.2;
	else v_comm := 0;
   	end if;

	update sawon set comm = v_comm where sabun=v_bun;
	commit;

	dbms_output.put_line(v_bun || '�� ����� Ŀ�̼��� ' || v_comm || '���� ����!');
end;
/