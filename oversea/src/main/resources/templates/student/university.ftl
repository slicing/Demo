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
                        <#list universityCategoryList as universityCategory>
                        <tr>
                            <td>${universityCategory.universityId}</td>
                            <td><a href="/major/university/major/list?universityId=${universityCategory.universityId}"> ${universityCategory.universityName}</a></td>
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