package uts.isd.model.dao;

import uts.isd.model.Invoice;
import uts.isd.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceDBManager extends DBManager<Invoice> {
    public InvoiceDBManager(Connection connection) throws SQLException {
        super(connection);
    }

    public Invoice add(Invoice invoice) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO INVOICES (UserId, AlbumId) VALUES (?, ?)");
        preparedStatement.setInt(1, invoice.getUser().getId());
        preparedStatement.setInt(2, invoice.getAlbum().getId());
        preparedStatement.executeUpdate();
        return invoice;
    }

    public Invoice get(Invoice invoice) throws SQLException {
        return null;
    }

    public void update(Invoice oldInvoice, Invoice newInvoice) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE INVOICES SET UserId = ?, AlbumId = ? WHERE InvoiceId = ?");
        preparedStatement.setInt(1, newInvoice.getUser().getId());
        preparedStatement.setInt(2, newInvoice.getAlbum().getId());
        preparedStatement.setInt(3, oldInvoice.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Invoice invoice) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM INVOICES WHERE InvoiceId = ?");
        preparedStatement.setInt(1, invoice.getId());
        preparedStatement.executeUpdate();
    }
}
