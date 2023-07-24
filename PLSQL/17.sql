*** Function(함수)
-- 반복되는 복잡하고 어려운 수식을 미리 생성하여 호출만 해서 사용하기 위한 객체
-- 데이터 조작(DML) 목적이 아니므로 대상 테이블이 없다*** - insert를 제외한 DML사용 불가!!
-- 함수 사용 가능한 모든 곳에서 호출 가능하므로 문장의 일부처럼 사용 가능(호출문이 없다)
-- in mode만 사용(반드시 리턴값이 1개 존재하니까)

-- 형식 
create or replace function func_name
	(파라미터변수 type,...)
	return type	-- 길이지정 안함
is
-- 지역변수 선언;
begin
	명령;
	return [값|변수];	
end;
/