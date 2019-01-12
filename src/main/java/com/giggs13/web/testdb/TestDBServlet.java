package com.giggs13.web.testdb;

import com.mysql.cj.jdbc.Driver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/test-db-servlet")
public class TestDBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "springstudent";
        String password = "springstudent";
        //String driver = "com.mysql.cj.jdbc.Driver";

        try (PrintWriter out = response.getWriter()) {
            out.println("Connection to database: " + url);
            //Class.forName(driver);
            DriverManager.registerDriver(new Driver());
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                out.println("Connection has been given!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
