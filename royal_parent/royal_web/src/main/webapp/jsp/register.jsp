<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛注册页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>
<script>

    function checkUsername() {
        //定义正则
        var reg_username = /^\w{5,8}$/;
        //获取用户名的值
        var username = $("#userName1").val();
        //判断给出提示
        var flag = reg_username.test(username);
        if (flag){
            //用户名合法
            $("#userName1").css("border","2px solid green");
        }else {
            //用户名非法，加一个红色边框
            $("#userName1").css("border","2px solid red");
        }
        return flag;
    }


    function checkPassword() {
        //定义正则
        var reg_userPass = /^\w{8,20}$/;;
        //获取email的值
        var userPass = $("#userPass1").val();
        //判断给出提示
        var flag = reg_userPass.test(userPass);
        if (flag){
            //email合法
            $("#userPass1").css("border","2px solid green");
        }else {
            //email非法，加一个红色边框
            $("#userPass1").css("border","2px solid red");
        }
        return flag;
    }

    function checkEmail() {
        //定义正则
        var reg_email = /^\w+@\w+\.\w+$/;
        //获取email的值
        var email = $("#email1").val();
        //判断给出提示
        var flag = reg_email.test(email);
        if (flag){
            //email合法
            $("#email1").css("border","2px solid green");
        }else {
            //email非法，加一个红色边框
            $("#email1").css("border","2px solid red");
        }
        return flag;
    }


    $(function () {
        //当表单提交时，调用所有校验方法
        $("#registerForm1").submit(function () {
            //如果这个方法没有返回值，或者返回true，则表单提交，如果返回false，则表单不提交
            if (checkUsername() && checkPassword() && checkEmail()){
                //只有当表单全部校验通过的时候，会执行if代码块
                $.post("${pageContext.request.contextPath}/user/register",$(this).serialize(),function (data) {
                    //回调函数
                    //只有在响应成功的时候会触发
                    //data 就是服务器返回的json数据
                    if(data.flag){
                        location.href="${pageContext.request.contextPath}/jsp/success.jsp";
                    }else {
                        alert(data.errorMsg);
                    }
                })
            }
            //返回false才能阻止表单提交
            return false;
        })

        $("#userName1").blur(checkUsername);
        $("#userPass1").blur(checkPassword);
        $("#email1").blur(checkEmail);
    })
</script>


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="images/logo.png" height="64" width="168" alt=""/></a>
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
            <a href="index.do">首页</a><span>></span>注册页面
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="reg-box">
            <h2>用户注册<span>（红色型号代表必填）</span></h2>
            <div class="reg-info">
                <form id="registerForm1" name="registerForm1">
                    <ul>
                        <li class="no-tips">
                            <div class="reg-l">
                                <span class="red">*</span> 用户名：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="userName1" name="userName" class="txt" value=""/>
                            </div>
                            <span class="tips">用户名必须是由英文、数字、下划线组成</span>
                        </li>
                        <li class="no-tips">
                            <div class="reg-l">
                                <span class="red">*</span> 密&nbsp;&nbsp;&nbsp;码：
                            </div>
                            <div class="reg-c">
                                <input type="password" id="userPass1" name="userPass" class="txt" value=""/>
                            </div>
                            <span class="tips">密码长度必须6~10位的英文或数字</span>
                        </li>
                        <li class="no-tips">
                            <div class="reg-l">
                                <span class="red">*</span> 邮&nbsp;&nbsp;&nbsp;箱：</div>
                            <div class="reg-c">
                                <input type="text" id="email1" name="email" class="txt" value=""/>
                            </div>
                        </li>
                        <li>
                            <div class="reg-l"></div>
                            <div class="reg-c">
                                <input type="submit" class="submit-btn"  value="注册"/><br/>
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