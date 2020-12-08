/* Write your PL/SQL query statement below */
​
​
select u.name name,NVL(t.totDis,0) travelled_distance from users u LEFT JOIN (select user_id udis,sum(distance) totDis from rides r group by user_id) t on u.id=t.udis order by 2 desc,1 asc;
