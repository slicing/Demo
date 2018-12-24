<html>
<#include "../student/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../student/nav.ftl">

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
                        </tr>
                        </thead>
                        <tbody>
                        <#list countryCategoryList as countryCategory>
                        <tr>
                            <td>${countryCategory.countryId}</td>
                            <td><a href="/oversea/university/student/country/list?countryId=${countryCategory.countryId}"> ${countryCategory.countryName}</a></td>
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