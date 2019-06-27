<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_info.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
    <style type="text/css">
        .hm-header-b { border-bottom: 1px solid #d9d9d9; }
    </style>
</head>
<body>
<script>


    function checkoldPassword() {
        //定义正则
        var reg_userPass ="${sessionScope.user.userPass}";
        //获取email的值
        var userPass = $("#oldPassword").val();
        //判断给出提示
        var flag = reg_userPass==userPass;
        if (flag){
            //email合法
            $("#oldPassword").css("border","2px solid green");
        }else {
            //email非法，加一个红色边框
            $("#oldPassword").css("border","2px solid red");
        }
        return flag;
    }
    function checknewPassword() {
        //定义正则
        var reg_userPass = /^\w{6,10}$/;
        //获取值
        var userPass = $("#newPassword").val();
        //判断给出提示
        var flag = reg_userPass.test(userPass);
        if (flag){
            //newPassword合法
            $("#newPassword").css("border","2px solid green");
        }else {
            //newPassword非法，加一个红色边框
            $("#newPassword").css("border","2px solid red");
        }
        return flag;
    }
    $(function () {
        //当表单提交时，调用所有校验方法
        $("#registerForm1").submit(function () {
            //如果这个方法没有返回值，或者返回true，则表单提交，如果返回false，则表单不提交
            if (checkoldPassword() && checknewPassword() ){
                //只有当表单全部校验通过的时候，会执行if代码块
                $.post("${pageContext.request.contextPath}/user/updatePassword.do?id=${sessionScope.user.userId}",$(this).serialize(),function (data) {
                    //回调函数
                    //只有在响应成功的时候会触发
                    //data 就是服务器返回的json数据
                    $("#update1").text("注册成功");
                })
            }
            //返回false才能阻止表单提交
            return false;
        })
        $("#oldPassword").blur(checkoldPassword);
        $("#newPassword").blur(checknewPassword);
    })

</script>

<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<!--头部信息-->
<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="images/logo.png" alt=""/></a>
            </h1>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="index.do">首页</a><span>></span>修改密码
        </div>
    </div>
</div>


<!--修改密码-->
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img src="${pageContext.request.contextPath}${sessionScope.user.picUrl}" alt=""/>
                    <div class="username">${sessionScope.user.userName}</div>
                </div>
                <ul class="user-info-l-b">
                    <li><i class="info-icon"></i>我的资料</li>
                    <li class="cur"><i class="safe-icon"></i>修改密码</li>
                </ul>
            </div>


            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li><a href="userInfo.jsp">个人信息</a></li>
                    <li class="cur"><a href="userPwd.jsp">修改密码</a></li>
                </ul>
                <form action="${pageContext.request.contextPath}/user/updatePassword.do?id=5" method="post" id="registerForm1">
                  <ul class="bd">
                    <li class="clearfix">
                        <div class="info-l"><i class="red">*</i>旧密码：</div>
                        <div class="info-r"><input id="oldPassword" type="password" name="oldPassword" class="txt"/></div>

                    </li>
                    <li class="clearfix">
                        <div class="info-l"><i class="red">*</i>新密码：</div>
                        <div class="info-r"><input id="newPassword" type="password" name="newPassword" class="txt"/></div>
                        <span class="tips"> 密码长度必须6~10位的英文或数字</span>
                    </li>
                    <li class="clearfix">
                        <div class="info-l"></div>
                        <div class="info-r">
						  <input type="submit" class="btn" value="保存"/>
						  <span style="color:red;" id="update1"></span>
						</div>
                    </li>
                  </ul>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>


</body>
</html>