create table emp(
	empid number(10) constraint emp_empid_pk primary key,
	ename varchar2(10),
	loan_ck varchar2(2) default 'N'
);
insert into emp(empid, ename) values(1, 'È«µ¿¿ì');
insert into emp(empid, ename) values(2, 'Â÷½Â¿ø');
insert into emp(empid, ename) values(3, '°­µ¿¿ø');
commit;

create table loan(
	eid number(10) constraint loan_eid_fk references emp(empid),
	amount number(10),
	loan_date date default sysdate
);

create or replace trigger t_emp_loan
   	after insert or delete or update of eid on loan
   	for each row
begin
  	if inserting then
     		 update emp set loan_ck ='Y' where empid=:new.eid;
   	elsif deleting then
      		update emp set loan_ck = 'N' where empid=:old.eid;
   	elsif updating then
      		update emp set loan_ck='N' where empid=:old.eid;
      		update emp set loan_ck='Y' where empid=:new.eid; 
   	end if;
end;
/
