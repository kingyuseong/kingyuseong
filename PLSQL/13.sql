--��� ���̺� ��� ������ �Է��ϴ� ���ν���
--����� �������� �̿��ϰ�(201~299, 2������)
--�Ի����� ���糯¥�� �Էµǰ�,
--Ŀ�̼��� ��å ���ǿ� ���� �Է�(��å�� �븮 -> �޿��� 10%, ���� -> �޿��� 15%, ����-> �޿��� 20%, �� ���� ��å-> 0)
--�����ڹ�ȣ�� �μ��� �������̸�, 3�� ����� �Է��ϰ�, �ѹ����̸� 10�� ����� �Է��ϰ�, ������̸� 6�� ����� �Էµǵ��� �Ѵ�.

--ȣ������
--exec p_sawon_in('ȫ����', 3000, '�븮', '����', '������')

create sequence s_sawon_sabun
increment by 2
start with 201
maxvalue 299;

create or replace procedure p_sawon_in(
    v_saname sawon.saname%type,
    v_sapay sawon.sapay%type,
    v_sajob sawon.sajob%type,
    v_sasex sawon.sasex%type,
    v_dname dept.dname%type )
is
--  dname_dept dept.deptno%type;
--  v_comm sawon.comm%type;
   v_samgr sawon.samgr%type;
begin
--   select deptno into dname_dept from dept where dname = v_dname;
   
--   if v_sajob = '�븮' then
--      v_comm := v_sapay*0.1;
--   elsif v_sajob = '����' then
--      v_comm := v_sapay*0.15;
--   elsif v_sajob = '����' then
--      v_comm := v_sapay*0.20;
--   end if;

   if v_dname = '������' then
      v_samgr := 3;
   elsif v_dname = '�ѹ���' then
      v_samgr := 10;
   elsif v_dname = '�����' then
      v_samgr := 6;
   end if;

   insert into sawon (sabun, saname, sapay, sajob, sasex, deptno, comm, samgr, sahire)
--      values (s_sawon_sabun.nextval, v_saname, v_sapay, v_sajob,v_sasex, dname_dept, v_comm, v_samgr, sysdate);
   values (s_sawon_sabun.nextval, 
	v_saname, 
	v_sapay, 
	v_sajob,
	v_sasex, 
	(select deptno from dept where dname = v_dname), 
	(case v_sajob when '�븮' then v_sapay*0.1 when '����' then v_sapay*0.15 when '����' then v_sapay*0.2 else 0 end),
	v_samgr, 
	sysdate);
  commit;
end;
/
