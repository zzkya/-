<%--
管理员界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<div class="layui-header">
    <ul class="layui-nav layui-bg-green">
        <li class="layui-nav-item"><a href="">墨绿导航</a></li>
        <li class="layui-nav-item"><a href="admin.jsp">待审核信息</a></li>
        <li class="layui-nav-item"><a href="admined.jsp">已审核信息</a></li>
        <li class="layui-nav-item">
            <a href="javascript:;">导出</a>
            <dl class="layui-nav-child">
                <dd><a href="user_Rentin.jsp">用户求租信息导出</a></dd>
                <dd><a href="user_Rentout.jsp">用户出租信息导出</a></dd>
                <dd><a href="users.jsp">用户信息导出</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav layui-layout-right layui-bg-green">
        <li class="layui-nav-item layui-hide layui-show-md-inline-block">
            <a href="javascript:;">
                <img src="img/person.jpg" class="layui-nav-img">
                ${sessionScope.username}
                <i class="layui-icon layui-icon-diamond" style="color: #FFFF00"></i>
            </a>

        </li>
    </ul>
</div>
</body>
</html>
