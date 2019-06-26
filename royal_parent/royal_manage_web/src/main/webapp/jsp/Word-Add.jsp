<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>敏感词汇添加页面</title>

</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }

    .title{
        font-size: 25px;
    }


</style>
<script>

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="./commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div >

                </div>

                <form action="${pageContext.request.contextPath}/word/saveWord"
                      method="post">
                    <!-- 正文区域 -->
                    <section class="content"> <!--产品信息-->

                        <div class="panel panel-default">
                            <div class="panel-heading">敏感词添加</div>
                            <div class="row data-type">

                                <div class="col-md-2 title">敏感词</div>
                                <div class="col-md-3 data">
                                    <input type="text" class="form-control" name="word"
                                           placeholder="敏感词" value="">
                                </div>

                                <div class="col-md-2 title">敏感词状态</div>
                                <div class="col-md-3 data">
                                    <select class="form-control select2" style="width: 100%"
                                            name="status">
                                        <option value="0" selected="selected">停用</option>
                                        <option value="1">使用</option>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <!--订单信息/--> <!--工具栏-->
                        <div class="box-tools text-center">
                            <button type="submit" class=" <%--form-control--%> btn-primary">保存</button>
                        </div>
                        <!--工具栏/--> </section>
                    <!-- 正文区域 /-->
                </form>


                <div style="clear:both"></div>
                <hr>



            </div><!-- /.panel panel-success -->

        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%--<%@ include file="ArticleUpdate.jsp"%>--%>
</body>
</html>
