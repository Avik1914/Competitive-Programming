select u.name as Name,sum(t.amount) as Balance from users u,transactions t where u.account=t.account group by u.name having sum(t.amount)>10000;
