/* Write your PL/SQL query statement below */
​
​
select customer_id,count(v.visit_id) as "count_no_trans" from visits v LEFT JOIN transactions t on v.visit_id=t.visit_id where t.transaction_id is null group by customer_id ;
