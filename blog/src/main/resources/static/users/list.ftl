<!doctype html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BOLG</title>
</head>
<body>
<div th:replace="~{fragments/header :: header}"></div>
<table border="1">
    <thead>
    <tr>
        <td>ID</td>
        <td>Email</td>
        <td>Name</td>
    </tr>
    </thead>
    <tbody>
    <tr th:each="user : ${userModel.userList}">
        <td th:text="${user.id}"></td>
        <td th:text="${user.email}"></td>
        <td th:text="${user.name}"></td>
    </tr>
    </tbody>
</table>
<div th:replace="~{fragments/footer :: footer}"></div>
</body>
</html>