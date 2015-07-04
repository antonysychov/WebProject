<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />

<!DOCTYPE html>
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
                        <select class="cs-select cs-skin-border" id="language" name="language" onchange="submit()">
                            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                            <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
                        </select>
                    </nav>
                </div>
            </div>
        </header>
    </div>
</div>
<div id="content">
    <div class="main">
        <div id="banner">
            <div class="text1">
                COMFORT<span>Guaranteed</span>

                <p>
                    Don't worry, there have not been a plane that hasn't returned to land.</p>
            </div>
            <a href="${pageContext.request.contextPath}/JSPs/flights.jsp" class="button_top">Order Tickets Online</a>
        </div>
    </div>
</div>
<!-- / header -->
<div id="footer">
    <div class="main">

    </div>
</div>
</body>
</html>
