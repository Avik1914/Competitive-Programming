/* Write your PL/SQL query statement below */
​
select unique_id,name from employees e LEFT JOIN employeeuni u on e.id=u.id;
​
