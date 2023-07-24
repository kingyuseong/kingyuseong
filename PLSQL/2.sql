--if 조건 then 명령;
--[eleif 조건 then 명령;
-- .....
-- else 명령;]
--end if;

declare
	i number(10) := 10;
begin
	if i<10 then
		dbms_output.put_line('i는 10보다 작다');
	elsif i >10 then
		dbms_output.put_line('i는 10보다 크다');
	else
		dbms_output.put_line('i는 10과 같다');
	end if;
end;
/