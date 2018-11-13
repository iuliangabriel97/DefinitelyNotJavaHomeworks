/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet(urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        super.init();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/plain;charset=UTF-8");           
            Context context = null;
            DataSource dataSource = null;
            try {
                try {
                    context = new InitialContext();
                } catch (NamingException ex) {
                    Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                dataSource = (DataSource) context.lookup("java:app/public");
            } catch (NamingException ex) {
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Integer id = Integer.valueOf(request.getParameter("id"));
                out.write(DatabaseUtils.retrieveItem(dataSource.getConnection(), id));
            } catch (SQLException ex) {
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.write("error");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/plain;charset=UTF-8");        
            
            Integer id_ = Integer.valueOf(request.getParameter("id"));   
            String remote_addr = "whatevs";
            Integer request_time = 1;
            String request_params = "params";
            
            Context context = null;
            DataSource dataSource = null;
            try {
                try {
                    context = new InitialContext();
                } catch (NamingException ex) {
                    Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                dataSource = (DataSource) context.lookup("java:app/public");
            } catch (NamingException ex) {
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                DatabaseUtils.insertItem(dataSource.getConnection(), id_, remote_addr, request_time, request_params);
                out.write("success");
            } catch (SQLException ex) {
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.write("error");
            }
        }
    }
}
