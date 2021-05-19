<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<ul class="layui-nav">
    <li class="layui-nav-item layui-this">
        <a href="">个人中心</a>
        <dl class="layui-nav-child">
            <dd class="layui-this"><a href="">个人信息</a></dd>
            <dd><a href="">已发布找房信息</a></dd>
            <dd><a href="">已发布出租信息</a></dd>
            <dd><a href="">退出登录</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="">我要找房</a></li>
    <li class="layui-nav-item"><a href="">我要出租</a></li>
    <li class="layui-nav-item"><a href="">申请认证</a></li>
</ul>

<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav', function(elem){
            //console.log(elem)
            //alert(elem.text());
            layer.msg(elem.text());
        });
    });
</script>

</body>
</html>