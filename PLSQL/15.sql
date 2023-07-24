--사번을 가지고, 사원의 이름을 리턴해주는 프로시져(out mode)
create or replace procedure p_name
	(v_bun     in sawon.sabun%type,
	 v_name out sawon.saname%type)
is
begin
	select saname into v_name from sawon where sabun=v_bun;
end;
/

--호출형태
SQL> variable res varchar2(100)	//
SQL> exec p_name(3, :res)		//

PL/SQL 처리가 정상적으로 완료되었습니다.

SQL> print res			//

RES
-----------------------------------------
이순신

