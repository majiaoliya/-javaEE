<%--
  Created by IntelliJ IDEA.
  User: majiao
  Date: 2020/10/20
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <script>
        var arr = ["left", "right"];
        var girl = { name:"李四", "age":17, hobby:arr[1] };
        var person = { name:"张三", "age":28, hobby:arr[0], gf:girl };
        var person1 = { name:"赵三", "age":28, hobby:arr[0], gf:girl };
        var person2 = { name:"王三", "age":28, hobby:arr[0], gf:girl };
        console.log(person);
        console.log(person.name);
        console.log(person.age);
        console.log(person.hobby);
        var list = [girl, person, person1, person2 ];
        for(var i=0; i<list.length; i++) {
            for(var key in list[i]) {
                console.log(list[i][key]);
            }
        }

    </script>
</body>
</html>
