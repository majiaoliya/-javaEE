<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/10/10
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>El表达四</title>
</head>
<body>
    <% request.setAttribute("fuck", "request show me fuck");%>
    <% pageContext.setAttribute("fuck", "pageContext show me fuck");%>
    <% application.setAttribute("fuck", "application show me fuck");%>
    ${requestScope.fuck} <br/>
    ${pageScope.fuck} <br/>
    ${applicationScope.fuck} <br/>

    <%
        List<String> list = new ArrayList<>();
        list.add("fuck"); list.add("shit"); list.add("<h1>shit</h1>");
        request.setAttribute("list", list);

        Map<String, String> mp = new HashMap<>();
        mp.put("fuck", "<h1>fuck</h1>");
        request.setAttribute("mp", mp);

        String str = "nullstr";
    %>
    ${requestScope.list[0]} <br/>
    ${requestScope.list[1]} <br/>
    ${requestScope.list[2]} <br/>
    ${requestScope.mp.fuck} <br/>

    ${not empty str}
</body>
</html>
