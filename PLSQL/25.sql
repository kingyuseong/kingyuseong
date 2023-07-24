--*** 사용자 정의 에러 함수 : raise_application_error(-20001~20999m '메세지'-1024바이트이내 작성)
--rollback 명령 포함, 프로그램 종료(트리거 수행이 종료)

create or replace trigger t_dept_del
	after delete on dept
	for each row
begin
	raise_application_error(-20001,'부서정보는 삭제할 수 없습니다!!');
end;
/



