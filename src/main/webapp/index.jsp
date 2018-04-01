<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>博客登陆</title>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<form name="form1" action="/user/login" method="post" >
    <table width="350" border="1" align="center">
        <tr>
            <td colspan="2"style="text-align: center">博客登入窗口</td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="submit" value="登录"/>
                <a href="/regist.jsp" rel="external nofollow" >注册</a>
            </td>
        </tr>
    </table>
</form>
<style type="text/css">
    body{
        background-image: url(image/loing.jpg);
        background-size: cover;
    }
</style>
</body>
</html>