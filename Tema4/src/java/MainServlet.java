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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
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
            Connection conn = null;
            
            switch (getServletContext().getInitParameter("DatabaseMethod")) {
                
                case "ConnectionPool":
                    try {
                        context = new InitialContext();
                        dataSource = (DataSource) context.lookup("java:app/public");
                        conn = dataSource.getConnection();
                    } catch (NamingException ex) {
                        Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    
                case "Singleton":
                    conn = DatabaseSingleton.getConnection();
                    break;
                    
                case "Session":
                    HttpSession session = request.getSession(true);
                    if (session.isNew()) {
                        session.setAttribute("conn", DatabaseUtils.createConnection());
                    }
                    conn = (Connection) session.getAttribute("conn");
            
            }
            
            try {
                Integer id = Integer.valueOf(request.getParameter("id"));
                out.write(DatabaseUtils.retrieveItem(conn, id));
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
            String remote_addr = request.getRemoteAddr();
            Integer request_time = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
            StringBuilder paramsBuilder = new StringBuilder();
            Map<String, String[]> parameterMap = request.getParameterMap();
            for(String key : parameterMap.keySet()) {
                paramsBuilder.append(key).append("=").append(parameterMap.get(key)[0]).append(";");
            }
            String request_params = paramsBuilder.toString();
            
            Context context = null;
            DataSource dataSource = null;
            Connection conn = null;
            
            switch (getServletContext().getInitParameter("DatabaseMethod")) {
                
                case "ConnectionPool":
                    try {
                        context = new InitialContext();
                        dataSource = (DataSource) context.lookup("java:app/public");
                        conn = dataSource.getConnection();
                    } catch (NamingException ex) {
                        Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    
                case "Singleton":
                    conn = DatabaseSingleton.getConnection();
                    break;
            
                case "Session":
                    HttpSession session = request.getSession(true);
                    if (session.isNew()) {
                        session.setAttribute("conn", DatabaseUtils.createConnection());
                    }
                    conn = (Connection) session.getAttribute("conn");
            
            }
            
            try {
                DatabaseUtils.insertItem(conn, id_, remote_addr, request_time, request_params);
                out.write("success");
            } catch (SQLException ex) {
                Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.write("error");
            }
        }
    }
}
