
import entities.CoursePackageEntity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
public class CoursesPackage {
    private CoursePackageEntity entity = new CoursePackageEntity();

    public CoursePackageEntity getEntity() {
        return entity;
    }

    public void setEntity(CoursePackageEntity entity) {
        this.entity = entity;
    }
    
}
