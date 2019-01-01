<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>登录</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1"/>
    <link rel="shortcut icon" href="/favicon.ico"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css"/>
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css"/>
</head>
<body>
<form action="/front/addlogin" name="loginfrom" accept-charset="utf-8" method="post">
    <label class="label-tips" for="u">账号:</label>
    <input type="text" id="u" name="username" class="inputstyle"/>
    <div>
        <label class="lable-tips" for="password">密码:</label>
        <input type="password" id="password" name="password" class="inputstyle" />
    </div>
    <input type="submit" name="登录"/>
    <a href="register.html" class="zcxy" target="_blank">注册</a>
</form>
</body>

</html>