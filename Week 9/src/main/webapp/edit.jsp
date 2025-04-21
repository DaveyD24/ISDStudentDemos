<%@ page import="uts.isd.model.User" %>
<%@ page import="uts.isd.model.dao.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  User user = (User)session.getAttribute("loggedInUser");
%>

<html>
<head>
  <title>Edit</title>
  <link rel="stylesheet" href="style.css">
  <script src="js/CustomElements.js"></script>
</head>
<body>

<pref-header></pref-header>
<div class="content">
  <div class="main-header">
    <h1>EDIT DETAILS</h1>
    <p>KEEP YOUR PASSWORD SECURE</p>
  </div>
  <div class="main-content">
    <form action="/EditDetailsServlet" method="post">
      <label for="email">Email</label>
      <input id="email" name="email" type="text" value=<%=user.getEmail()%>>

      <label for="password">Password</label>
      <input id="password" name="password" type="password" value=<%=user.getPassword()%>>

      <label for="genre">Favourite Genre</label>
      <select name="genre" id="genre">
        <option value="Kpop">Kpop</option>
        <option value="Hardstyle">Hardstyle</option>
        <option value="Trash">Trash</option>
      </select>

      <br>
      <input id="edit" type="submit" value="Save">
    </form>
    <div class="user-box">
      <form method="POST" action="/DeleteServlet">
        <button>Delete my Account</button>
      </form>
    </div>
  </div>
</div>
<pref-footer></pref-footer>
</body>
</html>
