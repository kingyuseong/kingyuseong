--if ���� then ���;
--[eleif ���� then ���;
-- .....
-- else ���;]
--end if;

declare
	i number(10) := 10;
begin
	if i<10 then
		dbms_output.put_line('i�� 10���� �۴�');
	elsif i >10 then
		dbms_output.put_line('i�� 10���� ũ��');
	else
		dbms_output.put_line('i�� 10�� ����');
	end if;
end;
/