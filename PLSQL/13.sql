--사원 테이블에 사원 정보를 입력하는 프로시져
--사번은 시퀀스를 이용하고(201~299, 2씩증가)
--입사일은 현재날짜로 입력되고,
--커미션은 직책 조건에 따라 입력(직책이 대리 -> 급여의 10%, 과장 -> 급여의 15%, 부장-> 급여의 20%, 그 외의 직책-> 0)
--관리자번호는 부서가 영업부이면, 3번 사번을 입력하고, 총무부이면 10번 사번을 입력하고, 전산부이면 6번 사번을 입력되도록 한다.

--호출형태
--exec p_sawon_in('홍동우', 3000, '대리', '남자', '영업부')

create sequence s_sawon_sabun
increment by 2
start with 201
maxvalue 299;

create or replace procedure p_sawon_in(
    v_saname sawon.saname%type,
    v_sapay sawon.sapay%type,
    v_sajob sawon.sajob%type,
    v_sasex sawon.sasex%type,
    v_dname dept.dname%type )
is
--  dname_dept dept.deptno%type;
--  v_comm sawon.comm%type;
   v_samgr sawon.samgr%type;
begin
--   select deptno into dname_dept from dept where dname = v_dname;
   
--   if v_sajob = '대리' then
--      v_comm := v_sapay*0.1;
--   elsif v_sajob = '과장' then
--      v_comm := v_sapay*0.15;
--   elsif v_sajob = '부장' then
--      v_comm := v_sapay*0.20;
--   end if;

   if v_dname = '영업부' then
      v_samgr := 3;
   elsif v_dname = '총무부' then
      v_samgr := 10;
   elsif v_dname = '전산부' then
      v_samgr := 6;
   end if;

   insert into sawon (sabun, saname, sapay, sajob, sasex, deptno, comm, samgr, sahire)
--      values (s_sawon_sabun.nextval, v_saname, v_sapay, v_sajob,v_sasex, dname_dept, v_comm, v_samgr, sysdate);
   values (s_sawon_sabun.nextval, 
	v_saname, 
	v_sapay, 
	v_sajob,
	v_sasex, 
	(select deptno from dept where dname = v_dname), 
	(case v_sajob when '대리' then v_sapay*0.1 when '과장' then v_sapay*0.15 when '부장' then v_sapay*0.2 else 0 end),
	v_samgr, 
	sysdate);
  commit;
end;
/
