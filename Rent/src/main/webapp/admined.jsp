<%--
已审核信息展示
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin-layout.jsp"%>
<html>
<head>
    <title>已审核信息页面</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<!-- 内容主体区域 -->
<div class="layui-body">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>已审核信息</legend>
    </fieldset>

    <div class="demoTable">
        搜索用户名：
        <div class="layui-inline">
            <input class="layui-input" name="username" id="username" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">
            <i class="layui-icon layui-icon-search"></i> 搜索
        </button>
        <%--导出文件--%>

        <button class="layui-btn  layui-btn-normal" id="export" >
            <i class="layui-icon layui-icon-export"></i> 导出
        </button>
    </div>



    <table id="Reviewed" lay-filter="Reviewed"></table>

    <script>
        layui.use('table', function(){
            var table = layui.table;
            var $ = layui.jquery;
            //第一个实例
            var insl=table.render({
                elem: '#Reviewed'
                ,url: '/review/findAllMark' //数据接口
                //,url:'table.json'
                ,title: '已审核信息数据表'
                ,id:"test"
                ,page: true
                ,cols: [[ //表头
                    {field: 'username', title: '用户名', width:100}
                    ,{field: 'apply', title: '申请材料', width:500}
                ]],
                done:function (res,curr,count){
                    exportData=res.data;
                }
            });

            $("#export").click(function (){
                table.exportFile(insl.config.id,exportData);
            })

            //搜索框的实现
            var $ = layui.$, active = {
                reload: function(){
                    var username = $('#username');
                    //执行重载
                    table.reload('test', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,where: {
                            username : username.val()
                        }
                    });
                }
            };
            $('.demoTable .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
        });
    </script>
</div>
</body>
</html>