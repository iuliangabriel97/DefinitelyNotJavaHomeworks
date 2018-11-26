
import entities.CourseEntity;
import entities.CoursePackageEntity;
import entities.LecturerEntity;
import entities.PreferenceEntity;
import entities.StudentEntity;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */
public class DatabaseUtils {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/java_lab4";

   //  Database credentials
   static final String USER = "java_lab4";
   static final String PASS = "a";
   
   public static Connection createConnection() {
       try {
            Class.forName(JDBC_DRIVER).newInstance();
            return DriverManager.getConnection(DB_URL, USER, PASS);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
   
   public static void insertCourse(Course course) throws SQLException
   {        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();
        
        CourseEntity entity = course.getEntity();

        LecturerEntity lecturer = em.find(LecturerEntity.class, course.getLecturerId());
        if (course.getCoursePackageId() != null){
            CoursePackageEntity coursePackage = em.find(CoursePackageEntity.class, course.getCoursePackageId());
            entity.setCoursePackage(coursePackage);
        }
        else
        {
            entity.setCoursePackage(null);
        }
        
        entity.setLecturer(lecturer);
        
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        
        em.close();
        factory.close();
   }
   
   public static void insertLecturer(Lecturer lecturer) throws SQLException
   {        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(lecturer.getEntity());
        em.getTransaction().commit();
        
        em.close();
        factory.close();
   }
   
   public static void insertCoursePackage(CoursesPackage coursePackage) throws SQLException
   {        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(coursePackage.getEntity());
        em.getTransaction().commit();
        
        em.close();
        factory.close();
   }
   
   public static List<CoursesPackage> retrieveCoursePackages() throws SQLException
   {
        List<CoursesPackage> result = new ArrayList<CoursesPackage>();
        CoursesPackage coursePackage;
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT cp FROM CoursePackageEntity cp");
        List<CoursePackageEntity> entities = query.getResultList();
        
        for (CoursePackageEntity entity : entities)
        {
            coursePackage = new CoursesPackage();
            coursePackage.setEntity(entity);
            result.add(coursePackage);
        }
        
        em.close();
        factory.close();
        
        return result;      
   }
   
   public static List<Course> retrieveCourses(Connection conn) throws SQLException
   {
        List<Course> result = new ArrayList<Course>();
        Course course;
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT c FROM CourseEntity c");
        List<CourseEntity> entities = query.getResultList();
        
        for (CourseEntity entity : entities)
        {
            course = new Course();
            course.setEntity(entity);
            result.add(course);
        }
        
        em.close();
        factory.close();
        
        return result;  
   }
   
   public static List<Lecturer> retrieveLecturers() throws SQLException
   {
       
        List<Lecturer> result = new ArrayList<Lecturer>();
        Lecturer lecturer;
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT l FROM LecturerEntity l");
        List<LecturerEntity> entities = query.getResultList();
        
        for (LecturerEntity entity : entities)
        {
            lecturer = new Lecturer();
            lecturer.setEntity(entity);
            result.add(lecturer);
        }
        
        em.close();
        factory.close();
        
        return result;    
   }
   
   public static void insertItem(Connection conn, Integer id, String remote_addr, Integer request_time, String request_params) throws SQLException
   {
        Statement stmt = null;
        
        stmt = conn.createStatement();
        String query = "INSERT INTO public.lab6(id, request_time, remote_addr, request_params) " + 
                "VALUES (" + id + "," + request_time + ",'" + remote_addr + "','" + request_params + "')";
        stmt.executeUpdate(query);
   }
   
   public static String retrieveItem(Connection conn, Integer id) throws SQLException
   { 
        Statement stmt = null;
     
        
        stmt = conn.createStatement();
        String query = "SELECT id, remote_addr, request_time, request_params FROM public.lab6 WHERE id = " + id;
        ResultSet rs = stmt.executeQuery(query);
        
        Integer id_ = null;
        int request_time = 0;
        String remote_addr = "", request_params = "";
        while(rs.next())
        {
             //Retrieve by column name
            id_  = rs.getInt("id");
            remote_addr = rs.getString("remote_addr");
            request_params = rs.getString("request_params");
            request_time = rs.getInt("request_time");   
            
            break;
        }
        
        rs.close();
        stmt.close();
        
        if (id_ != null)
            return String.valueOf(id_) + "|" + remote_addr + "|" + request_params + "|" + request_time;
        else
            return "not found";
   }
   
    public static List<StudentEntity> retrieveAllStudents() throws SQLException {
       
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT c FROM StudentEntity c");
        List<StudentEntity> entities = query.getResultList();
        
        em.close();
        factory.close();
        
        return entities; 
   }
    
    public static void insertStudent(StudentEntity student) throws SQLException
   {        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        
        em.close();
        factory.close();
   }
    
    public static void insertPreference(PreferenceEntity preference) throws SQLException
   {        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(preference);
        em.getTransaction().commit();
        
        em.close();
        factory.close();
   }
}