<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 23.06.2015
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <title></title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="../resources/css/reset.css" type="text/css" media="all">
  <link rel="stylesheet" href="../resources/css/layout.css" type="text/css" media="all">
  <link rel="stylesheet" href="../resources/css/style.css" type="text/css" media="all">
  <link rel="stylesheet" type="text/css" href="../resources/css/cs-skin-border.css"/>
  <link rel="stylesheet" type="text/css" href="../resources/css/normalize.css"/>
</head>

<body id="page1">
<div id="header">
  <div class="main">
    <!-- header -->
    <header>
      <div class="wrapper">
        <div class="left">
          <nav>
            <a href="${pageContext.request.contextPath}/JSPs/index.jsp" id="logo">Air Lines</a>
            <span id="slogan">Low-Cost airlines</span>
          </nav>
        </div>
        <div class="middle">
          <nav>
            <ul id="menu">
              <li><a href="${pageContext.request.contextPath}/JSPs/index.jsp">Home</a></li>
              <li><a href="${pageContext.request.contextPath}/JSPs/flights.jsp">Flights</a></li>
              <li><a href="${pageContext.request.contextPath}/JSPs/safety.jsp">Safety</a></li>
              <li><a href="${pageContext.request.contextPath}/JSPs/contacts.jsp">Contacts</a></li>
            </ul>
          </nav>
        </div>
        <div class="logreg">
          <nav>
            <ul>
              <li><a class="authentification" href="${pageContext.request.contextPath}/JSPs/registration.jsp">Registration</a></li>
              <li><a class="authentification" href="${pageContext.request.contextPath}/JSPs/login.jsp">Sign in</a></li>
            </ul>
          </nav>
        </div>
        <div class="language">
          <nav>
            <select class="cs-select cs-skin-border">
              <option selected="selected">English</option>
              <option>Russian</option>
            </select>
          </nav>
        </div>
      </div>
    </header>
  </div>
</div>
<div id="content">
  <div class="main">
    <form action='controller' method="post">
      <p>Login: <input type='text' name='login' value=''/></p>
      <p>Password: <input type='text' name='password' value=''/></p>
      <input type="submit" name="send" value="sign in"/>
    </form>
  </div>
</div>
<!-- / header -->
<div id="footer">
  <div class="main">
  </div>
</div>
</body>
</html>
