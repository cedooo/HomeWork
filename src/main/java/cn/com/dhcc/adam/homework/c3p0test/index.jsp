<%@ page language="java" pageEncoding="UTF-8" import="cn.com.dhcc.adam.c3p0.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>C3P0</title>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<h2>C3P0</h2>
  	<%=new TestConnect().test() %>
  	<hr />
    <sql:query var="rs" dataSource="jdbc/c3p0">
	     select collecttime,
			IF(oav IS NOT  NULL , CONCAT(oav/1, ' V'), '不支持') as oav,
			IF(obv IS NOT  NULL , CONCAT(obv/1, ' V'), '不支持') as obv, 
			IF(ocv IS NOT  NULL , CONCAT(ocv/1, ' V'), '不支持') as ocv, 
			IF(oac IS NOT  NULL , CONCAT(oac/1, ' A'), '不支持') as oac, 
			IF(obc IS NOT  NULL , CONCAT(obc/1, ' A'), '不支持') as obc, 
			IF(occ IS NOT  NULL , CONCAT(occ/1, ' A'), '不支持') as occ 
		from v_azy_ups
    </sql:query>
    <c:forEach var="row" items="${rs.rows}">
             <%--${row.字段名}获取字段的值--%>
             ${row.oav}---${row.obv}---${row.ocv}---${row.oac}---${row.obc}---${row.occ}<br/>
     </c:forEach>
     <hr  />
     <h2>dbcp</h2>
    <sql:query var="countrys" dataSource="jdbc/world">
	     select * from country
    </sql:query>
    <c:forEach var="rowc" items="${countrys.rows}">
             <%--${row.字段名}获取字段的值--%>
             ${rowc.Name}---${rowc.Code}---${rowc.Population}---${rowc.Code2}<br/>
     </c:forEach>
     <hr />
     <h2>JDBC Pool</h2>
    <sql:query var="countrysfrompool" dataSource="jdbc/TomcatJdbcPool">
	     select * from country
    </sql:query>
    <c:forEach var="rowp" items="${countrysfrompool.rows}">
             <%--${row.字段名}获取字段的值--%>
             ${rowp.Name}---${rowp.Code}---${rowp.Population}---${rowp.Code2}<br/>
     </c:forEach>
  </body>
</html>
