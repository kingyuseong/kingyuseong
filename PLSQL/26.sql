-- 사원의 급여가 변경되면,

--1. 에러 발생
--2. 변경하려는 급여가 기존 급여보다 적거나, 기존 급여의 20% 초과하면 에러 발생(부장은 제외)
--3. 변경한 정보(사용자, 날짜(시간포함), 변경한 사번, 변경전급여, 변경후급여)를 black_list 테이블 입력(black_list table생성)

drop table black_list;
create table black_list
		(session_name varchar2(20) default user,
		 time varchar2(30) default to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),
		 sabun varchar2(10),
		 before_sapay number(10),
		 after_sapay number(10)
);

create or replace trigger t_gamsi
	after update of sapay on sawon
	for each row
	when (old.sajob != '부장')
declare
	PRAGMA AUTONOMOUS_TRANSACTION;
begin
--1. 	raise_application_error(-20001, '급여의 변경이 불가합니다');

--2.
--   	if (:new.sapay < :old.sapay) or (:new.sapay > :old.sapay*1.2)  then
--     		raise_application_error(-20001, '급여가 범위안의 값이 아닙니다!');
--	end if;

--3.   	
	insert into black_list(sabun, before_sapay, after_sapay) values(:new.sabun, :old.sapay, :new.sapay);
	commit;
	raise_application_error(-20001, '급여의 변경이 불가하며, 변경을 시도한 정보는 기록되었습니다.');

end;
/

--트리거 정보 변경
alter table table_name [disable | enable] all triggers;
alter trigger trigger_name [disable | enable];