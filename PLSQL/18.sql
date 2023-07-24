create or replace function f_name
	(name varchar2)
	return varchar2
is
begin
	return substr(name, 2, 4);
end;
/

--호출형태
select saname, f_name(saname) name from sawon;
select f_name(goname) name, gotel from gogek;


