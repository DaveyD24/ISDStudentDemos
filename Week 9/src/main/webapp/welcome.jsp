<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="uts.isd.model.User"%>
<%@ page import="uts.isd.model.dao.DBConnector" %>
<%@ page import="uts.isd.model.dao.DBManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.IOException" %>

<style>
    .card {
        background-image: url(<%=session.getAttribute("imagePath")%>);
    }
</style>
<html>
<head>
    <title>Daveys Record Store</title>
    <link rel="stylesheet" href="style.css">
    <script src="js/CustomElements.js"></script>
</head>
<body>
<pref-header></pref-header>
<div class="content">
    <div class="main-header">
        <%
            User user = (User)session.getAttribute("loggedInUser");
            if (user != null) {
        %>
        <h1>WELCOME <%=((String)session.getAttribute("name")).toUpperCase()%></h1>
        <p>WE HOPE YOU ENJOY YOUR STAY</p>
        <%
        }
        else {
        %>
        <h1>ENTRY DENIED</h1>
        <p>PLEASE AGREE TO THE TERMS OF SERVICE</p>
        <%
            }
        %>
    </div>
    <div class="main-content">
        <%
            if (user != null) {
        %>
        <div class="card">
            <p><%=session.getAttribute("name")%></p>
            <p><%=user.getGenre()%> Lover</p>
        </div>
        <%
        }
        else {
        %>
        <a href="index.jsp"><button>RETURN HOME</button></a>
        <%
            }
        %>
    </div>
</div>
<pref-footer></pref-footer>
</body>
</html>