<%--
用来发布租房页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./layui/css/layui.css"  media="all">
    <title>我要租房</title>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-body">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>我要租房</legend>
    </fieldset>

    <form class="layui-form layui-form-pane" action="" lay-filter="example">

        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username"  autocomplete="off"  class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">城市</label>
            <div class="layui-input-block">
                <input type="text" name="location"  autocomplete="off"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">期望价格</label>
            <div class="layui-input-block">
                <input type="text" name="eprice"  autocomplete="off"  class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">期望房型</label>
            <div class="layui-input-block">
                <input type="text" name="einformation"  autocomplete="off"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block" >
                <button type="submit"  class="layui-btn" text-aglin lay-submit="" lay-filter="demo1">提交</button>
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
                url:'rent-in_servlet',//
                type:'post',
                dataType:'text',
                data:data.field,
                success:function(data){
                    if (data == 1) {
                        layer.msg('提交成功');
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

