
import javax.ejb.Stateless;
import javax.servlet.ServletException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LucianAlexandru
 */

@Stateless
public class UserService {
    
    User find(String username, String password) throws ServletException {
        if (username == "admin" && password == "admin")
            return new User();
        throw new ServletException();
    }
    
}
