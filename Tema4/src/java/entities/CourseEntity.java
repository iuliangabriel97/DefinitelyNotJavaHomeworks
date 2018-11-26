/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author roungureanu
 */
@Entity
public class CourseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    private Integer yearOfStudy;
    private Integer semester;
    
    @ManyToOne
    @JoinColumn( name = "lecturer_id", referencedColumnName = "id", nullable = false )
    private LecturerEntity lecturer;
        
    @ManyToOne
    @JoinColumn( name = "package_id", referencedColumnName = "id", nullable = true )
    private CoursePackageEntity coursePackage;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<PreferenceEntity> preferences;

    public CoursePackageEntity getCoursePackage() {
        return coursePackage;
    }

    public void setCoursePackage(CoursePackageEntity coursePackage) {
        this.coursePackage = coursePackage;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public LecturerEntity getLecturer() {
        return lecturer;
    }

    public void setLecturer(LecturerEntity lecturer) {
        this.lecturer = lecturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseEntity)) {
            return false;
        }
        CourseEntity other = (CourseEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CourseEntity[ id=" + id + " ]";
    }
    
}
