
import entities.PreferenceEntity;
import entities.StudentEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LucianAlexandru
 */
@ManagedBean
@RequestScoped
public class StudentManager {

    public List<StudentEntity> getStudents() {
        try {
            return DatabaseUtils.retrieveAllStudents();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerManager.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<StudentEntity>();
        }
    }
    
    public List<StudentEntity> getIncompleteStudents () {
        try {
            return DatabaseUtils.retrieveIncompleteStudents();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerManager.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<StudentEntity>();
        }
    }

    public void addStudent(StudentEntity student) {
        try {
            DatabaseUtils.insertStudent(student);
        } catch (SQLException ex) {
            Logger.getLogger(LecturerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addPreference(PreferenceEntity preference) {
        try {
            DatabaseUtils.insertPreference(preference);
        } catch (SQLException ex) {
            Logger.getLogger(LecturerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
