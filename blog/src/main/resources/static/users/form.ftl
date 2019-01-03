<!doctype html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout=""http://www.ultraq.net.nz/thymeleaf/layout">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div th:replace="~{fragments/header :: header}"></div>
<form action="/user/save" th:action="/user/list" method="post" th:object="${userModel.user}">
    <input type="hidden" name="id" th:value="*{id}">
    名称：<br>
    <input type="text" name="name" th:value="*{name}">
    邮箱：<br>
    <input type="text" name="email" th:value="*{email}">
    <input type="submit" value="提交">

</form>
<div th:replace="~{fragments/footer :: footer}"></div>
</body>
</html>