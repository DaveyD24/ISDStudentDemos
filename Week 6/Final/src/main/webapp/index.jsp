<%@page import="uts.isd.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%

    User user = (User)session.getAttribute("loggedInUser");

%>

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
            <a href="LogoutHandler.jsp"><button>LOGOUT</button></a>
        </div>
        <%
            }
        %>
    </div>
</div>
<pref-footer></pref-footer>
</body>
</html>

<script>

    function logout() {
        window.location.href = "LogoutHandler.jsp";
    }
</script>