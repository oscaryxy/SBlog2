
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
</head>
<body>
登陆失败!
${message}
<br>
<a href="<%=path%>/index.jsp" rel="external nofollow" >返回登陆页面</a>
<style type="text/css">
    body{
        background-image: url(/image/loing.jpg);
        background-size: cover;
    }
</style>
</body>
</html>