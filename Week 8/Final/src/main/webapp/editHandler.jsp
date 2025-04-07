<%@ page import="uts.isd.model.User" %>
<%@ page import="org.sqlite.core.DB" %>
<%@ page import="uts.isd.model.dao.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

  DBManager db = (DBManager)session.getAttribute("db");
  User user = (User)session.getAttribute("loggedInUser");

  String email = request.getParameter("email");
  String password = request.getParameter("password");
  String genre = request.getParameter("genre");

  user.setEmail(email);
  user.setPassword(password);
  user.setGenre(genre);

  db.updateUser(user);

  response.sendRedirect("index.jsp");
%>