
SQL 笛卡尔积
``` SQL 
SELECT * 
FROM (
	SELECT n_node_id as id1, vc_node_name as name1
	from t_node
	where N_NODE_ID in (9)
) as Aa CROSS JOIN 
( 
	select n_node_id as id2, vc_node_name as name2
FROM t_node
WHERE N_NODE_ID not in (9)
) as Ab 
```
### [笛卡尔积][1]
![math](https://upload.wikimedia.org/math/6/1/1/6118009d120c4f03ad9a5f56f6f90dc1.png)
> 实例，如果集合X是13个元素的点数集合{ A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2 }，而集合Y是4个元素的花色集合{♠, ♥, ♦, ♣}，则这两个集合的笛卡儿积是有52个元素的标准扑克牌的集合{ (A, ♠), (K, ♠), ..., (2, ♠), (A, ♥), ..., (3, ♣), (2, ♣) }。

### [cnblog-sql笛卡尔积](http://www.cnblogs.com/jeriffe/archive/2011/05/19/2051121.html)
```
DECLARE @Temp TABLE
(GroupID INT , 
GroupName VARCHAR(25),
ItemNumber varchar(25)
)
INSERT INTO @Temp
SELECT 1,'5805','27-196-018'
UNION
SELECT 1,'5805','27-196-019'
UNION
SELECT 2,'5805','27-196-020'
UNION
SELECT 2,'5805','27-196-021'
UNION
SELECT 3,'5805','27-196-022'
UNION
SELECT 3,'5805','27-196-023'

SELECT 
    G1_GroupID 
   ,G1_ItemNumber 
   ,G2_GroupID 
   ,G2_ItemNumber  
FROM ( 
        SELECT 
            GroupID AS G1_GroupID 
           ,ItemNumber AS G1_ItemNumber 
        FROM @Temp  
        WHERE 
            GroupID   IN(1) 
     ) AS A CROSS JOIN  ( 
        SELECT 
            GroupID AS G2_GroupID 
           ,ItemNumber AS G2_ItemNumber 
        FROM @Temp   
        WHERE 
            GroupID NOT IN(1) 
     ) AS B 
ORDER BY A.G1_GroupID,A.G1_ItemNumber
/*Result
 *    1    27-196-018    2    27-196-020
 *    1    27-196-018    2    27-196-021
 *    1    27-196-018    3    27-196-022
 *    1    27-196-018    3    27-196-023
 *    1    27-196-019    2    27-196-020
 *    1    27-196-019    2    27-196-021
 *    1    27-196-019    3    27-196-022
 *    1    27-196-019    3    27-196-023
 */
```
 
### [sqlguide-sql笛卡尔积](http://www.sqlguides.com/sql_cross_join.php)
**SQL CROSS JOIN** will return all records where each row from the first table is combined with each row from the second table. Which also mean CROSS JOIN returns the Cartesian product of the sets of rows from the joined tables.

**A CROSS JOIN** can be specified in two ways: using the **JOIN** syntax or by listing the tables in the FROM clause separated by commas without using a WHERE clause to supply join criteria.

SQL CROSS JOIN syntax:
```
SELECT * FROM [TABLE 1] CROSS JOIN [TABLE 2]
```
OR
```
SELECT * FROM [TABLE 1], [TABLE 2]
```
[1]: https://zh.wikipedia.org/wiki/笛卡尔积
