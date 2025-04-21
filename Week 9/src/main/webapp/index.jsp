<%@page import="uts.isd.model.User" %>
<%@page import="uts.isd.model.dao.*"%>
<%@ page import="java.sql.SQLException" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
    DBManager db = (DBManager)session.getAttribute("db");
%>

<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" href="style.css">
        <script src="js/CustomElements.js"></script>
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
            <a href="register.jsp"><button>ENTER</button></a>

            <div class="login">
                <p>Currently logged-in user:
                    <%
                        if (session.getAttribute("loggedInUser") == null) {
                    %>
                    No one
                    <%
                        }
                        else {
                    %>
                    <%=((User)session.getAttribute("loggedInUser")).getEmail()%>
                    <%
                        }
                    %>
                </p>
            </div>
            <%
                if ((session.getAttribute("loggedInUser") != null) ) {
            %>
            <div class="user-box">
                <a href="edit.jsp"><button>Edit Details</button></a>
                <form action="/LogoutServlet" method="post">
                    <button>LOGOUT</button>
                </form>
            </div>
            <%
                }
            %>

        </div>
    </div>
    <pref-footer></pref-footer>
    </body>
</html>