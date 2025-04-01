<%@page import="uts.isd.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="Styles/style.css">
    <script src="Styles/CustomElements.js"></script>
</head>
<body>

<pref-header></pref-header>
<div class="content">
    <div class="main-header">
        <h1>DAVEYS RECORD STORE</h1>
        <p>KPOP | HARDSTYLE | AND MORE</p>
    </div>
    <div class="main-content">
        <br>
        <%
            System.out.println("Registered Users: " + 6);
        %>
        <br><br>
        <a href="register.jsp">
            <button>ENTER</button>
        </a>

    </div>
</div>
<pref-footer></pref-footer>
</body>
</html>
