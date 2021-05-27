<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide" id="test" lay-filter="test1"></table>


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'table.json'
            // ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            // ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            //     title: '提示'
            //     ,layEvent: 'LAYTABLE_TIPS'
            //     ,icon: 'layui-icon-tips'
            // }]
            // ,title: '用户数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
                ,{field:'username', title:'用户名', width:120, edit: 'text'}
                ,{field:'email', title:'邮箱', width:150, edit: 'text', templet: function(res){
                        return '<em>'+ res.email +'</em>'
                    }}
                ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}
                ,{field:'city', title:'城市', width:100}
                // ,{field:'sign', title:'签名'}
                ,{field:'experience', title:'积分', width:80, sort: true}
                ,{field:'ip', title:'IP', width:120}
                ,{field:'logins', title:'登入次数', width:100, sort: true}
                ,{field:'joinTime', title:'加入时间', width:120}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
        });
        //监听单元格编辑
        table.on('edit(test1)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
        });

        //监听行工具事件
        table.on('tool(test1)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        url: "/deleteCollector",
                        type: "POST",
                        data: {id:data.id},
                        success: function (msg) {
                            if (msg == 200) {
                                //删除这一行
                                obj.del();
                                //关闭弹框
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
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });
</script>

</body>
</html>