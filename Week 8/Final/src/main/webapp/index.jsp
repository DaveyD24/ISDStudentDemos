<%@page import="uts.isd.model.User" %>
<%@ page import="uts.isd.model.dao.DBManager" %>
<%@ page import="uts.isd.model.dao.DBConnector" %>
<%@ page import="java.sql.SQLException" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%

    User user = (User)session.getAttribute("loggedInUser");
    DBManager db = (DBManager) session.getAttribute("db");
    if (db == null) {
        try {
            db = new DBManager(new DBConnector().getConnection());
            session.setAttribute("db", db);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
        }
    }
%>

<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="style.css">
    <script src="CustomElements.js"></script>
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
        <p>Registered Users: <%=db.getUserCount()%></p>
        <br><br>
        <a href="register.jsp">
            <button>ENTER</button>
        </a>

        <div class="login">
            <p>Logged in user:
                <%
                    if (user == null) {
                %>
                No one
                <%
                }
                else {
                %>
                <%=user.getEmail()%>
                <%
                    }
                %>
            </p>
        </div>
        <%
            if (user != null) {
        %>
        <div class="user-box">
            <a href="edit.jsp"><button>EDIT DETAILS</button></a>
            <a href="logoutHandler.jsp"><button>LOGOUT</button></a>
        </div>
        <%
            }
        %>
    </div>
</div>
<pref-footer></pref-footer>
</body>
</html>