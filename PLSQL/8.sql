-- 커미션 기준 
-- 급여가 1000미만   -> 급여의 10%
--	1000~2000 -> 급여의 15%
-- 	2000초과    -> 급여의 20%
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
--		dbms_output.put_line(v_bun||'사원의 커미션은 '||v_comm||'으로 변경되었다');
	end loop;
	cnt := mycur%rowcount;
	dbms_output.put_line('커미션이 변경된 사원의 수는 ' || cnt || '명이다.');
	close mycur;
end;
/
--* 커서에 사용하는 속성 종류
--%isopen	: 커서가 열려있다
--%notfound	: 가져올 행이 없다
--%found		: 존재하는 행이 있다
--%rowcount	: 처리된 행 수