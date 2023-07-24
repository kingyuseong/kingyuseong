-- ���, �����, �޿�, �Ի����� �о�鿩�� �ٹ��Ⱓ, �޿������� ���� ��, 
-- sawon_result ���̺�(���) �� ��������� ó���� ����� �����ϴ� Ŀ��
create table sawon_result(
	bun number(10),
	name varchar2(10), 
	pay number(10), 
	hiredate date, 
	hire_bet varchar2(20), 
	pay_rank number(3)
);

-- �ݺ�ó��
--1. �� ��������
--2. �ٹ��Ⱓ ���ϱ�, �޿����� ���ϱ�
--3. ��� ���̺� �Է�

declare 
    	cursor mycur is select sabun, saname, sapay, sahire from sawon;
            	v_rank sawon_result.pay_rank%type;
            	v_work sawon_result.hire_bet%type;
	cnt number(3) := 0;
begin 
          for i in mycur loop
-- �ٹ��Ⱓ
		v_work := floor(months_between(sysdate, i.sahire)/12) || '�� ' ||
			 floor(mod(months_between(sysdate, i.sahire), 12)) || '����';
-- �޿�����
		v_rank := 0;
                         	select count(*)+1 into v_rank from sawon where sapay>i.sapay;
--                         v_rank := v_rank +1;
-- ��� ���̺� �Է�
                         	insert into sawon_result(bun, name, pay, hiredate, pay_rank, hire_bet) values
                             		 (i.sabun, i.saname, i.sapay, i.sahire, v_rank, v_work);
--		cnt := mycur%rowcount;
            end loop;  
--	dbms_output.put_line('ó���� ����� ���� ' || cnt || '�� �Դϴ�');
end;
/