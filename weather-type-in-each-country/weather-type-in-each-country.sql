/* Write your PL/SQL query statement below */


select c.country_name,
CASE WHEN avg(w.weather_state)<=15 THEN 'Cold'
   WHEN avg(w.weather_state)>=25 THEN 'Hot'
   ELSE 'Warm' END "weather_type"
from countries c,weather w where w.day between '2019-11-01' and '2019-11-30' and c.country_id=w.country_id group by c.country_name;