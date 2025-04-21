package uts.isd.controller;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

import java.sql.SQLException;

@WebListener
public class StartupListener implements ServletContextListener, HttpSessionListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("We runnin boiii");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        try {
            DBManager db = new DBManager(new DBConnector().getConnection());
            session.setAttribute("db", db);
        } catch (SQLException e) {
            System.out.println("Could not connect to database");
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("We stopped boiii");
    }
}
