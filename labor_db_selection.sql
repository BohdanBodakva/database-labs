use labor_sql;

-- 1 
select * from outcome_o where `out` > 200 order by date desc;

-- 2
select name from ships where name like '%e%e%';

-- 3
select p.maker, p.type, l.speed, l.hd from product as p join laptop as l on l.model=p.model 
where l.ram >= 10;

-- 4
select distinct maker from product where type='PC' 
and maker not in (select maker from product where type='Laptop');

-- 5
select distinct p.maker from product as p join laptop as l on l.model=p.model 
where l.speed <= 500;

-- 6
select ship, battle, 
case 
	when result='OK' then 'в порядку'
    when result='sunk' then 'затонулий'
    when result='damaged' then 'пошкоджений'
end as result
from outcomes;

-- 7
select model, price from printer where price=(select max(price) from printer);

-- 8
select p.maker, min(pc.price) from product as p, pc
where p.model = pc.model
group by p.maker;

-- 9
select s.name, s.launched, c.* from ships as s join classes as c on s.class=c.class
where
	case when numGuns = 12 then 1 else 0 end +
	case when bore = 16 then 1 else 0 end +
	case when displacement = 46000 then 1 else 0 end +
	case when type = 'bc' then 1 else 0 end +
	case when launched = 1941 then 1 else 0 end +
	case when c.class = 'North Carolina' then 1 else 0 end +
	case when country = 'Gt.Britain' then 1 else 0 end 
>= 4;

-- 10
select c.class, count(*) from classes as c join ships as s on c.class=s.class 
group by c.class;

