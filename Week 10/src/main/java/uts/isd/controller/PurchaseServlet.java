package uts.isd.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uts.isd.model.Album;
import uts.isd.model.Invoice;
import uts.isd.model.User;
import uts.isd.model.dao.DAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DAO dao = (DAO)session.getAttribute("db");
        int albumId = Integer.parseInt(req.getParameter("id"));
        Album album = new Album();
        album.setId(albumId);

        try {
            User chosenUser = (User)session.getAttribute("loggedInUser");
            Album chosenAlbum = dao.Albums().get(album);
            Invoice invoice = new Invoice(chosenUser, chosenAlbum);

            dao.Invoices().add(invoice);
            dao.Albums().delete(chosenAlbum); //For this use case, where pretending that buying an album removes it from the store
        } catch (SQLException e) {
            System.out.println("Could not delete album");
        }
        resp.sendRedirect("main.jsp");
    }
}
