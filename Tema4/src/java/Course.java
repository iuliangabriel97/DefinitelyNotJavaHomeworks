/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */

import entities.CourseEntity;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Course {
    
    private CourseEntity entity = new CourseEntity();
    private Long lecturerId;
    private Long coursePackageId;

    public Long getCoursePackageId() {
        return coursePackageId;
    }

    public void setCoursePackageId(Long coursePackageId) {
        this.coursePackageId = coursePackageId;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public CourseEntity getEntity() {
        return entity;
    }

    public void setEntity(CourseEntity entity) {
        this.entity = entity;
    }
}
