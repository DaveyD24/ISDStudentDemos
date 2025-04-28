<%@ page import="uts.isd.model.Album" %>
<%@ page import="uts.isd.model.dao.DAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  DAO db = (DAO)session.getAttribute("db");
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
      <p>SEE OUR COLLECTION</p>
    </div>
    <div class="main-content">
      <div class="album-container">
        <%
          for (Album album : db.Albums().allAlbums()) {
            String imagePath = "image/album/" + album.getTitle().toLowerCase().replace(' ', '_') + ".jpg";
        %>
        <div class="album-card">
          <p><%=album.getTitle()%></p>
          <img src=<%=imagePath%> />
          <p><%=album.getArtist()%></p>
          <form method="post" action="/PurchaseServlet">
            <input type="hidden" name="id" value="<%=album.getId()%>">
            <input id="reg" type="submit" value="PURCHASE">
          </form>
        </div>
        <%
          }
        %>
      </div>
    </div>
  </div>



<pref-footer></pref-footer>
</body>
</html>
