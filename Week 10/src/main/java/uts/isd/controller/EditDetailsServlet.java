package uts.isd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DAO;
import uts.isd.model.dao.DBManager;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EditDetailsServlet")
public class EditDetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        DAO db = (DAO)session.getAttribute("db");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String genre = req.getParameter("genre");

        User existingUser = (User)session.getAttribute("loggedInUser");
        User newUser = new User(email, password, genre);

        try {
            db.Users().update(existingUser, newUser);
            session.setAttribute("loggedInUser", newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("index.jsp");
    }
}
