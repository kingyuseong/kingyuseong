1. 주민번호 형태의 값을 가지고 성별을 반환하는 함수
create or replace function f_sex
	(v_jumin varchar2)
	return varchar2
is
	sex_num number(1);
begin
	sex_num := substr(v_jumin, 8, 1);
	if sex_num = 1 or sex_num = 3 then return '남자';
	else return '여자';
	end if;
end;
/
--호출형태
--select goname, f_sex(gojumin) "성별" from gogek;



2. 숫자 형태의 값을 가지고 100의 '*'하나를 그래프처럼 반환하는 함수
create or replace function f_graph
	(v_sapay number)
	return varchar2
is
begin
	return lpad('*' , v_sapay/100, '*');		
end;
/

3. 날짜 형태의 값을 가지고 [xx년 xx개월]형태로 기간을 반환하는 함수
create or replace function f_gigan
	(v_sahire date)
	return varchar2
is
begin
	return floor(months_between(sysdate, v_sahire)/12) || '년 ' ||  floor(mod(months_between(sysdate, v_sahire), 12)) || '개월';
end;
/

--호출형태
col star format a50
col 근무기간 format a20
select saname, sapay, f_graph(sapay) star, sahire, f_gigan(sahire) 근무기간 from sawon;

4. 날짜에 년수, 개월수, 날수를 매개변수로 보내 더하는 함수를 생성하라
create or replace function add_date
	(hire date, y number, m number, d number)
	return date
is
begin
	return add_months(hire, (y*12 + m)) + d;
end;
/

-- (입사일로부터 년 수/개월/일 을 더해서 출력하는 함수)
--입사일로부터 3년 1개월 3일 더한값 출력
--적용 예) select saname, sahire, add_date(sahire, 3, 1, 3) "심사일" from sawon;


5. 주민번호를 가지고 나이를 계산하는 함수를 생성하라.
create or replace function f_jumin_age
	(jumin varchar2)
	return number
is
	year number(4) := substr(jumin, 1, 2); 
	sex_no number(1) := substr(v_jumin, 8, 1); 
begin
	if (sex_no = 1) or (sex_no = 2) then
		year := 1900+year;
	else year := 2000+year;
	end if;

 	return (to_char(sysdate, 'YYYY')-year)+1;
end;

end;
/
--적용 예) select goname, gojumin, f_sex(gojumin) "성별", f_jumin_age(gojumin) "나이" from gogek;












