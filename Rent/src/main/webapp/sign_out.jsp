<%--
退出界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出登录</title>
    <link rel="stylesheet" href="./layui/css/layui.css"  media="all">
    <script src="./layui/layui.js" charset="utf-8"></script>
</head>
<body>
<script>
    var layer=layui.layer;
    layer.ready(function (){
        layer.open({
            type:0,
            title:false,
            content: '退出 成功！',
            skin:"layui-layer-molv",//默认的样式
            icon: 1,
            time:3000,
            end: function () {
                location.href='/Rho/login.jsp';
            }
        });
    })

</script>

</body>
</html>
