<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="java.util.HashMap" %>--%>
<%--<%@ page import="java.util.Map" %>&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: majiao--%>
  <%--Date: 2020/10/10--%>
  <%--Time: 14:05--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--&lt;%&ndash;导入包&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>




<%--<!DOCTYPE html>--%>
<%--<!-- 网页使用的语言 -->--%>



<%--<html lang="zh-CN">--%>
<%--<head>--%>
    <%--<!-- 指定字符集 -->--%>
    <%--<meta charset="utf-8">--%>
    <%--<!-- 使用Edge最新的浏览器的渲染方式 -->--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。--%>
    <%--width: 默认宽度与设备的宽度相同--%>
    <%--initial-scale: 初始的缩放比，为1:1 -->--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->--%>
    <%--<title>用户信息管理系统</title>--%>

    <%--<!-- 1. 导入CSS的全局样式 -->--%>
    <%--<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<!-- 2. jQuery导入，建议使用1.9以上的版本 -->--%>
    <%--<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>--%>
    <%--<!-- 3. 导入bootstrap的js文件 -->--%>
    <%--<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>--%>
    <%--<style type="${pageContext.request.contextPath}/text/css">--%>
        <%--td, th {--%>
            <%--text-align: center;--%>
        <%--}--%>
    <%--</style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
    <%--<h3 style="text-align: center">用户信息列表</h3>--%>
    <%--<table border="1" class="table table-bordered table-hover">--%>
        <%--<tr class="success">--%>
            <%--<th>编号</th>--%>
            <%--<th>姓名</th>--%>
            <%--<th>性别</th>--%>
            <%--<th>年龄</th>--%>
            <%--<th>籍贯</th>--%>
            <%--<th>QQ</th>--%>
            <%--<th>邮箱</th>--%>
            <%--<th>操作</th>--%>
        <%--</tr>--%>
        <%--<c:forEach var="i" begin="0" end="${all_users.size()-1}">--%>
            <%--<tr>--%>
                <%--<td>${all_users[i].id}</td>--%>
                <%--<td>${all_users[i].username}</td>--%>
                <%--<td>${all_users[i].gender}</td>--%>
                <%--<td>保密</td>--%>
                <%--<td>广东</td>--%>
                <%--<td>${all_users[i].tel}</td>--%>
                <%--<td>${all_users[i].email}</td>--%>
                <%--<td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <%--<!----%>
        <%--<tr>--%>
            <%--<td>1</td>--%>
            <%--<td>张三</td>--%>
            <%--<td>男</td>--%>
            <%--<td>20</td>--%>
            <%--<td>广东</td>--%>
            <%--<td>44444222</td>--%>
            <%--<td>zs@qq.com</td>--%>
            <%--<td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>2</td>--%>
            <%--<td>张三</td>--%>
            <%--<td>男</td>--%>
            <%--<td>20</td>--%>
            <%--<td>广东</td>--%>
            <%--<td>44444222</td>--%>
            <%--<td>zs@qq.com</td>--%>
            <%--<td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>3</td>--%>
            <%--<td>张三</td>--%>
            <%--<td>男</td>--%>
            <%--<td>20</td>--%>
            <%--<td>广东</td>--%>
            <%--<td>44444222</td>--%>
            <%--<td>zs@qq.com</td>--%>
            <%--<td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>4</td>--%>
            <%--<td>张三</td>--%>
            <%--<td>男</td>--%>
            <%--<td>20</td>--%>
            <%--<td>广东</td>--%>
            <%--<td>44444222</td>--%>
            <%--<td>zs@qq.com</td>--%>
            <%--<td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>5</td>--%>
            <%--<td>张三</td>--%>
            <%--<td>男</td>--%>
            <%--<td>20</td>--%>
            <%--<td>广东</td>--%>
            <%--<td>44444222</td>--%>
            <%--<td>zs@qq.com</td>--%>
            <%--<td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>--%>
        <%--</tr>--%>
        <%---->--%>
        <%--<tr>--%>
            <%--<td colspan="8" align="center"><a class="btn btn-primary" href="add.html">添加联系人</a></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>


















<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src=${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/pages/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/pages/add.html">删除选中</a>

    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${all_users}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox"></td>
                <td>${s.count}</td>
                <td>${user.username}</td>
                <td>${user.gender}</td>
                <td>保密</td>
                <td>保密</td>
                <td>${user.qq}</td>
                <%--<td>${user.tel}</td>--%>
                <td>${user.email}</td>
                <%--<<input type="hidden" name="">--%>

                <%--<input type="hidden" name="id" value="${user.id}">--%>
                <%--<input type="hidden" name="name" value="${user.name}">--%>
                <%--<input type="hidden" name="gender" value="${user.gender}">--%>
                <%--<input type="hidden" name="age" value="${user.age}">--%>
                <%--<input type="hidden" name="address" value="${user.address}">--%>
                <%--<input type="hidden" name="qq" value="${user.qq}">--%>
                <%--<input type="hidden" name="email" value="${user.email}">--%>

                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/getUserById?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteUser?id=${user.id}">删除</a></td>

                <%--<td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/pages/update.jsp?id=${user.id}&username=${user.username}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteUser">删除</a></td>--%>
            </tr>

        </c:forEach>


    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共16条记录，共4页
                </span>

            </ul>
        </nav>


    </div>


</div>


</body>
</html>

