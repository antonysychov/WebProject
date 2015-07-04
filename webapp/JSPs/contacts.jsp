<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 24.06.2015
  Time: 10:57
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

<body id="pageContacts">
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
    <section id="content1">
      <article class="col1">
        <div class="pad_1">
          <h2>Contact Us</h2>
				<span class="cols">
					Country:<br>
					City:<br>
					Telephone:<br>
					Email:
				</span>
          USA<br>
          San Diego<br>
          +354 5635600<br>
          <a href="mailto:">businessco@mail.com</a>
          <h2>Miscellaneous Info</h2>
          <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia.</p>
        </div>
      </article>
      <article class="col2 pad_left1">
        <h2>Contact Form</h2>
        <form id="ContactForm" action="">
          <div>
            <div class="wrapper">
              <div class="bg"><input type="text" class="input" /></div>
              Your Name:<br />
            </div>
            <div class="wrapper">
              <div class="bg"><input type="text" class="input" /></div>
              Your E-mail:<br />
            </div>
            <div class="wrapper">
              <div class="bg">
                <textarea name="textarea" cols="1" rows="1"></textarea>
              </div>
              Your Message:<br />
            </div>
            <a href="#" class="button1" onClick="document.getElementById('ContactForm').submit()">submit</a>
            <a href="#" class="button1" onClick="document.getElementById('ContactForm').reset()">reset</a>
          </div>
        </form>
      </article>
    </section>
  </div>
</div>
<!-- / header -->
<div id="footer">
  <div class="main">
  </div>
</div>
</body>
</html>
