-- *** 반복문
--for 카운트변수 in 초기값..최대값 loop ~ end loop;

--1~10까지 출력
begin
	for i in 1..10 loop
		dbms_output.put_line('i의 값->' || i);
	end loop;
end;
/
--제어블럭 탈출 : exit;


--while 조건 loop ~ end loop;
--1~10까지 출력
declare
   i number(10) := 1;
begin
   while i < 11
      loop
         dbms_output.put_line('i is ->'|| i);
         i := i+1;
      end loop;
end;
/

--loop ~ end loop;
--1~10까지 출력
declare
   i number := 1;
begin
   loop
      dbms_output.put_line('i is ->' || i);
      i := i+1;
      exit when (i>10);
--   if i>10 then exit;
--   end if;
   end loop;
   end;
/










