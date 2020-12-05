/* Write your PL/SQL query statement below */
​
select warehouse_name,sum(volume) as volume from (select w.name as warehouse_name,(p.width*p.length*p.height*w.units) as volume from warehouse w,products p where w.product_id=p.product_id) group by warehouse_name;
