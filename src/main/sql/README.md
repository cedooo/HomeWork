``` SQL SELECT * 
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
### [cnblog-sql笛卡尔积](http://www.cnblogs.com/jeriffe/archive/2011/05/19/2051121.html)
### [sqlguide-sql笛卡尔积](http://www.sqlguides.com/sql_cross_join.php)

[1]: https://zh.wikipedia.org/wiki/笛卡尔积
