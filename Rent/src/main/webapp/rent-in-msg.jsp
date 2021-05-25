<%--
所有的租房信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>求租信息</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>
<!-- 内容主体区域 -->
<div class="layui-body">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>求租信息</legend>
    </fieldset>
<%--    搜索框--%>
    <div class="demoTable">
        搜索location：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>

    <table id="RentIn" ></table>

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
                    {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                    ,{field: 'username', title: '用户名', width:80}
                    ,{field: 'location', title: '城市', width:80}
                    ,{field: 'expectedPrice', title: '预期价格', width: 177}
                    ,{field: 'expectedInformation', title: '房型', width: 80}
                    ,{field: 'time', title: '发布时间', width: 80, sort: true}
                ]]
                ,id:'testReload'
            });
            var $ = layui.$, active = {
                reload: function(){
                    var demoReload = $('#demoReload');

                    //执行重载
                    table.reload('testReload', {
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        ,where: {
                            key: {
                                id: demoReload.val()
                            }
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
