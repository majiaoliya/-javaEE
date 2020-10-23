<%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/10/2
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <form action="/upload_servlet" method="post"  enctype="multipart/form-data">
        <input type="file" name="majiao_file">
        <input type="submit" value="上传文件">
    </form>
</body>
</html>
