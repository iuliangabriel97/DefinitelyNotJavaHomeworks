package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import records.Categories;

import records.RecordBean;
import records.RecordContainer;

import captcha.CaptchaUtils;

/**
 *
 * @author LucianAlexandru
 */
@WebServlet(urlPatterns = {"/InputControllerServlet"})
public class InputControllerServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        super.init();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession(true);
        Categories categories;
        
        if (session.isNew())
        {
            categories = new Categories();
        }
        else
        {
            categories = (Categories)session.getAttribute("categories");
            
            if (categories == null)
            {
                categories = new Categories();
            }
        }
        
        session.setAttribute("categories", categories);
        
        getServletContext().log("Current categories " + categories.toString());
        
        response.setContentType("text/html");
        
        RequestDispatcher rd=request.getRequestDispatcher("input.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        if(CaptchaUtils.verify(gRecaptchaResponse) == false) {
            getServletContext().log("Invalid Captcha");
            request.setAttribute("error", "Invalid Captcha");
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            return;
        }
        
        Categories categories;
        RecordContainer recordContainer;
        HttpSession session = request.getSession(true);
        
        Cookie lastCategory = new Cookie("InputControllerServlet.lastCategory", request.getParameter("category"));
        lastCategory.setComment("Last category picked");
        lastCategory.setMaxAge(30*60); //in seconds
        response.addCookie(lastCategory);
        
        if (session.isNew())
        {
            recordContainer = new RecordContainer();
        }
        else
        {
            recordContainer = (RecordContainer)session.getAttribute("recordContainer");
            
            if (recordContainer == null)
            {
                recordContainer = new RecordContainer();
            }
        }
        
        categories = (Categories)session.getAttribute("categories");
        
        response.setContentType("text/html");
        
        RecordBean record=new RecordBean();
        record.setCategory(request.getParameter("category"));
        record.setKey(request.getParameter("key"));
        record.setValue(request.getParameter("value"));
        
        try {
            recordContainer.addRecord(record);
            session.setAttribute("recordContainer", new RecordContainer(recordContainer));
            session.setAttribute("categories", new Categories(categories));
            request.setAttribute("records",recordContainer.getAllRecords());
            RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        }  
        catch(Exception e){
            e.printStackTrace();
            getServletContext().log("Received the following exception " + e.toString());
            request.setAttribute("error", e.getMessage());
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }  
        
    }

}
