
import entities.User;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @PersistenceContext(unitName = "DocManagerPU")
    private EntityManager em;
    
    public User insert(String name, String password, String role)
    {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        
        em.persist(user);
        
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!! PERSISTED USER");

        return user;
    }
    
    public User find(String username, String password) throws ServletException {

        
        List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
     
        System.out.println("!!!!!!!!!! THERE ARE USERS " + users.size());
        
        for (User u: users)
        {
            if (u.getName().equals(username) && u.getPassword().equals(password))
                return u;
        }
        
        return null;
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
}
