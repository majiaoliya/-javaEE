<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/10/10
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--导入包--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        List<String> list = new ArrayList<>();
        list.add("fuck"); list.add("shit"); list.add("shit");
        request.setAttribute("list", list);

        Map<String, String> mp = new HashMap<>();
        mp.put("fuck", "<h1>fuck</h1>");
        request.setAttribute("mp", mp);

        String str = "nullstr";
        Integer num = new Integer(0);
        request.setAttribute("num", num);
    %>

    <c:if test="${not empty list}">
        <h1>fuck</h1>
    </c:if>

    <c:forEach var="i" begin="0" end="${list.size()}" step="1" varStatus="s">
        <p>${s.count} = > ${i} + ${list[i]}</p>
    </c:forEach>

    <c:choose>
        <c:when test="${num > 1}">
            <p>大于一</p>
        </c:when>
        <c:when test="${num < 0}">
            <p>小于一</p>
        </c:when>
        <c:when test="${num == 0}">
            <p>为 0 </p>
        </c:when>
    </c:choose>

    <c:forEach items="${list}" var="name">
        ${name.length()} <br/>
    </c:forEach>

</body>
</html>
