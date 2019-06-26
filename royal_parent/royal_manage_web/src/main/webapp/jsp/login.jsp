<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/bootstrap/jquery-1.11.0.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
    <script>
        $(function () {
            //给登录按钮绑定单击事件
            $("#btn_sub").click(function () {
                //发送ajax请求，提交表单数据
                $.post("${pageContext.request.contextPath}/user/login", $("#login_form").serialize(), function (data) {
                    //data 如果没有设置响应头，那么会被当做String解析
                    if (data.flag) {
                       // alert("登录成功");

                        location.href="${pageContext.request.contextPath}/jsp/main.jsp";
                    } else {
                       // $("#errorMsg").css("name","登录失败"+ data.errorMsg)
                        $("#errorMsg").text("登录失败:" + data.errorMsg);
                     //alert("登录失败:" + data.errorMsg);
                    }
                })
            })
        });
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4" style="margin: 380px 380px">
            <div class="login-panel panel panel-default"style="margin-top:-130px" >
                <div class="panel-heading">
                    <h3 class="panel-title" style="text-align: center;">王者荣耀论坛管理后台</h3>
                </div>
                <div class="panel-body">
                    <div id="errorMsg" class="alert alert-danger" align="center">

                    </div>
                    <form role="form" method="post" id="login_form" action="">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="用户名" name="username" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="userpass" type="password">
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <!--<a href="javascript:void(0)" class="btn btn-lg btn-success btn-block" id='login_btn'>登录</a>-->
                            <input type="button" id="btn_sub" class="btn btn-lg btn-success btn-block" value="登录">
                        </fieldset>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
