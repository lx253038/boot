<#assign path="${springMacroRequestContext.contextPath}">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${path}/static/layer/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${path}/static/layer/css/login.css">
    <script type="text/javascript" src="${path}/static/js/subModal.js"></script>
    <script type="text/javascript" src="${path}/static/layer/layui.js"></script>
</head>

<body style="background-color: #F2F2F2">
<div class="layadmin-user-login" >

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <input type="hidden" id="codeKey" name="codeKey">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="layui-row">
                    <div class="layui-col-xs7">
                        <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                        <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
                    </div>
                    <div class="layui-col-xs5">
                        <div style="margin-left: 10px;">
                            <img  src="" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode" onclick="getCode()">
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit="loginCheck" lay-filter="LAY-user-login-submit">登 录</button>
            </div>

        </div>
    </div>


</div>
<script type="text/javascript">
    layui.use(['form'], function () {
        let form = layui.form; //表格
        form.on('submit(LAY-user-login-submit)', function(data){
           console.log(data.field);
            $.post("loginCheck",data.field, function (res) {
                layer.msg(res)
            });
            return true;
        });
        getCode();
    });

    function getCode() {
        $.post("getCode", function (res) {
            $("#LAY-user-get-vercode").attr("src",res.image);
            $("#codeKey").val(res.codeKey);
        });
    }

</script>

</body>
</html>