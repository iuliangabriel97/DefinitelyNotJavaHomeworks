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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class CourseManager {
    
    private List<Course> courses = new ArrayList<Course>();

    public CourseManager() {}

    @PostConstruct
    public void populateList(){
        try {
            courses = DatabaseUtils.retrieveCourses();
        } catch (SQLException ex) {
            Logger.getLogger(CourseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Course> getCourses() {
        return courses;
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
