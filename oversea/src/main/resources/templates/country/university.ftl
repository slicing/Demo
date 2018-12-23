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
                            <th>类目id</th>
                            <th>名字</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list universityCategoryList as universityCategory>
                        <tr>
                            <td>${universityCategory.universityId}</td>
                            <td><a href="/major/university/list?universityId=${universityCategory.universityId}"> ${universityCategory.universityName}</a></td>
                            <td><a href="/major/delete?categoryId=${universityCategory.universityId}">删除</a></td>
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