--사번을 입력하면 해당 사원을 삭제하는 프로시져
create or replace procedure p_sawon_ex_del
	(v_bun sawon_ex.sabun%type)
is
begin
	delete sawon_ex where sabun=v_bun;
	commit;
end;
/

--호출형태
--exec p_sawon_ex_del(11)



