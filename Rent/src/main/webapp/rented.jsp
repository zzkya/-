<%--
已租房屋信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>
<div class="layui-body" style="margin-left: 80px">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>已租房屋信息</legend>
    </fieldset>

    <table id="Rented" lay-filter="Rented"></table>
    <script src="layui/layui.js"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#Rented'
                ,url: '/rent/findByMark' //数据接口
                ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                    //,curr: 5 //设定初始在第 5 页]
                    ,groups: 5 //只显示 5 个连续页码
                    ,first: false //不显示首页
                    ,last: false //不显示尾页
                }
                ,cols: [[ //表头
                    {field: 'id', title: '房屋编号', width:180, sort: true, fixed: 'left'}
                    ,{field: 'username', title: '房东', width:100}
                    ,{field: 'location', title: '城市', width:100}
                    ,{field: 'price', title: '成交价格', width: 120, sort: true}
                    ,{field: 'information', title: '房型', width: 160}
                    ,{field: 'time', title: '发布时间', width: 180}
                ]]
            });
        });
    </script>
</div>
</body>
</html>
