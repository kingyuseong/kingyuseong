-- ������ ���α׷�
begin
	for i in 2..9 loop
		for j in 1..9  loop
			dbms_output.put_line( i || ' X ' || j || ' = ' || (i*j) );
		end loop;
		dbms_output.put_line('--------------------');
	end loop;
end;
/
