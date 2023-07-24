--모든 사원들의 이름과 급여를 출력하는 커서를 정의
declare
	cursor mycur is select saname, sapay from sawon;
	v_name sawon.saname%type;
	v_pay    sawon.sapay%type;
begin
	if mycur%isopen then close mycur;
	end if;

	open mycur;
	loop
		fetch mycur into v_name, v_pay;
		exit when(mycur%notfound);
		dbms_output.put_line('이름:' || v_name ||', 급여:' || v_pay); 
	end loop;
	close mycur;
end;
/

