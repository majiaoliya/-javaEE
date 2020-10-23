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
    <h3 style="text-align: center">欢迎[<font color="green">${user.username}</font>]访问用户信息列表</h3>

    <div style="float: left;">

        <form id="search_form" class="form-inline" action="${pageContext.request.contextPath}/pageServlet">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <c:if test="${not empty param.query_username}">
                    <input type="text" name="query_username" class="form-control" value="${param.query_username}" id="exampleInputName2" >
                </c:if>
                <c:if test="${empty param.query_username}">
                    <input type="text" name="query_username" class="form-control" value="" id="exampleInputName2" >
                </c:if>

            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <select name="query_address" class="form-control" id="exampleInputName3">
                    <c:if test="${not empty param.query_address}">
                        <option value ="${param.query_address}">${param.query_address}</option>
                    </c:if>
                    <c:if test="${empty param.query_address}">
                        <option value =""></option>
                    </c:if>

                    <option value =""></option>

                    <c:forEach items="${requestScope.query_address_list}" var="addr" varStatus="s">
                        <option value ="${addr.procince_name}">${addr.procince_name}</option>
                    </c:forEach>


                    <%--<option value="opel">Opel</option>--%>
                    <%--<option value="audi">Audi</option>--%>
                </select>
                <%--<input type="text" name="address" class="form-control" id="exampleInputName3" >--%>
            </div>

            <div class="form-group">
                <label for="example_sex">性别</label>
                <select name="query_sex" class="form-control" id="example_sex">

                    <c:if test="${not empty param.query_sex}">
                        <option value ="${param.query_sex}">${param.query_sex}</option>
                    </c:if>
                    <c:if test="${empty param.query_sex}">
                        <option value =""></option>
                    </c:if>
                    <option value ="男">男</option>
                    <option value ="女">女</option>
                    <option value =""></option>
                </select>
                <%--<input type="text" name="address" class="form-control" id="exampleInputName3" >--%>
            </div>

            <%--<div class="form-group">--%>
                <%--<label for="exampleInputEmail2">邮箱</label>--%>
                <%--<input type="email" name="email" class="form-control" id="exampleInputEmail2"  >--%>
            <%--</div>--%>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/pages/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0)" id="delete_check">删除选中</a>

    </div>
    <form action="${pageContext.request.contextPath}/deleteSelectUser" id="myform">

        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="checkAll"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${requestScope.pageBean.dataList}" var="user" varStatus="s">

                <tr>
                    <td><input type="checkbox" name="ids" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.username}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
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
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <c:if test="${pageBean.currentPage>1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${pageBean.currentPage-1}&pageSize=${pageBean.pageSize}&query_username=${param.query_username}&query_address=${param.query_address}&query_sex=${param.query_sex}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean.currentPage<=1}">
                    <li class="disabled" disabled="false">
                        <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${1}&pageSize=${pageBean.pageSize}&query_username=${param.query_username}&query_address=${param.query_address}&query_sex=${param.query_sex}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${pageBean.totPage}" var="i">
                    <c:if test="${i == pageBean.currentPage}">
                        <li class="active"><a href="${pageContext.request.contextPath}/pageServlet?currentPage=${i}&pageSize=${pageBean.pageSize}&query_username=${param.query_username}&query_address=${param.query_address}&query_sex=${param.query_sex}">${i}</a></li>
                    </c:if>
                    <c:if test="${i != pageBean.currentPage}">
                        <li><a href="${pageContext.request.contextPath}/pageServlet?currentPage=${i}&pageSize=${pageBean.pageSize}&query_username=${param.query_username}&query_address=${param.query_address}&query_sex=${param.query_sex}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${pageBean.currentPage<pageBean.totPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${pageBean.currentPage+1}&pageSize=${pageBean.pageSize}&query_username=${param.query_username}&query_address=${param.query_address}&query_sex=${param.query_sex}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean.currentPage>=pageBean.totPage}">
                    <li class="disabled" disabled="false">
                        <a href="${pageContext.request.contextPath}/pageServlet?currentPage=${pageBean.totPage}&pageSize=${pageBean.pageSize}&query_username=${param.query_username}&query_address=${param.query_address}&query_sex=${param.query_sex}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>



                <span style="font-size: 25px;margin-left: 5px;">
                    共${pageBean.totCount}条记录，共${pageBean.totPage}页
                </span>

            </ul>
        </nav>


    </div>


</div>

    <script>
        var checkAll = document.getElementById("checkAll");
        checkAll.checked = false;
        var arr = document.getElementsByName("ids");
        checkAll.onclick = function (ev2) {
            for(var i=0; i<arr.length; i++)
                arr[i].checked = checkAll.checked;
        }

        var delete_check = document.getElementById("delete_check");
        delete_check.onclick = function (ev) {
            var flag = false;
            for(var i=0; i<arr.length; i++) {
                if(arr[i].checked) { flag = true; break; }
            }
            if(flag) document.getElementById("myform").submit();
        }
    </script>
</body>
</html>

