<%--
所有的租房信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <title>求租信息</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>
<!-- 内容主体区域 -->
<div class="layui-body" style="margin-left: 80px">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>求租信息</legend>
    </fieldset>
<%--    搜索框--%>
    <div class="demoTable">
        搜索：
        <div class="layui-inline">
            <input class="layui-input" name="location" id="location" autocomplete="off" placeholder="按地区搜索">
        </div>
        <button class="layui-btn" data-type="reload">
            <i class="layui-icon layui-icon-search"></i> 搜索
        </button>
    </div>

    <table id="RentIn"  ></table>

    <script src="layui/layui.js"></script>
    <script>
        <%--var list = ${rentList}--%>
        <%--console.log(list)--%>
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#RentIn'
                ,url: '/tenant/findAll' //数据接口
                ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                    layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                    //,curr: 5 //设定初始在第 5 页
                    ,groups: 5 //只显示 5 个连续页码
                    ,first: false //不显示首页
                    ,last: false //不显示尾页
                }
                ,cols: [[ //表头
                    {field: 'id', title: 'ID', width:100, sort: true, fixed: 'left'}
                    ,{field: 'username', title: '用户名', width:100}
                    ,{field: 'location', title: '城市', width:100}
                    ,{field: 'expectedPrice', title: '预期价格', width: 120,sort: true}
                    ,{field: 'expectedInformation', title: '房型', width: 160}
                    ,{field: 'time', title: '发布时间', width: 180}
                ]]
                ,id:'testReload'
            });
            //搜索框的实现
            var $ = layui.$, active = {
                reload: function(){
                    var location = $('#location');
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
