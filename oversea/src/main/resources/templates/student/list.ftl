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
                        <#list countryCategoryList as countryCategory>
                        <tr>
                            <td>${countryCategory.countryId}</td>
                            <td><a href="/oversea/university/country/list?countryId=${countryCategory.countryId}"> ${countryCategory.countryName}</a></td>
                            <td><a href="/country/category/delete?categoryId=${countryCategory.countryId}">删除</a></td>
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