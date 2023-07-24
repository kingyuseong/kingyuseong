set verify off
accept name prompt '이름:'
accept pay prompt '급여:'
accept job prompt '직책:'
accept sex prompt '성별:'
accept dname prompt '부서명:'

begin
	p_sawon_in('&name', &pay, '&job', '&sex', '&dname');
end;
/