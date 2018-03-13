<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/11
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%--
 Created by IntelliJ IDEA.
 User: alvin
 Date: 15/9/8
 Time: 下午6:22
 To change this template use File | Settings | File Templates.
--%>
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
登入失败!
${message}
<br>
<a href="<%=path%>/index.jsp" rel="external nofollow" >返回</a>
</body>
</html>