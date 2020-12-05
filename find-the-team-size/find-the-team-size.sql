/* Write your PL/SQL query statement below */
select employee_id,team_size from employee e,(select team_id,count(employee_id) as team_size from employee group by team_id) t where e.team_id=t.team_id;
