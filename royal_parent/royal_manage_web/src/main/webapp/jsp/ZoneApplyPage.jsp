<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>申请版块管理页面</title>

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
                    <ol class="breadcrumb">
                        <li><a href="#">版块申请管理</a></li>
                        <li class="active">版块申请信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="get" id="articleSearchForm" action="${pageContext.request.contextPath}/zoneApply/findZoneNameAndUserName">
                            <table>
                                <tr>
                                    <th>
                                        <label for="title" class="control-label">版块名称:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="title" class="form-control"
                                               name="title" value="">
                                        <input type="hidden" id="pageNum" name="pn" value="">
                                    </th>
                                    <th>
                                        <label for="article_sendername" class="control-label">申请用户:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="article_sendername" class="form-control"
                                               name="sendername" value="">
                                    </th>
                                    <th colspan="2">
                                        <input type="button" value="查询" class="form-control btn-primary">
                                    </th>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>版块名称</th>
                        <th>申请用户</th>
                        <th>申请理由</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="zoneApply">
                            <tr>
                                <td width="10%">
                                        ${zoneApply.zoneName }
                                </td>

                                <td width="10%" class="line-limit-length">
                                        ${zoneApply.userName }
                                </td>

                                <td width="60%" class="line-limit-length">
                                        ${zoneApply.reason}
                                </td>


                                <td width="20%">
                                    <a href="${pageContext.request.contextPath}/zoneApply/applySuccess?id=${zoneApply.articleId}&pn=${pageInfo.pageNum}<%--&title=${articleSearch.title}&sendername=${articleSearch.sendername}--%>" role="button" class="btn btn-primary">同意</a>
                                    <a href="${pageContext.request.contextPath}/zoneApply/applyFail?id=${zoneApply.articleId}&pn=${pageInfo.pageNum}<%--&title=${articleSearch.title}&sendername=${articleSearch.sendername}--%>" role="button" class="btn btn-danger" >驳回</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>


            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="${pageContext.request.contextPath}/zoneApply/findByPage?page=1&size=${pageInfo.pageSize}" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${pageInfo.hasPreviousPage}">
                                        <a href="${pageContext.request.contextPath}/zoneApply/findByPage?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <%--<c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == pageInfo.pageNum}">
                                    <li class="active"><a href="      ">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != pageInfo.pageNum}">
                                    <li><a href="       " onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>--%>

                            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                <li><a href="${pageContext.request.contextPath}/zoneApply/findByPage?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <a href="${pageContext.request.contextPath}/zoneApply/findByPage?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/zoneApply/findByPage?page=${pageInfo.pages}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%--<%@ include file="ArticleUpdate.jsp"%>--%>
</body>
</html>
