/* Write your PL/SQL query statement below */
​
select m.name as name,y.summ as balance from users m,(select u.account as account_number,sum(t.amount) as summ  from users u,transactions t where u.account=t.account group by u.account) y where m.account=y.account_number and y.summ>10000;
