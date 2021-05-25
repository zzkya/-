<%--
所有的出租信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <title>已发布的出租信息</title>
</head>
<body>
<div class="layui-body">
    <!-- 内容主体区域 -->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>已发布的出租信息</legend>
    </fieldset>

    <table class="layui-hide" id="RentOut" ></table>

    <script src="layui/layui.js"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#RentOut'
                ,url: '/rent/findByUser' //数据接口
                ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                    //,curr: 5 //设定初始在第 5 页]
                    ,groups: 5 //只显示 5 个连续页码
                    ,first: false //不显示首页
                    ,last: false //不显示尾页
                }
                ,cols: [[ //表头
                    {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                    ,{field: 'username', title: '用户名', width:80}
                    ,{field: 'location', title: '城市', width:80}
                    ,{field: 'price', title: '价格', width: 177}
                    ,{field: 'information', title: '介绍', width: 80}
                    ,{field: 'time', title: '发布时间', width: 80, sort: true}
                ]]
            });
        });
    </script>
</div>
</body>
</html>
