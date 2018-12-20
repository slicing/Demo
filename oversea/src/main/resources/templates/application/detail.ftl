<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">
    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">

            <#--订单详情表数据-->
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>申请表id</th>
                            <th>学生ID</th>
                            <th>学生姓名</th>
                            <th>国籍</th>
                            <th>大学</th>
                            <th>专业</th>
                            <th>申请国家</th>
                            <th>申请大学</th>
                            <th>申请专业</th>
                            <th>申请状态</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <td>${applicationTable.tableId}</td>
                            <td>${applicationTable.studentId}</td>
                            <td>${applicationTable.studentName}</td>
                            <td>${applicationTable.studentCountry}</td>
                            <td>${applicationTable.studentUniversity}</td>
                            <td>${applicationTable.studentMajor}</td>
                            <td>${applicationTable.applicationCountry}</td>
                            <td>${applicationTable.applicationUniversity}</td>
                            <td>${applicationTable.applicationMajor}</td>
                            <td>${applicationTable.getApplicationStatusEnum().msg}</td>
                            <td>${applicationTable.createTime}</td>
                            <td><a href="/application/detail?tableId=${applicationTable.tableId}">详情</a></td>
                            <td>
                                <#if applicationTable.getApplicationStatusEnum().msg == "等待审核" || applicationTable.getApplicationStatusEnum().msg == "审核中">
                                    <a href="/application/under?orderId=${applicationTable.tableId}">修改</a>
                                </#if>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            <#--操作-->
                <div class="col-md-12 column">
                <#if applicationTable.getApplicationStatusEnum().msg == "等待审核">
                    <a href="/application/under?tableId=${applicationTable.tableId}" type="button" class="btn btn-default btn-primary">审核中</a>
                    <a href="/application/adopt?tableId=${applicationTable.tableId}" type="button" class="btn btn-default btn-danger">审核通过</a>
                    <a href="/application/adopt?tableId=${applicationTable.tableId}" type="button" class="btn btn-default btn-danger">驳回</a>
                </#if>
                    <#if applicationTable.getApplicationStatusEnum().msg == "审核中">
                    <a href="/application/adopt?tableId=${applicationTable.tableId}" type="button" class="btn btn-default btn-danger">审核通过</a>
                    <a href="/application/adopt?tableId=${applicationTable.tableId}" type="button" class="btn btn-default btn-danger">驳回</a>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>