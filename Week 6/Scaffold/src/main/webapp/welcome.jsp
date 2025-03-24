<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Genre"%>

<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String genre = request.getParameter("genre");
    boolean agreed = request.getParameter("tos") != null;

    String name = "";
    if (agreed) {
        name = email.split("@")[0];
    }

    String imagePath = "image/" + request.getParameter("genre").toLowerCase() + ".jpg";

%>
<style>
    .card {
        background-image: url(<%=imagePath%>);
    }
</style>
<html>
<head>
    <title>Daveys Record Store</title>
    <link rel="stylesheet" href="Styles/style.css">
    <script src="Styles/CustomElements.js"></script>
</head>
<body>
<pref-header></pref-header>
<div class="content">
    <div class="main-header">
        <%
            if (agreed) {
        %>
        <h1>WELCOME <%=name.toUpperCase()%></h1>
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
            if (agreed) {
        %>
        <div class="card">
            <p><%=name%></p>
            <p><%=genre%> Lover</p>
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