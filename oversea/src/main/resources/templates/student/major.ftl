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
                            <th>id</th>
                            <th>类目</th>
                            <th>名字</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list majorInfoList as majorInfo>
                        <tr>
                            <td>${majorInfo.id}</td>
                            <td>${majorInfo.majorId}</td>
                            <td>${majorInfo.majorName}</td>
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