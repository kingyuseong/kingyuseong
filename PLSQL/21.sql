*** Trigger(트리거)
-- 지정한 이벤트(DML)가 발생할 때마다 자동*으로 실행되는 PL/SQL 프로그램 객체 (호출문 없다)
-- 데이터 흐름 제어문(TCL) 사용할 수 없음(기본값)

-- 목적 
1. 업무의 자동화(연쇄작용, 예=급여계산, 연금계산, 재고관리,....)
2. 데이터 백업(복제) 기능
3. 이벤트를 발생시키는 사용자에 대한 감시 기능
4. 제약조건으로 구현할 수 없는 데이터 무결성 구현

-- 형식
create or replace trigger trigger_name
	[after | before] insert or update or delete on table_name  -- 이벤트 지정
	for each row 	-- 행 단위 트리거 ***
--declare
--	지역변수;
begin
	명령;
end;
/

--create table dept_info(info varchar2(20));
--부서 테이블에 부서정보가 입력되면, dept_info 테이블에 메세지를 입력
create or replace trigger t_deptInfo
	after insert on dept_ex
	for each row
begin
	insert into dept_info values('부서가 입력됨.');
end;
/