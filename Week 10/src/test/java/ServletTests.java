import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.Test;
import org.mockito.Mockito;
import uts.isd.controller.RegisterServlet;
import uts.isd.model.dao.DAO;
import uts.isd.model.dao.DBConnector;

import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class ServletTests {

    @Test
    public void testInvalidRegister() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getParameter("email")).thenReturn("david@testing.uts");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("genre")).thenReturn("Kpop");
        when(request.getParameter("tos")).thenReturn(null);

        RegisterServlet servlet = new RegisterServlet();
        servlet.doPost(request, response);

        verify(session).setAttribute(eq("loggedInUser"), eq(null));
    }

    @Test
    public void testValidRegister() throws ServletException, IOException, SQLException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        DAO dao = new DAO();


        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("db")).thenReturn(dao);
        when(request.getParameter("email")).thenReturn("david@testing.uts");
        when(request.getParameter("password")).thenReturn("123");
        when(request.getParameter("genre")).thenReturn("Kpop");
        when(request.getParameter("tos")).thenReturn("on");

        RegisterServlet servlet = new RegisterServlet();
        servlet.doPost(request, response);

        verify(session).setAttribute(eq("loggedInUser"), any());
    }
}
