<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
    <#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>申请表id</th>
                            <th>学生姓名</th>
                            <th>国籍</th>
                            <th>申请国家</th>
                            <th>申请状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list cartDTOList as cartDTO>
                        <tr>
                            <td>${cartDTO.tableId}</td>
                            <td>${cartDTO.studentName}</td>
                            <td>${cartDTO.studentCountry}</td>
                            <td>${cartDTO.applicationCountry}</td>
                            <td>${cartDTO.getApplicationStatusEnum().msg}</td>
                            <td>${cartDTO.createTime}</td>
                            <td><a href="/application/detail?tableId=${cartDTO.tableId}">详情</a></td>
                            <td>
                                <#if cartDTO.getApplicationStatusEnum().msg == "等待审核">
                                    <a href="/application/under?tableId=${cartDTO.tableId}">修改</a>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>