<%--
布局
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">Rho</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>
            <li class="layui-nav-item layui-hide-xs"><a href="menu.jsp">首 页</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="rent-in-msg.jsp">求租信息</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="rent-out-msg.jsp">出租信息</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">留言板</a>
                <dl class="layui-nav-child">
                    <dd><a href="msg_sent.jsp">已发送</a></dd>
                    <dd><a href="msg_receive.jsp">已接收</a></dd>
                </dl>
            </li>
        </ul>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="img/person.jpg" class="layui-nav-img">
                    ${sessionScope.username}
                    <c:if test="${sessionScope.auth==3}">
                        <i class="layui-icon layui-icon-diamond" style="color: #FFFF00"></i>
                    </c:if>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="person.jsp">个人中心</a></dd>
                    <dd><a href="/user/logout">退出登录</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">历史记录</a>
                    <dl class="layui-nav-child">
                        <%--三中类型：已是中介，不是中介，正在申请  --%>
                        <dd><a href="rented-in.jsp">已发布的租房信息</a></dd>
                        <dd><a href="rented-out.jsp">已发布的出租信息</a></dd>
                        <dd><a href="rented.jsp">已租房屋信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="apply.jsp">申请认证</a></li>
                <li class="layui-nav-item"><a href="rent-in.jsp">发布求租信息</a></li>
                <li class="layui-nav-item"><a href="rent-out.jsp">发布出租信息</a></li>

            </ul>
        </div>
    </div>

    <%--    <div class="layui-body">--%>
    <%--        <!-- 内容主体区域 -->--%>
    <%--        <div style="padding: 15px;">内容主体区域。记得修改 layui.css 和 js 的路径</div>--%>
    <%--    </div>--%>

    <div class="layui-footer " >
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>

</body>
</html>