-- 사번, 사원명, 급여, 입사일을 읽어들여서 근무기간, 급여순위를 구한 후, 
-- sawon_result 테이블(결과) 에 사원정보와 처리된 결과를 저장하는 커서
create table sawon_result(
	bun number(10),
	name varchar2(10), 
	pay number(10), 
	hiredate date, 
	hire_bet varchar2(20), 
	pay_rank number(3)
);

-- 반복처리
--1. 행 가져오기
--2. 근무기간 구하기, 급여순위 구하기
--3. 결과 테이블에 입력

declare 
    	cursor mycur is select sabun, saname, sapay, sahire from sawon;
            	v_rank sawon_result.pay_rank%type;
            	v_work sawon_result.hire_bet%type;
	cnt number(3) := 0;
begin 
          for i in mycur loop
-- 근무기간
		v_work := floor(months_between(sysdate, i.sahire)/12) || '년 ' ||
			 floor(mod(months_between(sysdate, i.sahire), 12)) || '개월';
-- 급여석차
		v_rank := 0;
                         	select count(*)+1 into v_rank from sawon where sapay>i.sapay;
--                         v_rank := v_rank +1;
-- 결과 테이블에 입력
                         	insert into sawon_result(bun, name, pay, hiredate, pay_rank, hire_bet) values
                             		 (i.sabun, i.saname, i.sapay, i.sahire, v_rank, v_work);
--		cnt := mycur%rowcount;
            end loop;  
--	dbms_output.put_line('처리된 사원의 수는 ' || cnt || '명 입니다');
end;
/