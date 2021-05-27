<%--
个人信息页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-body">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>个人信息</legend>
    </fieldset>

    <form class="layui-form layui-form-pane" action="" lay-filter="example">

        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username"  autocomplete="off"  class="layui-input" readonly="readonly">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">真实姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name"  autocomplete="off"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
            <div class="layui-input-block">
                <input type="text" name="id"  autocomplete="off"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked="">
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="text" name="age"  autocomplete="off"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input type="text" name="phone"  autocomplete="off"  class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
            </div>
        </div>
    </form>
</div>

<script src="./layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    var data =
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //监听指定开关
        // form.on('switch(switchTest)', function(data){
        //     layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
        //         offset: '6px'
        //     });
        //     layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        // });

        //监听提交
        form.on('submit(demo1)', function(data){
            layui.jquery.ajax({
                url:'/user/change',//
                type:'post',
                dataType:'text',
                data:data.field,
                success:function(data){
                    if (data == 1) {
                        layer.msg('更新成功');
                        // location.href = "person.jsp";
                    }else {
                        layer.msg('更新失败');
                    }
                }
            })
            return false;
        });


        layer.ready(function (){
            layui.jquery.ajax({
                url:'/user/userCenter',//
                dataType:'text',
                type:'post',
                success:function (data) {
                    data = JSON.parse(data);
                    form.val('example',{
                        "username":data.username
                        ,"password":data.password
                        ,"name":data.name
                        ,"id":data.id
                        ,"sex":data.sex
                        ,"age":data.age
                        ,"phone":data.phone
                    });
                }
            })
            return false;
        })
    });
</script>


</body>
</html>