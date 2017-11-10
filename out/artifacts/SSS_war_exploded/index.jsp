<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.zb.Service.ServiceImpl.User1ServiceImpl,com.zb.model.User1" %>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.zb.Service.User1Service" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>blog</title>
  <script src="./js/jquery-3.2.1.js"></script>
  <script src="js/index.js?v=<%=Math.random()%>"></script>
  <link rel="stylesheet" href="./css/main.css" type="text/css">
</head>
<body>
<header>
  <div class="backimg"><img src="./images/IMG_0293.jpg"></div>
  <div class="logo"><span></span><img src="./images/00002637.png"></div>
</header>

<nav>
  <div class="menu"></div>
</nav>



<main class="clear">
  <div class="mainLeft">

  </div>

  <div class="mainRight">
    <%
      User1 user1 = null;
      String username = "";
      String password = "";
      Cookie[] cookies = request.getCookies();
      if (cookies != null && cookies.length >0) {
        for (int i = 0; i < cookies.length; i++) {
          if (cookies[i].getName().equals("username")) {
            username = cookies[i].getValue();
          }
          if (cookies[i].getName().equals("password")) {
            password = cookies[i].getValue();
          }
        }
      }
      ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
      User1Service user1Service = (User1ServiceImpl) ctx.getBean("user1Service");
      user1 = user1Service.getUser1(username);
      if(user1 == null){
          user1 = new User1();
          user1.setUsername("");
          user1.setPassword(" ");
      }
      if (user1.getPassword().equals(password)){
    %>
    <div class="rightBox" id="userInfo">
      <div class="title"><span>用户信息</span></div>
      <p><span class="colDark"><%= username%></span></p>
      <%
        if (user1.getIsAdmin() == 1){
      %>
      <p>
        <span class="colDanger">你好，管理员！</span>
        <a href="/blog/admin/admin.action">进入管理</a>
      </p>
      <%
      }
      else {
      %>
      <p><span class="colDanger">你好，欢迎光临我的博客！</span></p>
      <%
        }
      %>

      <p><span class="colDark"><a href="javascript:;" id="logout">退出</a></span></p>
    </div>
    <%
    }
    else{
    %>
    <div class="rightBox" id="loginBox">
      <div class="title"><span>登录</span></div>
      <div class="line"><span class="colDark">用户名：</span><input name="username" type="text" /><em></em></div>
      <div class="line"><span class="colDark">密码：</span><input name="password" type="password" /><em></em></div>
      <div class="line"><span class="colDark"></span><button>登 录</button></div>
      <p class="textRight">还没注册？<a href="javascript:;" class="colMint">马上注册</a>　</p>
      <p class="colWarning textCenter" id="error2"></p>
    </div>

    <div class="rightBox" id="registerBox" style="display: none;">
      <div class="title"><span>注册</span></div>
      <div class="line"><span class="colDark">用户名：</span><input name="username" type="text" /></div>
      <div class="line"><span class="colDark">密码：</span><input name="password" type="password" /></div>
      <div class="line"><span class="colDark">确认：</span><input name="repassword" type="password" /></div>
      <div class="line"><span class="colDark"></span><button>注 册</button></div>
      <p class="textRight">已有账号？<a href="javascript:;" class="colMint">马上登录</a>　</p>
      <p class="colWarning textCenter" id="error1"></p>
    </div>
    <%
      }
    %>

  </div>

</main>

<footer></footer>

</body>
</html>

