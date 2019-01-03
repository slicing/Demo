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
<div>
    <p><strong>ID:</strong><span th:text="${userModel.user.id}"></span></p>
    <p><strong>Name:</strong><span th:text="${userModel.user.name}"></span></p>
    <p><strong>Email:</strong><span th:text="${userModel.user.email}"></span></p>
</div>
<div th:replace="~{fragments/footer :: footer}"></div>
</body>
</html>