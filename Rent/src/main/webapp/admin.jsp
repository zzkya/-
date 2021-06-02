<%--
待审核信息界面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin-layout.jsp"%>
<html>
<head>
    <title>管理员界面</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
    <!-- 内容主体区域 -->
    <div class="layui-body">

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
            <legend>待审核信息</legend>
        </fieldset>

        <table id="Review" lay-filter="Review"></table>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del1">审核通过</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del2">审核不通过</a>
        </script>

        <script>
            layui.use('table', function(){
                var table = layui.table;
                var $ = layui.jquery;
                //第一个实例
                table.render({
                    elem: '#Review'
                    ,url: '/review/findAll' //数据接口
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
                        ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:300}
                    ]]
                });
                //监听单元格编辑
                table.on('edit(Review)', function(obj){
                    var value = obj.value //得到修改后的值
                        ,data = obj.data //得到所在行所有键值
                        ,field = obj.field; //得到字段
                    layer.msg('[用户名: '+ data.username +'] ' + field + ' 字段更改为：'+ value);
                });

                //监听行工具事件
                table.on('tool(Review)', function(obj){
                    var data = obj.data;
                    if(obj.event === 'del1'){
                        layer.confirm('您确认批准通过吗', function(index){
                            $.ajax({
                                url: "/review/changeMark",
                                type: "POST",
                                data: {username:data.username},
                                success: function () {
                                    obj.del();
                                    layer.close(index);
                                    layer.msg("操作成功", {icon: 6});
                                }
                            });
                            return false;
                        });
                    } else if(obj.event === 'del2'){
                        layer.confirm('您确认不批准通过吗', function(index){
                            $.ajax({
                                url: "/review/delNo",
                                type: "POST",
                                data: {username:data.username},
                                success: function () {
                                    obj.del();
                                    layer.close(index);
                                    layer.msg("操作成功", {icon: 6});
                                }
                            });
                            return false;
                        });
                    }
                });
            });
        </script>

    </div>

</body>
</html>
