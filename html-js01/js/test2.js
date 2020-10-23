var a = "<a href='#'>连接</a>";
var img = "<img src='../img/test.jpg'/>"
document.writeln(a);
document.writeln(img);
document.writeln();

function show99() {
    document.writeln("<table>");
    for(var i=1; i<=9; i++) {
        document.writeln("<tr>");
        for(var j=1; j<=i; j++) {
            document.write("<td>", j, "*", i, "=", i*j, (j==i ? "<br>" : "</td>"));
        }
        document.writeln("</tr>");
    }
    document.writeln("</table>");
}
var test3 = function (i) {
    console.log("耀西吃屎", i);
}
var p = [show99, test3, test3, test3];
for (var i=0; i<p.length; i++) {
    p[i](i);
}

var test2 = function (x, y) {
    return x + y;
}
console.log(test2(9, 7));

var obj = {name:'八戒', age:1, shit:'blue shit'};
obj = [1,2,3,4];
var s = obj.join(null);
console.log(s);
obj.push(5,6,7,8);
console.log(obj);

var reg = new RegExp('[\\w[4,6]');
var b = reg.test("admin");
b = parseInt("1101", 2);
console.log(b);

var str = "({'name':'耀西', 'age':18})";
var obj = eval((str));
var str2 = '{"name":"耀西", "age":18}';
var obj2 = JSON.parse(str2);
console.log(obj);
console.log(obj2);