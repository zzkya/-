<%--
布局
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/layui/css/layui.css">
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
            <li class="layui-nav-item layui-hide-xs"><a href="rent-in-msg.jsp">租房信息</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="rent-out-msg.jsp">出租信息</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="search.jsp">按关键字查询</a></li>
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
                    <img src="/img/person.jpg" class="layui-nav-img">
                    ${sessionScope.username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="person.jsp">个人中心</a></dd>
                    <dd><a href="alter.jsp">修改信息</a></dd>
                    <dd><a href="sign_out.jsp">退出登录</a></dd>
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
                        <dd><a href="javascript:;">是否已申请</a></dd>
                        <dd><a href="rented-in.jsp">已发布的租房信息</a></dd>
                        <dd><a href="rented-out.jsp">已发布的出租信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="apply.jsp">申请认证</a></li>
                <li class="layui-nav-item"><a href="rent-in.jsp">我要租房</a></li>
                <li class="layui-nav-item"><a href="rent-out.jsp">我要出租</a></li>

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
<script src="/layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });
    });
</script>
</body>
</html>
