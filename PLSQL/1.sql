set serveroutput on

declare
--	int i = 10;
	i number(4) := 10;
begin
-- 	System.out.println(i);
	dbms_output.put_line('i is -> ' || i);
end;
/
