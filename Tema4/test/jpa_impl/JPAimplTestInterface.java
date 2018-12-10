package jpa_impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author LucianAlexandru
 */
public class JPAimplTestInterface {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    @BeforeClass
    public static void init() throws SQLException {
        emf = Persistence.createEntityManagerFactory("Tema4PU");
        em = emf.createEntityManager();
    }
    
    @AfterClass
    public static void tearDown(){
        em.clear();
        em.close();
        emf.close();
    }
}
