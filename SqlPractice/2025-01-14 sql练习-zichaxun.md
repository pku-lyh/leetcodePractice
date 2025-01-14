[626. 换座位](https://leetcode.cn/problems/exchange-seats/)

表: `Seat`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| student     | varchar |
+-------------+---------+
id 是该表的主键（唯一值）列。
该表的每一行都表示学生的姓名和 ID。
ID 序列始终从 1 开始并连续增加。
```

编写解决方案来交换每两个连续的学生的座位号。如果学生的数量是奇数，则最后一个学生的id不交换。

按 `id` **升序** 返回结果表。

```sql
select 
case
when id = (select count(*) from Seat) and id % 2 = 1 then id
when id % 2 = 1 then id + 1
when id % 2 = 0 then id - 1
end as id,
student
from Seat
order by id 
```



[1341. 电影评分](https://leetcode.cn/problems/movie-rating/)

表：`Movies`

```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| movie_id      | int     |
| title         | varchar |
+---------------+---------+
movie_id 是这个表的主键(具有唯一值的列)。
title 是电影的名字。
```

表：`Users`

```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| user_id       | int     |
| name          | varchar |
+---------------+---------+
user_id 是表的主键(具有唯一值的列)。
'name' 列具有唯一值。
```

表：`MovieRating`

```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| movie_id      | int     |
| user_id       | int     |
| rating        | int     |
| created_at    | date    |
+---------------+---------+
(movie_id, user_id) 是这个表的主键(具有唯一值的列的组合)。
这个表包含用户在其评论中对电影的评分 rating 。
created_at 是用户的点评日期。 
```

 

请你编写一个解决方案：

- 查找评论电影数量最多的用户名。如果出现平局，返回字典序较小的用户名。
- 查找在 `February 2020` **平均评分最高** 的电影名称。如果出现平局，返回字典序较小的电影名称。

**字典序** ，即按字母在字典中出现顺序对字符串排序，字典序较小则意味着排序靠前。

```sql
(
select u.name as results
from (Movies as m right join MovieRating as r on m.movie_id = r.Movie_id) 
left join Users as u on u.user_id = r.user_id
group by u.user_id
having count(*) = 
(select count(*) as cnt from MovieRating group by user_id order by cnt desc limit 1)
order by results
limit 1 
)
UNION ALL
(
select m.title as results
from (Movies as m right join MovieRating as r on m.movie_id = r.Movie_id) 
left join Users as u on u.user_id = r.user_id
where year(r.created_at) = 2020 and month(r.created_at) = 2
group by m.movie_id
having avg(r.rating) = 
(select avg(rating) as cnt from MovieRating where year(created_at) = 2020 and month(created_at) = 2 group by movie_id order by cnt desc limit 1)
order by results
limit 1
)
```



[1321. 餐馆营业额变化增长](https://leetcode.cn/problems/restaurant-growth/)

表: `Customer`

```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| customer_id   | int     |
| name          | varchar |
| visited_on    | date    |
| amount        | int     |
+---------------+---------+
在 SQL 中，(customer_id, visited_on) 是该表的主键。
该表包含一家餐馆的顾客交易数据。
visited_on 表示 (customer_id) 的顾客在 visited_on 那天访问了餐馆。
amount 是一个顾客某一天的消费总额。
```

 

你是餐馆的老板，现在你想分析一下可能的营业额变化增长（每天至少有一位顾客）。

计算以 7 天（某日期 + 该日期前的 6 天）为一个时间段的顾客消费平均值。`average_amount` 要 **保留两位小数。**

结果按 `visited_on` **升序排序**。

```sql
select c1.visited_on, sum(c2.amount) as amount, round(sum(c2.amount)/7,2) as average_amount
from ( SELECT DISTINCT visited_on FROM customer ) as c1 inner join Customer as c2 
ON datediff( c1.visited_on, c2.visited_on ) BETWEEN 0 AND 6 
where c1.visited_on >= (SELECT min( visited_on ) FROM customer ) + 6 
group by c1.visited_on
```

