delimiter //
  create procedure count_role(in p_role_name varchar, out count_total int,date exec_date date)
    BEGIN
      select count(*) into count_total from (select * from t_role where role_name like '%'||p_role_name||'%') role;
      select  into exec_date from dual;
    END
    // 


create or replace 
PROCEDURE count_role(
p_role_name in varchar,
count_total out int,
exec_date out date)
IS
BEGIN
select count(*) into count_total from t_role where role_name like '%' ||p_role_name|| '%';
select sysdate into exec_date from dual;
End;