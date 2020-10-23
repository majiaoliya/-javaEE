<%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/10/20
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script src="js/jquery-1.8.3.js"></script>
  </head>
  <body>
      <input type="text" name="name">
      <input type="button" value="刷新" id="btn1">
      <input type="text" name="name" id="input2">
      <input type="button" value="刷新" id="btn2">
        <script>
            <%--$("#btn1").click(function () {--%>
                <%--location.href = "${pageContext.request.contextPath}/req";--%>
            <%--});--%>

            $("#btn1").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/req",
                    type:"POST",
                    data:{ "username":"QAQ", "age":28 },
                    success:function (data) {
                        alert(data);
                    },
                    error:function () {
                        alert("error")
                    },
                    dataType:"text"
                });

            })


            $("#btn2").click(function () {
                var text = $("#input2").val();
                $.post(
                    "/req",
                    {"username":text},
                    function (data) {
                        alert("数据为 : " + data)
                    }
                )
            })


        </script>
  </body>
</html>
