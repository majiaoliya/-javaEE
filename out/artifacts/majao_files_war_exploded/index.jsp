<%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/10/1
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <%
      request.setAttribute("name", "马角的逆袭");
      request.setAttribute("lef", 1023);
      request.setAttribute("rig", 1024);
    %>
    ${requestScope.name}
    <br/>
    ${requestScope.lef + requestScope.rig}
    ${empty requestScope.name }
  </body>
</html>
