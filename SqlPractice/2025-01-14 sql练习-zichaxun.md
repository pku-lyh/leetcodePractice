[602. 好友申请 II ：谁有最多的好友](https://leetcode.cn/problems/friend-requests-ii-who-has-the-most-friends/)

`RequestAccepted` 表：

```
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| requester_id   | int     |
| accepter_id    | int     |
| accept_date    | date    |
+----------------+---------+
(requester_id, accepter_id) 是这张表的主键(具有唯一值的列的组合)。
这张表包含发送好友请求的人的 ID ，接收好友请求的人的 ID ，以及好友请求通过的日期。
```

 

编写解决方案，找出拥有最多的好友的人和他拥有的好友数目。

生成的测试用例保证拥有最多好友数目的只有 1 个人。

```sql
select requester_id as id, count(requester_id) as num from
(
select requester_id from RequestAccepted
union all
select accepter_id as requester_id from RequestAccepted 
) as q
group by id
order by num desc
limit 1
```

[585. 2016年的投资](https://leetcode.cn/problems/investments-in-2016/)

`Insurance` 表：

```
+-------------+-------+
| Column Name | Type  |
+-------------+-------+
| pid         | int   |
| tiv_2015    | float |
| tiv_2016    | float |
| lat         | float |
| lon         | float |
+-------------+-------+
pid 是这张表的主键(具有唯一值的列)。
表中的每一行都包含一条保险信息，其中：
pid 是投保人的投保编号。
tiv_2015 是该投保人在 2015 年的总投保金额，tiv_2016 是该投保人在 2016 年的总投保金额。
lat 是投保人所在城市的纬度。题目数据确保 lat 不为空。
lon 是投保人所在城市的经度。题目数据确保 lon 不为空。
```

 

编写解决方案报告 2016 年 (`tiv_2016`) 所有满足下述条件的投保人的投保金额之和：

- 他在 2015 年的投保额 (`tiv_2015`) 至少跟一个其他投保人在 2015 年的投保额相同。
- 他所在的城市必须与其他投保人都不同（也就是说 (`lat, lon`) 不能跟其他任何一个投保人完全相同）。

`tiv_2016` 四舍五入的 **两位小数** 。

```sql
select round(sum(tiv_2016), 2) as tiv_2016
from Insurance
where tiv_2015 in
(select tiv_2015 from Insurance group by tiv_2015 having count(tiv_2015)>1)
and concat(lat,lon) in
(select concat(lat,lon) from Insurance group by lat,lon having count(*) = 1)
```



[185. 部门工资前三高的所有员工](https://leetcode.cn/problems/department-top-three-salaries/)

表: `Employee`

```
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| name         | varchar |
| salary       | int     |
| departmentId | int     |
+--------------+---------+
id 是该表的主键列(具有唯一值的列)。
departmentId 是 Department 表中 ID 的外键（reference 列）。
该表的每一行都表示员工的ID、姓名和工资。它还包含了他们部门的ID。
```

 

表: `Department`

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
id 是该表的主键列(具有唯一值的列)。
该表的每一行表示部门ID和部门名。
```

 

公司的主管们感兴趣的是公司每个部门中谁赚的钱最多。一个部门的 **高收入者** 是指一个员工的工资在该部门的 **不同** 工资中 **排名前三** 。

编写解决方案，找出每个部门中 **收入高的员工** 。

以 **任意顺序** 返回结果表。

```sql
select d.name as DepartMent, e1.name as Employee, e1.salary 
from Employee as e1
left join Department as d
on e1.departmentId = d.id
where 3>
(select count(distinct(e2.salary)) from Employee as e2 where e2.salary > e1.salary and e1.departmentId = e2.departmentId)
```

