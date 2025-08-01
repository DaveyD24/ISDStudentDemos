package uts.isd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("loggedInUser");
        DBManager db = (DBManager)session.getAttribute("db");

        try {
            db.removeUser(user);
        } catch (SQLException e) {
            System.out.format("Failed to %s from the database", user.getEmail());
        }
        session.removeAttribute("loggedInUser");
        resp.sendRedirect("index.jsp");
    }
}
