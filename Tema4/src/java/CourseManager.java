/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LucianAlexandru
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean
@RequestScoped
public class CourseManager {
    
    private List<Course> courses = new ArrayList<Course>();
    private List<Lecturer> lecturers = new ArrayList<Lecturer>();

    @Resource(mappedName = "jdbc/public")
//    @Resource(mappedName = "jdbc/public")
//    @Resource(name = "jdbc/matematica")
    private DataSource dataSource;
    
    public CourseManager() {
//        Hashtable env = new Hashtable();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//        DataSource ds = new org.postgresql.ds.PGSimpleDataSource();
//        ds.setDatabase("jdbc:postgresql://localhost:5432/sample");
//        ctx.bind("jdbc/sample", ds);
//        ctx.close();



//        Context context;
//        try {
//            context = new InitialContext(env);
//            dataSource = (DataSource) context.lookup("jdbc/myDatasource");
//        } catch (NamingException ex) {
//            Logger.getLogger(CourseManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @PostConstruct
    public void populateList(){
        try {
            courses = DatabaseUtils.retrieveCourses(dataSource.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(CourseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            lecturers = DatabaseUtils.retrieveLecturers();
        } catch (SQLException ex) {
            Logger.getLogger(CourseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Lecturer> getLecturers()
    {
        return lecturers;
    }
    
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    public void addCourse(Course course) {
        try {
            DatabaseUtils.insertCourse(course);
        } catch (SQLException ex) {
            Logger.getLogger(CourseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
