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
### [sql笛卡尔积](http://database.51cto.com/art/201105/263293.htm)
