<%--
已审核信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin-layout.jsp"%>
<html>
<head>
    <title>已审核信息</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<div class="layui-body">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>已审核信息</legend>
    </fieldset>

    <table id="Reviewed" lay-filter="Reviewed"></table>

    <script>
        layui.use('table', function(){
            var table = layui.table;
            var $ = layui.jquery;
            //第一个实例
            table.render({
                elem: '#Reviewed'
                ,url: '/review/findAllMark' //数据接口
                //,url:'table.json'
                ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                    //,curr: 5 //设定初始在第 5 页
                    ,groups: 5 //只显示 5 个连续页码
                    ,first: false //不显示首页
                    ,last: false //不显示尾页
                }
                ,cols: [[ //表头
                    {field: 'username', title: '用户名', width:100}
                    ,{field: 'apply', title: '申请材料', width:500}
                ]]
            });
        });
    </script>


</div>
</body>
</html>
