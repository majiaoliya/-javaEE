<%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/9/29
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <img id="img_click" src="/checkCode">

  <script>
    var img = document.getElementById("img_click");
    img.onclick = function (ev) {
        alert("fuck");
        this.src = "/checkCode?type="+new Date();
    }
  </script>

  </body>
</html>
