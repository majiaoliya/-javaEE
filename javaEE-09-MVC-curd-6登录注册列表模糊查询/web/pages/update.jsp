
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
    	<%--<base href="<%=basePath%>"/>--%>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/updateUser" method="post">

            <input type="hidden" name="id" value="${requestScope.update_user.id}"/>
            
          <div class="form-group">
            <label for="username">姓名：</label>
            <c:if test="${not empty requestScope.update_user.username}">
                <input type="text" class="form-control" id="username" name="username"  readonly="readonly" placeholder="${requestScope.update_user.username}" value="${requestScope.update_user.username}"/>
            </c:if>
            <c:if test="${empty requestScope.update_user.username}">
                <input type="text" class="form-control" id="username" name="username"  readonly="readonly" placeholder="请输入姓名" />
            </c:if>

          </div>

          <div class="form-group">
            <label>性别：</label>
              <input type="radio" name="sex" value="男"  />男
                <input type="radio" name="sex" value="女"  />女
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <c:if test="${not empty requestScope.update_user.age}">
                <input type="text" class="form-control" id="age"  name="age" placeholder="${requestScope.update_user.age}" value="${requestScope.update_user.age}" />
            </c:if>
            <c:if test="${empty requestScope.update_user.age}">
                <input type="text" class="form-control" id="age"  name="age" placeholder="年龄" />
            </c:if>
          </div>

          <div class="form-group">
            <c:if test="${not empty requestScope.update_user.address}">
                <label for="address">籍贯：</label>
                <select name="address" class="form-control" id="address" >
                    <c:forEach items="${requestScope.address_list}" var="addr" varStatus="s" >
                        <option value="${addr.procince_name}">${addr.procince_name}</option>
                    </c:forEach>
                </select>
            </c:if>
            <c:if test="${empty requestScope.update_user.address}">
                <label for="address">籍贯：</label>
                  <select name="address" class="form-control" id="address" >
                      <c:forEach items="${requestScope.address_list}" var="addr" varStatus="s" >
                          <option value="${addr.procince_name}">${addr.procince_name}</option>
                      </c:forEach>
                </select>
            </c:if>
          </div>

          <div class="form-group">
            <label for="qq" id="qq">QQ：</label>
            <c:if test="${not empty requestScope.update_user.qq}">
                <input type="text" class="form-control" id="qq"  name="qq" placeholder="${requestScope.update_user.qq}" value="${requestScope.update_user.qq}" />
            </c:if>
            <c:if test="${empty requestScope.update_user.qq}">
                <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码"/>
            </c:if>
          </div>

          <div class="form-group">
            <label for="email" id="email">Email：</label>
            <c:if test="${not empty requestScope.update_user.email}">
                <%--<input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄" />--%>
                <input type="text" class="form-control" name="email" value="${requestScope.update_user.email}" placeholder="${requestScope.update_user.email}"/>
            </c:if>
             <c:if test="${empty requestScope.update_user.email}">
                 <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址"/>
            </c:if>

          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
        <script>

        </script>
    </body>
</html>