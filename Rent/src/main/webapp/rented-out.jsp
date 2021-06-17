<%--
所有的出租信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <title>已发布的出租信息</title>
    <link rel="stylesheet" href="./layui/css/layui.css"  media="all">
    <script src="./layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-body" style="margin-left: 80px">
    <!-- 内容主体区域 -->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>已发布的出租信息</legend>
    </fieldset>

    <table class="layui-hide" id="RentOut" lay-filter="RentOut"></table>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <script>
        layui.use('table', function(){
            var table = layui.table;
            var $ = layui.jquery;
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
                    {field: 'id', title: '房屋编号', width:120, sort: true, fixed: 'left'}
                    ,{field: 'username', title: '用户名', width:100}
                    ,{field: 'location', title: '城市', width:100}
                    ,{field: 'price', title: '价格', width: 80, sort: true,edit:'text'}
                    ,{field: 'information', title: '房型', width: 160}
                    ,{field: 'time', title: '发布时间', width: 180,sort:true}
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150, fixed: 'right'}
                ]]
            });
            //监听单元格编辑
            table.on('edit(RentOut)', function(obj){
                var value = obj.value //得到修改后的值
                    ,data = obj.data //得到所在行所有键值
                    ,field = obj.field; //得到字段
                layer.msg('[用户名: '+ data.username +'] ' + field + ' 字段更改为：'+ value);
            });

            //监听行工具事件
            table.on('tool(RentOut)', function(obj){
                var data = obj.data;
                console.log(obj)
                if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        $.ajax({
                            url: "/rent/del",
                            type: "POST",
                            data: {id:data.id},
                            success: function (msg) {
                                if (msg == "1") {
                                    obj.del();
                                    layer.close(index);
                                    layer.msg("删除成功", {icon: 6});
                                } else {
                                    layer.msg("删除失败", {icon: 5});
                                }
                            }
                        });
                        return false;
                    });
                } else if(obj.event === 'edit'){
                    layer.prompt({
                        formType: 2
                        ,value: data.price
                    }, function(value, index){
                        obj.update({
                            price: value
                        });
                        $.ajax({
                            url: "/rent/changePrice",
                            type: "POST",
                            data: {price:value,id:data.id},
                            success: function (msg) {
                                if (msg == "1") {
                                    layer.msg("编辑成功", {icon: 6});
                                } else {
                                    layer.msg("编辑失败", {icon: 5});
                                }
                            }
                        });
                        layer.close(index);
                    });
                }
            });

        });
    </script>
</div>
</body>
</html>
