
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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

@ManagedBean
@RequestScoped
public class Search {
    private String courseName;
    private String yearOfStudy;
    private String semester;
    
    private Boolean optionalCourse;
    
    private List<Course> courses = new ArrayList<Course>();

    private DataSource dataSource;

    public Search() {
        Context context;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:app/public");
        } catch (NamingException ex) {
            Logger.getLogger(CourseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Boolean getOptionalCourse() {
        return optionalCourse;
    }

    public void setOptionalCourse(Boolean optionalCourse) {
        this.optionalCourse = optionalCourse;
    }
    
    public void doSearch() throws SQLException
    {
        this.courses = DatabaseUtils.searchCourses(stringToInteger(yearOfStudy), stringToInteger(semester), courseName, optionalCourse);
    }

    private Integer stringToInteger(String str) {
        if (str == null || str.length() == 0)
            return null;
        return Integer.valueOf(str);
    }
    
    @Override
    public String toString() {
        return "Search{" + "courseName=" + courseName + ", yearOfStudy=" + yearOfStudy + ", semester=" + semester + ", optionalCourse=" + optionalCourse + '}';
    }
}
