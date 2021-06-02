<%--
出租页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./layui/css/layui.css"  media="all">
    <title>我要出租</title>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-body" style="margin-left: 80px">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>我要出租</legend>
    </fieldset>

    <form class="layui-form layui-form-pane" action="" lay-filter="example">

        <div class="layui-form-item">
            <label class="layui-form-label">城市</label>
            <div class="layui-input-block">
                <input type="text" name="location"  autocomplete="off" placeholder="请输入房子地区" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-block">
                <input type="text" name="price"  autocomplete="off" placeholder="请输入房子价格" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">房型</label>
            <div class="layui-input-block">
                <select name="information" lay-filter="aihao">
                    <option value="一室一厅">一室一厅</option>
                    <option value="两室一厅">两室一厅</option>
                    <option value="三室一厅">三室一厅</option>
                    <option value="三室两厅">三室两厅</option>
                    <option value="别墅">别墅</option>
                    <option value="一室一卫">一室一卫</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交发布</button>
            </div>
        </div>
    </form>
</div>

<script src="./layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,laydate = layui.laydate;

        //监听提交
        form.on('submit(demo1)', function(data){
            layui.jquery.ajax({
                url:'/rent/save',//
                type:'post',
                dataType:'text',
                data:data.field,
                success:function(data){
                    if (data == "1") {
                        layer.msg('发布成功');
                        ///location.href = "login.html";
                    }else {
                        layer.msg('提交失败');
                    }
                }
            })
            return false;
        });

    });
</script>


</body>
</html>
