/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Course {
    
    private String name;
    private Integer yearOfStudy;
    private Integer semester;
    private Integer package_;
    private Integer lecturer_id;
    private Lecturer lecturer;
    
    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getPackage_() {
        return package_;
    }

    public void setPackage_(Integer package_) {
        this.package_ = package_;
    }

    public Integer getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(Integer lecture_id) {
        this.lecturer_id = lecture_id;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
    
    
    
}
