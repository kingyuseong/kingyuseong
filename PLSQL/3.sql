-- *** �ݺ���
--for ī��Ʈ���� in �ʱⰪ..�ִ밪 loop ~ end loop;

--1~10���� ���
begin
	for i in 1..10 loop
		dbms_output.put_line('i�� ��->' || i);
	end loop;
end;
/
--����� Ż�� : exit;


--while ���� loop ~ end loop;
--1~10���� ���
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
--1~10���� ���
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










