-- Ŀ�̼� ���� 
-- �޿��� 1000�̸�   -> �޿��� 10%
--	1000~2000 -> �޿��� 15%
-- 	2000�ʰ�    -> �޿��� 20%
--	null	   -> 0
declare
	cursor mycur is select sabun, sapay from sawon;
	v_bun sawon.sabun%type;
	v_pay sawon.sapay%type;
	v_comm sawon.comm%type;
	cnt number(3);
begin
	if mycur%isopen then close mycur;
	end if;
	open mycur;
	loop
		fetch mycur into v_bun, v_pay;	
		exit when(mycur%notfound);

		if v_pay<1000 then
			v_comm:=v_pay*0.1;
		elsif v_pay<=2000 then
			v_comm:=v_pay*0.15;
		elsif v_pay>2000 then
			v_comm:=v_pay*0.2;
		else 	v_comm:=0;
		end if;

		update sawon set comm=v_comm where sabun=v_bun;
--		dbms_output.put_line(v_bun||'����� Ŀ�̼��� '||v_comm||'���� ����Ǿ���');
	end loop;
	cnt := mycur%rowcount;
	dbms_output.put_line('Ŀ�̼��� ����� ����� ���� ' || cnt || '���̴�.');
	close mycur;
end;
/
--* Ŀ���� ����ϴ� �Ӽ� ����
--%isopen	: Ŀ���� �����ִ�
--%notfound	: ������ ���� ����
--%found		: �����ϴ� ���� �ִ�
--%rowcount	: ó���� �� ��