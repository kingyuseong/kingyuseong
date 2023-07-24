alter table jumun add ju_rfstate varchar2(4);


update jumun set ju_rfstate='N' where ju_no=4;
update jumun set ju_rfstate='Y' where ju_no=5;
update jumun set ju_rfstate='N' where ju_no=6;



내가추가한거
insert into refund values (s_refund_rf_no.nextval, 14, '단순변심','23/04/01', 41000);