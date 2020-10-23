<%@ page import="com.icis.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/9/30
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <%
        List<User> list = (List) request.getAttribute("list");
    %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>名字</th>
            <th>密码</th>
            <th>生日</th>
        </tr>
        <%
            for (User user : list) {
        %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getBirthday()%></td>
        </tr>

        <%
            }
        %>
    </table>
</body>
</html>
