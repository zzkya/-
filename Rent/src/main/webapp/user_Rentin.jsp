<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin-layout.jsp"%>
<html>
<head>
    <title>用户求租信息管理</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<!-- 内容主体区域 -->
<div class="layui-body">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>用户求租信息管理</legend>
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

    <table id="Users_Rentin" lay-filter="Users_Rentin"></table>

    <script>
        layui.use('table', function(){
            var table = layui.table;
            var $ = layui.jquery;
            //第一个实例
            var insl=table.render({
                elem: '#Users_Rentin'
                //,url: '/review/findAll' //数据接口
                ,url:'/review/listRentIn'
                ,title: '用户求租信息数据表'
                ,id:"test"
                ,page: true
                ,cols: [[ //表头
                    {field: 'id', title: '房屋编号', width:180, sort: true, fixed: 'left'}
                    ,{field: 'username', title: '用户名', width:100}
                    ,{field: 'phone', title: '手机号', width:180}
                    ,{field: 'location', title: '城市', width:100}
                    ,{field: 'expectedPrice', title: '预期价格', width: 120,sort: true}
                    ,{field: 'expectedInformation', title: '房型', width: 160}
                    ,{field: 'time', title: '发布时间', width: 180}
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
