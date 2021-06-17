<%--
所有的出租信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <title>出租信息</title>
    <link rel="stylesheet" href="./layui/css/layui.css"  media="all">
    <script src="./layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-body" style="margin-left: 80px">
    <!-- 内容主体区域 -->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>出租信息</legend>
    </fieldset>
    <div class="demoTable">
        搜索：
        <div class="layui-inline">
            <input class="layui-input" name="location" id="location" autocomplete="off" placeholder="按地区搜索">
        </div>
        <button class="layui-btn" data-type="reload">
            <i class="layui-icon layui-icon-search"></i> 搜索
        </button>
    </div>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">我要了</a>
    </script>

    <table class="layui-hide" id="RentOut" lay-filter="RentOut"></table>

<%--    <script type="text/html" id="usernameTpl">--%>
<%--        <a href="/?table-demo-id={{d.id}}" class="layui-table-link" target="_blank">{{ d.username }}</a>--%>
<%--    </script>--%>

    <script type="text/html" id="usernameTpl">
        {{#  if(d.user_auth === '3'){ }}
        <span style="color: #FFaa33 ;">{{ d.username }} (中介)</span>
        {{#  } else { }}
        {{ d.username }}
        {{#  } }}
    </script>

    <script>
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#RentOut'
                ,url: '/rent/findAll' //数据接口
                ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                    //,curr: 5 //设定初始在第 5 页]
                    ,groups: 5 //只显示 5 个连续页码
                    ,first: false //不显示首页
                    ,last: false //不显示尾页
                }
                ,cols: [[ //表头
                    {field: 'id', title: '房屋编号', width:100, sort: true, fixed: 'left'}
                    ,{field: 'username', title: '用户名', width:100,templet:'#usernameTpl'}
                    ,{field: 'user_phone', title: '用户手机号', width: 180}
                    ,{field: 'location', title: '城市', width:100}
                    ,{field: 'price', title: '价格', width: 100, sort: true}
                    ,{field: 'information', title: '房型', width: 160}
                    ,{field: 'time', title: '发布时间', width: 180}
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
                ]]
                ,id:'testReload'
            });

            //监听行工具事件
            table.on('tool(RentOut)', function(obj){
                var data = obj.data;
                //console.log(obj)
                if(obj.event === 'del'){
                    layer.confirm('您确定要租吗？', function(index){
                        $.ajax({
                            url: "/rent/rented",
                            type: "POST",
                            data: {id:data.id},
                            success: function (msg) {
                                if (msg == "1") {
                                    obj.del();
                                    layer.close(index);
                                    layer.msg("租房成功", {icon: 6});
                                } else {
                                    layer.msg("租房失败", {icon: 5});
                                }
                            }
                        });
                        return false;
                    });
                }
            });

            //搜索框的实现
            var $ = layui.$, active = {
                reload: function(){
                    var location = $('#location');
                    console.log(location.val())
                    //执行重载
                    table.reload('testReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,where: {
                               location : location.val()
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
