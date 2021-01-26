/* Write your PL/SQL query statement below */
select se.actor_id,se.director_id from (select actor_id,director_id,count(director_id) c from ActorDirector group by actor_id,director_id) se where se.c>=3;
