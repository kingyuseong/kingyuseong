***  Procedure(프로시저)
--자주 실행되는 SQL & PL/SQL을 미리 컴파일 -> 호출(실행)만* 해서 사용하는 객체
--목적 
	데이터 처리(DML) -> 대상 테이블이 반드시 존재***
	성능 향상(속도 빠름) -> 한 번의 컴파일로 호출만 해서 사용
	메모리 절약 -> 동일한 프로시져를 여러 사용자가 호출하더라도 하나의 메모리 사용

--테이블이 아닌 프로시저 단위의 사용권한을 부여하므로 보안성을 강화
grant execute on 프로시져 to ~

--파라미터 변수 mode(type만 지정!->길이는 지정 안됨)
	-in mode : 호출될 때 값을 받는 변수 ***
	-out mode : 프로시져가 호출된 후 결과값을 호출한 곳에 넘겨주는 변수
	-in out mode : 호출할때 값이 들어가서 실행된 결과는 넘겨주는 변수

--형식
create or repalce procedure pro_name
	(파라미터변수 [(in) | out] type,...)
is
--지역 변수 선언;
begin

end;
/

--오류정보
--user_errors 뷰
--show error 객체타입 객체명