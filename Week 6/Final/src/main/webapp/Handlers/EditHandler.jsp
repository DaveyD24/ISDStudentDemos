<%@ page import="uts.isd.model.User" %>
<%@ page import="uts.isd.model.Genre" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String email = request.getParameter("email");
  String password = request.getParameter("password");
  String genre = request.getParameter("genre");

  User user = (User)session.getAttribute("loggedInUser");
  user.setEmail(email);
  user.setPassword(password);
  user.setGenre(genre.equalsIgnoreCase("kpop") ? Genre.KPOP : Genre.HARDSTYLE);

  session.setAttribute("loggedInUser", user);
  response.sendRedirect("../index.jsp");
%>