# c3p0 
>
- [c3p0/tomcat-specific](http://www.mchange.com/projects/c3p0/#tomcat-specific)
```
<Resource auth="Container"
	          description="DB Connection"
		  driverClass="com.mysql.jdbc.Driver"
		  maxPoolSize="4"
		  minPoolSize="2"
		  acquireIncrement="1"
		  name="jdbc/TestDB"
		  user="test"
		  password="ready2go"
		  factory="org.apache.naming.factory.BeanFactory"
		  type="com.mchange.v2.c3p0.ComboPooledDataSource"
		  jdbcUrl="jdbc:mysql://localhost:3306/test?autoReconnect=true" />
```
- [Tomcat 7 JNDI DataBase pool/DBCP](http://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html)
```
<Resource name="jdbc/TestDB" auth="Container" type="javax.sql.DataSource"
               maxActive="100" maxIdle="30" maxWait="10000"
               username="javauser" password="javadude" driverClassName="com.mysql.jdbc.Driver"
               url="jdbc:mysql://localhost:3306/javatest"/>
```               
- [Tomcat JDBC Connection Pool](http://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html)
```
	<Resource name="jdbc/TestDB"
          auth="Container"
          type="javax.sql.DataSource"
          factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
          testWhileIdle="true"
          testOnBorrow="true"
          testOnReturn="false"
          validationQuery="SELECT 1"
          validationInterval="30000"
          timeBetweenEvictionRunsMillis="30000"
          maxActive="100"
          minIdle="10"
          maxWait="10000"
          initialSize="10"
          removeAbandonedTimeout="60"
          removeAbandoned="true"
          logAbandoned="true"
          minEvictableIdleTimeMillis="30000"
          jmxEnabled="true"
          jdbcInterceptors="org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;
            org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer"
          username="root"
          password="password"
          driverClassName="com.mysql.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/mysql"/>
```          

<h4>其它</h4>
>
- [jstl-sql](http://www.runoob.com/jsp/jsp-database-access.html)
- [oracle-jstl-tag](http://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/)
- [mybatis数据源池](http://mybatis.org/mybatis-3/zh/configuration.html#environments)
	- poolMaximumActiveConnections – 在任意时间可以存在的活动（也就是正在使用）连接数量，默认值：10
	- poolMaximumIdleConnections – 任意时间可能存在的空闲连接数。