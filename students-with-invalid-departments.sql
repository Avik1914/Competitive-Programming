/* Write your PL/SQL query statement below */
select s.id,s.name from students s where s.department_id not in(select distinct id from Departments); 
