alter table sawon add comm number(10);

-- 사원의 사번을 입력받아서 그 사원의 급여를 기준으로 커미션을 변경(update)하는 프로그램
-- 커미션 기준 
-- 급여가 1000미만   -> 급여의 10%
--	1000~2000 -> 급여의 15%
-- 	2000초과    -> 급여의 20%
--	null	   -> 0

accept bun prompt '사번->'
declare
	v_bun sawon.sabun%type := &bun;
	v_pay sawon.sapay%type;
	v_comm sawon.comm%type;
begin 
	select sapay into v_pay from sawon where sabun = v_bun;

	if  v_pay<1000 then
		v_comm :=  v_pay*0.1;
	elsif v_pay<=2000 then
		v_comm :=  v_pay*0.15;
	elsif v_pay>2000 then 
		v_comm := v_pay*0.2;
	else v_comm := 0;
   	end if;

	update sawon set comm = v_comm where sabun=v_bun;
	commit;

	dbms_output.put_line(v_bun || '번 사원의 커미션은 ' || v_comm || '으로 변경!');
end;
/