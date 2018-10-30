
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/java_lab4";

   //  Database credentials
   static final String USER = "java_lab4";
   static final String PASS = "a";
   
   
   public static void insertCourse(Course course) throws SQLException
   {
        Connection conn = null;
        Statement stmt = null;
       
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        String coursePackage;
        String lecturerId;
        
        if (course.getPackage_() == null)
            coursePackage = "NULL";
        else
            coursePackage = course.getPackage_().toString();
        
        if (course.getLecturer_id() == null)
            lecturerId = "NULL";
        else
            lecturerId = course.getLecturer_id().toString();
        
        stmt = conn.createStatement();
        String query = "INSERT INTO courses(name, \"yearOfStudy\", semester, package, lecturer_id) VALUES ("
                + "'" + course.getName() + "',"
                + course.getYearOfStudy().toString()
                + ","
                + course.getSemester().toString()
                + ","
                + coursePackage
                + ","
                + lecturerId
                + ")";
        stmt.executeUpdate(query);
   }
   
   public static void insertLecturer(Lecturer lecturer) throws SQLException
   {
        Connection conn = null;
        Statement stmt = null;
       
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        stmt = conn.createStatement();
        String query = "INSERT INTO teachers(name, website) VALUES ("
                + "'" + lecturer.getName() + "','"
                + lecturer.getUrl()
                + "')";
        stmt.executeUpdate(query);
   }
   public static void insertCoursePackage(CoursesPackage coursePackage) throws SQLException
   {
        Connection conn = null;
        Statement stmt = null;
       
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        stmt = conn.createStatement();
        String query = "INSERT INTO courses_packages(year, semester) " + 
                "VALUES (" + coursePackage.getYear() + "," + coursePackage.getSemester() + ")";
        stmt.executeUpdate(query);
   }
   
   public static List<CoursesPackage> retrieveCoursePackages() throws SQLException
   {
        List<CoursesPackage> result = new ArrayList<CoursesPackage>();
        
        CoursesPackage coursePackage;
       
        Connection conn = null;
        Statement stmt = null;
       
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        stmt = conn.createStatement();
        String query = "SELECT id, year, semester FROM courses_packages";
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next())
        {
             //Retrieve by column name
            int id  = rs.getInt("id");
            Integer yearOfStudy = rs.getInt("year");
            Integer semester = rs.getInt("semester");

            coursePackage = new CoursesPackage();
            coursePackage.setId(id);
            coursePackage.setSemester(semester);
            coursePackage.setYear(yearOfStudy);
            
            result.add(coursePackage);
        }
        
        rs.close();
        stmt.close();
        conn.close();
    
        return result;      
   }
   
   public static List<Course> retrieveCourses() throws SQLException
   {
        List<Course> result = new ArrayList<Course>();
        
        Course course;
       
        Connection conn = null;
        Statement stmt = null;
       
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        stmt = conn.createStatement();
        String query = "SELECT id, name, \"yearOfStudy\", semester, package, lecturer_id FROM courses";
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next())
        {
             //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            Integer yearOfStudy = rs.getInt("yearOfStudy");
            Integer semester = rs.getInt("semester");
            Integer package_ = rs.getInt("package");
            if (rs.wasNull())
                package_ = null;
            Integer lecturer_id = rs.getInt("lecturer_id");
            if (rs.wasNull())
                lecturer_id = null;
            
            course = new Course();
            course.setName(name);
            course.setSemester(semester);
            course.setYearOfStudy(yearOfStudy);
            course.setPackage_(package_);
            course.setLecturer_id(lecturer_id);
            
            Lecturer lecturer = null;
            if (lecturer_id != null)
                lecturer = DatabaseUtils.retrieveLecturer(lecturer_id);
            
            course.setLecturer(lecturer);
            
            result.add(course);
        }
        
        rs.close();
        stmt.close();
        conn.close();
    
        return result;      
   }
   
   public static List<Lecturer> retrieveLecturers() throws SQLException
   {
        List<Lecturer> result = new ArrayList<Lecturer>();
        
        Lecturer lecturer;
       
        Connection conn = null;
        Statement stmt = null;
       
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        stmt = conn.createStatement();
        String query = "SELECT id, name, website FROM teachers";
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next())
        {
             //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            String website = rs.getString("website");

            lecturer = new Lecturer();
            lecturer.setId(id);
            lecturer.setName(name);
            lecturer.setUrl(website);
            
            result.add(lecturer);
        }
        
        rs.close();
        stmt.close();
        conn.close();
    
        return result;      
   }
   
   public static Lecturer retrieveLecturer(Integer lecturer_id) throws SQLException
   { 
        Lecturer lecturer = null;
       
        Connection conn = null;
        Statement stmt = null;
       
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        stmt = conn.createStatement();
        String query = "SELECT id, name, website FROM teachers WHERE id = " + lecturer_id;
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next())
        {
             //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            String website = rs.getString("website");

            lecturer = new Lecturer();
            lecturer.setName(name);
            lecturer.setUrl(website);
            
            break;
        }
        
        rs.close();
        stmt.close();
        conn.close();
    
        return lecturer;
   }
}