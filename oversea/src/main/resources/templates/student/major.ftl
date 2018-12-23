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
                            <th>id</th>
                            <th>类目</th>
                            <th>名字</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list majorInfoList as majorInfo>
                        <tr>
                            <td>${majorInfo.id}</td>
                            <td>${majorInfo.majorId}</td>
                            <td>${majorInfo.majorName}</td>
                            <td><a href="/country/category/delete?categoryId=${majorInfo.id}">删除</a></td>
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