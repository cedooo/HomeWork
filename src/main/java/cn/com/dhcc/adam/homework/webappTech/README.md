Servlet Container Web Application Deployment Descriptor:<br />
<a href="http://tomcat.apache.org/tomcat-6.0-doc/appdev/deployment.html#Web_Application_Deployment_Descriptor" target="_blank" >Tomcat 6</a>
<hr />
complete syntax and semantics for the deployment descriptor:<br />
<a href="http://download.oracle.com/otn-pub/jcp/servlet-2.5-mrel2-eval-oth-JSpec/servlet-2_5-mrel2-spec.pdf?AuthParam=1443080533_3be7783902627540e030565c96a68f28" target="_blank">Servlet 2.5 Specification @Chapter 13</a>
<hr />
url-pattern<br />
                        |-- Context Path --|-- Servlet Path -|--Path Info--|
http://www.myserver.com     /mywebapp        /helloServlet      /hello
                        |-------- Request URI  ----------------------------|

Remember the following three points:
1. Request URI = context path + servlet path + path info.
2. Context paths and servlet paths start with a / but do not end with it.
3. HttpServletRequest provides three methods getContextPath(),
    getServletPath() and getPathInfo() to retrieve the context path,
    the servlet path, and the path info, respectively, associated with a request.
