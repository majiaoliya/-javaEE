<%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/9/30
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        span {
            color: red;
        }
    </style>
</head>
<body>
    <% String str = "majiao"; %>
    <%= str %>
    <% out.write("<span>" + str + "</span>");%>
    <% response.getWriter().write("<span>" + str + "</span>");%>
    <%
        for(int i=0; i<8; i++) {
    %>
    <span><%= str %></span> <br/>
    <%
        }
    %>
</body>
</html>
