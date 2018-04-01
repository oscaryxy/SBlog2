<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/28
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<h3 style="text-align: center">注册页面</h3>
<form action="regist" method="post">
    <table width="400"  border="1" align="center">
        <tr>
            <td><label>用户名：</label></td>
            <td><input type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td><label>登陆密码：</label></td>
            <td><input type="text" id="password" name="password"></td>
        </tr>
        <tr>
            <td><label>真实姓名：</label></td>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td><label>身份证号：</label></td>
            <td><input type="text" id="word" name="word"></td>
        </tr>
        <tr>
            <td><input type="button"  value="注册" onclick="saveinfo()"></td>
        </tr>
    </table>
</form>
<br>
<br>
   <p style="text-align: center">
       <a href="/index.jsp" rel="external nofollow">返回到登陆页面</a>
   </p>
<script type="text/javascript">
    function saveinfo() {
        var getinfo=new Object();
        getinfo.password=$('#password').val();
        getinfo.username=$('#username').val();
        getinfo.name=$('#name').val();
        getinfo.word=$('#word').val();
        $.ajax({
            type: 'post',
            cache:false,
            url: 'http://localhost:8080/user/login/regist',
            dataType: 'text',
            data: getinfo,
            success: function (data) {
                alert(data);
            },
            error:function () {
                alert("注册失败！");
            }
        })
    }
</script>
<style type="text/css">
    body{
        background-image: url(/image/loing.jpg);
        background-size: cover;
    }
</style>
</body>
</html>
