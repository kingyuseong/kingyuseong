-- 외부(호출시)에서 값을 입력받기 : accept 변수 prompt '문자열'  // 입력받은 값은 프로그램 내에서 [&변수]형태로 사용
-- select ~ into ~ : 추출된 컬럼의 값은 반드시 into 구문의 변수(선언 필요)에 담아서 사용

-- 입력받은 사번의 사원이름을 출력하는 프로그램
set verify off
set serveroutput on

accept bun prompt '사번을 입력->'

declare
--	v_bun   sawon.sabun%type := &bun;
	v_name sawon.saname%type;
begin
	select saname into v_name from sawon where sabun=&bun;
	dbms_output.put_line(&bun || '번 사원의 이름 = ' || v_name);
--	dbms_output.put_line(v_bun || '번 사원의 이름 = ' || v_name);
end;
/

--*** PL/SQL에서의 변수 선언 방법
--v_name 	sawon.saname%type;	// sawon.saname과 같은 타입(길이) 선언 속성
--v_pay  constant  sawon.sapay%type := 2000;   	// 변경 불가능한 상수형 변수 선언!
--v_bun  		sawon.sabun%type := 15 not null; // 변수에 not null 제약설정!
--v_loc		dept.loc%type := '서울';
--a		sawon%rowtype;		// a.sabun, a.saname,... 변수를 한 번에 선언!!
