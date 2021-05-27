<%--
申请认证页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>申请认证</title>
    <link rel="stylesheet" href="./layui/css/layui.css"  media="all">
    <script src="./layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-body">

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 100px;">
        <legend>申请认证</legend>
    </fieldset>

    <form class="layui-form layui-form-pane" action="" lay-filter="example">

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">申请材料</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" class="layui-textarea" name="apply"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="btn">提交申请</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,laydate = layui.laydate;

        //验证该用户是否已经是中介了
        layer.ready(function (){
            layui.jquery.ajax({
                url:'review/save',//
                dataType:'text',
                type:'post',
                success:function (data) {
                    if(data=="0"){
                        layer.open({
                            icon: 6,
                            title:"提示信息",
                            content:"您已经申请过了！",
                            btn:["确认","取消"],
                            yes:function(){
                                location.href="menu.jsp";
                            }
                        })
                    }
                }
            })
            return false;
        })

        //监听提交
        form.on('submit(btn)', function(data){
            layui.jquery.ajax({
                url:'review/save',//
                type:'post',
                dataType:'text',
                data:data.field,
                success:function(data){
                    layer.msg('提交成功');
                }
            })
            return false;
        });

    });
</script>


</body>
</html>
