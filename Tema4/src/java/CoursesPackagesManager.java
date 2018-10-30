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
public class CoursesPackagesManager {
    
    private List<CoursesPackage> coursesPackages = new ArrayList<CoursesPackage>();

    public CoursesPackagesManager() {}

    @PostConstruct
    public void populateList(){
        try {
            coursesPackages = DatabaseUtils.retrieveCoursePackages();
        } catch (SQLException ex) {
            Logger.getLogger(CoursesPackagesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<CoursesPackage> getCoursesPackages() {
        return coursesPackages;
    }

    public void setCoursesPackages(List<CoursesPackage> coursesPackages) {
        this.coursesPackages = coursesPackages;
    }
    
    public void addCoursePackage(CoursesPackage coursePackage) {
        try {
            DatabaseUtils.insertCoursePackage(coursePackage);
        } catch (SQLException ex) {
            Logger.getLogger(CoursesPackagesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
