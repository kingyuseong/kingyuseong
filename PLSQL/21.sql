*** Trigger(Ʈ����)
-- ������ �̺�Ʈ(DML)�� �߻��� ������ �ڵ�*���� ����Ǵ� PL/SQL ���α׷� ��ü (ȣ�⹮ ����)
-- ������ �帧 ���(TCL) ����� �� ����(�⺻��)

-- ���� 
1. ������ �ڵ�ȭ(�����ۿ�, ��=�޿����, ���ݰ��, ������,....)
2. ������ ���(����) ���
3. �̺�Ʈ�� �߻���Ű�� ����ڿ� ���� ���� ���
4. ������������ ������ �� ���� ������ ���Ἲ ����

-- ����
create or replace trigger trigger_name
	[after | before] insert or update or delete on table_name  -- �̺�Ʈ ����
	for each row 	-- �� ���� Ʈ���� ***
--declare
--	��������;
begin
	���;
end;
/

--create table dept_info(info varchar2(20));
--�μ� ���̺� �μ������� �ԷµǸ�, dept_info ���̺� �޼����� �Է�
create or replace trigger t_deptInfo
	after insert on dept_ex
	for each row
begin
	insert into dept_info values('�μ��� �Էµ�.');
end;
/