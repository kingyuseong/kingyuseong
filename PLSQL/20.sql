--주민번호를 가지고 유효성을 체크하는 함수
--select f_jumin_check('041201-3182518') from dual;  // 유효 or 비유효

--1. 0 4 1 2 0 1 - 3 1 8 2 5 1 8
--   * 
--   2 3 4 5 6 7   8 9 2 3 4 5 = (0*2)+(4*3)+... = 0+12+4+10+0+7+24+9+16+6+20+5 = 113
--2. 1번결과/11 나머지 = 3
--3. 11-2번결과           = 8
--4. 3번결과/10 나머지 = 8 => 주민번호 마지막 숫자와 같다면 유효



--호출형태
select f_jumin_check('010302-3564132') CK from dual;
select goname, gojumin, f_jumin_check(gojumin) CK from gogek;
