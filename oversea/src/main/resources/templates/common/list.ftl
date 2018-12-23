<html>
<#include "header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
    <#include "nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>学生id</th>
                            <th>学生姓名</th>
                            <th>年龄</th>
                            <th>性别</th>h>
                            <th>国籍</th>
                            <th>地址</th>
                            <th>电话</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list studentDTOList as studentDTO>
                        <tr>
                            <td>${studentDTO.userId}</td>
                            <td>${studentDTO.userName}</td>
                            <td>${studentDTO.age}</td>
                            <td>${studentDTO.gender}</td>
                            <td>${studentDTO.userNationalityId}</td>
                            <td>${studentDTO.userAddress}</td>
                            <td>${studentDTO.userTele}</td>
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