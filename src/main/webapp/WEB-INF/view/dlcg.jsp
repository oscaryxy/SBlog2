<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript"charset="utf-8" src="/ueditor/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript"charset="utf-8" src="/ueditor/utf8-jsp/ueditor.all.js"></script>
    <link href="/ueditor/utf8-jsp/themes/default/css/ueditor.css" rel="stylesheet">
    <script type="text/javascript"charset="utf-8" src="/ueditor/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>新建博文</title>
</head>
<body>
<br>
<h3 style="text-align: center">您好,${user.username},可以开始写博客了~~~</h3>
<br>
<br>
<br>
<form name="form11" action="/user/login" method="post" >

    <table border="1" width="1000">
        <tr>
            <td>博客标题</td>
            <td>
                <input type="text" name="blogname" id="blogname" value="" style="width:500px;height: 30px"/>
            </td>
        </tr>
        <tr>
            <td>作者名</td>
            <td>
                <input type="text" name="writername" id="writername" value="" style="width:300px" />
            </td>
        </tr>
        <tr>
            <td>关键字</td>
            <td>
                <input type="text" name="keyword" id="keyword" value="" style="width:300px" />
            </td>
        </tr>
        <tr>
            <td>博客内容</td>
            <td>
                <textarea name="blog" id="blog"style="width: 800px;height: 800px"></textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="button" value="保存" onclick="requestByJson()" />
            </td>
        </tr>
    </table>
</form>
<a href="/index.jsp" rel="external nofollow" >退出登陆</a>

<script type="text/javascript">
    function requestByJson() {
        var formData = new Object;
        formData.keyword = $('#keyword').val();
        formData.writername = $('#writername').val();
        formData.blogname = $('#blogname').val();
        formData.blog = $('#blog').val();
        var JsonData = JSON.stringify(formData);
        console.log(JsonData);
        $.ajax({
            type: 'post',
            cache:false,
            url: 'http://localhost:8080/user/login/saveblog',
            dataType: 'text',
            data: formData,
            success: function (data) {
                alert(data);
            },
            error:function () {
                alert("保存失败！");
            }
        } )
    }
</script>
<style type="text/css">
  body{
      background-image: url(/image/writer.jpg);
      background-size: cover;
  }
</style>
<script type="text/javascript">
    var ue=UE.getEditor("blog");
    ue.ready(function () {
        var value=new Object();
        value.blog=$("#blog").val();
        UE.getEditor("blog").getContent(value);
        //var txt=ue.getContent();
        //console.log("test********"+txt);
    })
</script>
</body>
</html>