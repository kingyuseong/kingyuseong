-- 환불사유는 3가지만 추가함
-- 단순변심
-- 제품불량
-- 상품추가 후 재주문
insert into brefund values (s_brefund_brf_no.nextval, '제품불량', '22/03/04', 0, 32);
insert into brefund values (s_brefund_brf_no.nextval, '단순변심', '19/03/05', 0, 35);
insert into brefund values (s_brefund_brf_no.nextval, '상품추가 후 재주문', '22/01/18', 0, 38);