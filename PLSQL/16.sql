--해당 입사년도에 입사한 사원의 인원수와 평균급여를 출력하는 프로시져

--호출형태
--variable result varchar2(100)
--exec p_state(1990, :result)
--print result		// [1990년 입사 인원수 : XX명, 평균급여 : XXXX] 형태로 출력

create or replace procedure p_state
   (v_hire   in number,
    result out varchar2)
is
	cnt 	number(10);
	pay_avg  number(10, 2);
begin
--   	select to_char(sahire,'yyyy')||'년 입사인원수'|| count(*) ||'평균급여'|| avg(sapay) into v_pay from sawon 
--   	where to_char(sahire,'yyyy')=v_hire 
--   	group by to_char(sahire,'yyyy');

   	select count(*), avg(sapay) into cnt, pay_avg from sawon 
   	where to_char(sahire,'yyyy')=v_hire;

	result := '입사년도:' || v_hire || '- 인원수:' || cnt || ', 평균급여:' || pay_avg;
end;
/