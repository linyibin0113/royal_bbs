<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<div class="hm-top-nav">
    <div class="hm-inner clearfix">
        <div class="hm-inner-l l"></div>
        <div class="hm-inner-r r">
            <div class="box">
                <c:if test="${user!=null}">
                    <a href="javascript:;" id="login" class="to-login" >欢迎：${user.roleStr} ${user.userName}</a>
                    <a href="${pageContext.request.contextPath}/user/findByid.do">【个人中心】</a>
                    <a href="${pageContext.request.contextPath}/jsp/register.jsp">【注销】</a>
                </c:if>
                <c:if test="${user==null}">
                    <a href="javascript:;" id="login" class="to-login" >游客登录</a>
                    <a href="${pageContext.request.contextPath}/jsp/register.jsp">【新用户注册】</a>
                </c:if>
                <div id="dialogBg"></div>
                <div id="dialog" class="animated">
                    <img class="dialogIco" width="50" height="40" src="images/ico.png"/>
                    <div class="dialogTop" style="height:25px;">
                        <a href="javascript:;" class="closeDialogBtn">关闭</a>
                    </div>
                    <form action="${pageContext.request.contextPath}/user/findByNameAndPass" method="post">
                        <ul class="editInfos">
                            <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/></li>
                            <li><input type="submit" value="登录" class="submitBtn"/></li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
  $(function () {
      //显示弹框
      $('.box #login').click(function () {
          var className = $(this).attr('class');
          $('#dialogBg').fadeIn(300);
          $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
          $('#userName').focus();
          $("#j_fixedBar").hide();
      });

      //关闭弹窗
      $('.closeDialogBtn').click(function () {
          $('#dialogBg').fadeOut(300, function () {
              $('#dialog').addClass('bounceOutUp').fadeOut();
              $("#j_fixedBar").show();
          });
      });
      $("#login").val()

  });

  /*..............*/
  $(function () {
      $.get("user/findOne",function (data) {
          var msg = "欢迎回来！" +data.name;
          $("#span_username").html(msg);
          $("#login").hide();
          //$("#regist").hide();
      });



  });




</script>
</html>