--�ش� �Ի�⵵�� �Ի��� ����� �ο����� ��ձ޿��� ����ϴ� ���ν���

--ȣ������
--variable result varchar2(100)
--exec p_state(1990, :result)
--print result		// [1990�� �Ի� �ο��� : XX��, ��ձ޿� : XXXX] ���·� ���

create or replace procedure p_state
   (v_hire   in number,
    result out varchar2)
is
	cnt 	number(10);
	pay_avg  number(10, 2);
begin
--   	select to_char(sahire,'yyyy')||'�� �Ի��ο���'|| count(*) ||'��ձ޿�'|| avg(sapay) into v_pay from sawon 
--   	where to_char(sahire,'yyyy')=v_hire 
--   	group by to_char(sahire,'yyyy');

   	select count(*), avg(sapay) into cnt, pay_avg from sawon 
   	where to_char(sahire,'yyyy')=v_hire;

	result := '�Ի�⵵:' || v_hire || '- �ο���:' || cnt || ', ��ձ޿�:' || pay_avg;
end;
/