declare
	cursor mycur is select sabun, sapay from sawon;
	v_comm sawon.comm%type;
	cnt number(3);
begin
	for i in mycur loop
		if i.sapay<1000 then
			v_comm:=i.sapay*0.1;
		elsif i.sapay<=2000 then
			v_comm:=i.sapay*0.15;
		elsif i.sapay>2000 then
			v_comm:=i.sapay*0.2;
		else 	v_comm:=0;
		end if;

		update sawon set comm=v_comm where sabun=i.sabun;
		cnt := mycur%rowcount;
	end loop;
	dbms_output.put_line('커미션이 변경된 사원의 수는 ' || cnt || '명이다.');
end;
/