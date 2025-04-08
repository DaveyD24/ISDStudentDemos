<%@ page import="uts.isd.model.User" %>
<%@ page import="uts.isd.model.dao.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    User user = (User)session.getAttribute("loggedInUser");
    DBManager db = (DBManager)session.getAttribute("db");

    db.removeUser(user);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
