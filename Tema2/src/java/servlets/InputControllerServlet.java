package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import records.RecordBean;
import records.RecordContainer;

/**
 *
 * @author LucianAlexandru
 */
@WebServlet(urlPatterns = {"/InputControllerServlet"})
public class InputControllerServlet extends HttpServlet {

    private RecordContainer recordContainer;
    
    @Override
    public void init() throws ServletException {
        super.init();
        recordContainer = new RecordContainer();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        RecordBean record=new RecordBean();
        record.setCategory(request.getParameter("category"));
        record.setKey(request.getParameter("key"));
        record.setValue(request.getParameter("value"));
        request.setAttribute("record",record);
        
        try {
            recordContainer.addRecord(record);
            RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        }  
        catch(Exception e){
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }  
        
    }

}
