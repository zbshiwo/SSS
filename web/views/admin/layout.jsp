<%--
  Created by IntelliJ IDEA.
  User: 张博
  Date: 2017/9/9
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" href=<%="/blog/css/bootstrap-theme.min.css"%> type="text/css" />
    <link rel="stylesheet" href=<%="/blog/css/bootstrap.min.css"%> type="text/css" />

    <script type="text/javascript" src=<%="/blog/js/jquery-3.2.1.js"%>></script>
    <script type="text/javascript" src=<%="/blog/js/bootstrap.min.js"%>></script>

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <a class="navbar-brand" href="#">后台管理</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">用户管理</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">分类管理<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">分类首页</a></li>
                        <li><a href="#">添加分类</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">内容管理<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">内容首页</a></li>
                        <li><a href="#">添加内容</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"            aria-haspopup="true" aria-expanded="false">{{ userInfo.username }}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

</body>
</html>
