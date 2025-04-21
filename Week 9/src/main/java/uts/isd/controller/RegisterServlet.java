package uts.isd.controller;

import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager db = ((DBManager)req.getSession().getAttribute("db"));
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String genre = req.getParameter("genre");
        boolean agreed = req.getParameter("tos") != null;
        String name = email.split("@")[0];
        session.setAttribute("name", name);

        if (agreed) {
            User user = new User(email, password, genre);
            session.setAttribute("loggedInUser", user);
            try {
                db.addUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String imagePath = "image/" + req.getParameter("genre").toLowerCase() + ".jpg";
        session.setAttribute("imagePath", imagePath);
        resp.sendRedirect("welcome.jsp");
    }
}
