set verify off
accept name prompt '�̸�:'
accept pay prompt '�޿�:'
accept job prompt '��å:'
accept sex prompt '����:'
accept dname prompt '�μ���:'

begin
	p_sawon_in('&name', &pay, '&job', '&sex', '&dname');
end;
/