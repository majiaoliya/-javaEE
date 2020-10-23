<%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/10/20
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="js/jquery-1.8.3.js"></script>
</head>
<body>
    <form>
        username : <input type="text" name="username" id="username"> <span id="showA"></span>
    </form>
    
    <script>
        $(function () {
            $("#username").blur(function () {
                var username = $("#username").val();
                $.get("/login", "username="+username, function (data) {

                }, "json");
            });
        })
    </script>
</body>
</html>
