<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="ex" uri="/WEB-INF/CustomTags.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language :
       not empty sessionScope.language ? sessionScope.language :
       pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="messages" var="lang"/>
<!DOCTYPE html>
<html>

<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../resources/css/reset.css" type="text/css" media="all">
    <link rel="stylesheet" href="../resources/css/layout.css" type="text/css" media="all">
    <link rel="stylesheet" href="../resources/css/style.css" type="text/css" media="all">
    <link rel="stylesheet" type="text/css" href="../resources/css/cs-select.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/cs-skin-border.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/normalize.css"/>
</head>

<body id="pageFlights">
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
                            <li><a href="${pageContext.request.contextPath}/JSPs/index.jsp">
                                <fmt:message bundle="${lang}" key="home"/></a></li>
                            <li><a href="${pageContext.request.contextPath}/JSPs/flights.jsp">
                                <fmt:message bundle="${lang}" key="flights"/></a></li>
                            <li><a href="${pageContext.request.contextPath}/JSPs/safety.jsp">
                                <fmt:message bundle="${lang}" key="safety"/></a></li>
                            <li><a href="${pageContext.request.contextPath}/JSPs/contacts.jsp">
                                <fmt:message bundle="${lang}" key="contacts"/></a></li>
                        </ul>
                    </nav>
                </div>
                <div class="logreg">
                    <nav>
                        <ul>
                            <li><a class="authentification" href="registration.jsp">Registration</a></li>
                            <li><a class="authentification" href="login.jsp">Sign in</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="language">
                    <nav>
                        <form>
                            <select class="cs-select cs-skin-border" id="language" name="language" onchange="submit()">
                                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                                <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
                            </select>
                        </form>
                    </nav>
                </div>
            </div>
        </header>
    </div>
</div>
<!-- / header -->
<div class="main">
    <!-- content -->
    <section id="content">
        <article class="col1">
            <div class="pad_1">
                <h2>Your Flight Planner</h2>

                <form id="form_1" action="controller" method="post">

                    <div class="wrapper pad_bot1">

                    </div>
                    <div class="wrapper">
                        Leaving From:
                        <div class="bg"><input type="text" name="fromCity" class="input input1"
                                               value="Enter City or Airport Code"
                                               onblur="if(this.value=='') this.value='Enter City or Airport Code'"
                                               onFocus="if(this.value =='Enter City or Airport Code' ) this.value=''">
                        </div>
                    </div>
                    <div class="wrapper">
                        Going To:
                        <div class="bg"><input type="text" name="toCity" class="input input1"
                                               value="Enter City or Airport Code"
                                               onblur="if(this.value=='') this.value='Enter City or Airport Code'"
                                               onFocus="if(this.value =='Enter City or Airport Code' ) this.value=''">
                        </div>
                    </div>
                    <div class="wrapper">
                        Departure Date and Time:
                        <div class="wrapper">
                            <div class="bg left"><input type="text" class="input input2" value="mm/dd/yyyy "
                                                        onblur="if(this.value=='') this.value='mm/dd/yyyy '"
                                                        onFocus="if(this.value =='mm/dd/yyyy ' ) this.value=''"></div>
                            <div class="bg right"><input type="text" class="input input2" value="12:00am"
                                                         onblur="if(this.value=='') this.value='12:00am'"
                                                         onFocus="if(this.value =='12:00am' ) this.value=''"></div>
                        </div>
                    </div>
                    <div class="wrapper">
                        Return Date and Time:
                        <div class="wrapper">
                            <div class="bg left"><input type="text" class="input input2" value="mm/dd/yyyy "
                                                        onblur="if(this.value=='') this.value='mm/dd/yyyy '"
                                                        onFocus="if(this.value =='mm/dd/yyyy ' ) this.value=''"></div>
                            <div class="bg right"><input type="text" class="input input2" value="12:00am"
                                                         onblur="if(this.value=='') this.value='12:00am'"
                                                         onFocus="if(this.value =='12:00am' ) this.value=''"></div>
                        </div>
                    </div>

                    <div class="wrapper">
                        <p>Passenger(s):</p>

                        <div class="bg left"><input type="text" class="input input2" value="# passengers"
                                                    onblur="if(this.value=='') this.value='# passengers'"
                                                    onFocus="if(this.value =='# passengers' ) this.value=''"></div>
                        <input type="submit" name="send" value="searchFlights" class="button2">go!</input>
                    </div>


                    <form action='controller' method="post">
                        id рейса: <input type='text' name='flightId' value=''/>
                        багаж: <input type='checkbox' name='luggage'>
                        <input type="submit" name="send" value="bookFlight"/>
                    </form>

                </form>
            </div>

        </article>
    </section>
    <section id="tableOfFlights">
        <ex:flightsTable cityFrom="${param.get('fromCity')}"
                         cityTo="${param.get('toCity')}"/>
    </section>
</div>
<div id="footer">
    <div class="main">
    </div>
</div>
</body>
</html>