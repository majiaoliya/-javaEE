<%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/10/9
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
    <%
        ServletRequest request1 = pageContext.getRequest();
        ServletResponse response1 = pageContext.getResponse();
        Object page1 = pageContext.getPage();
        ServletConfig servletConfig = pageContext.getServletConfig();
        Exception exception = pageContext.getException();
        HttpSession session1 = pageContext.getSession();
        JspWriter out1 = pageContext.getOut();
    %>
    <%=request1%> <br/>
    <%=response1%> <br/>
    <%=page1%> <br/>
    <%=servletConfig%> <br/>
    <%=exception%> <br/>
    <%=session1%> <br/>
</body>
</html>
